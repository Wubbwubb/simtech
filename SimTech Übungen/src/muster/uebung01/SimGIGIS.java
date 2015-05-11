package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * SimGIGI1S class Mainclass reading the arguments and performing the simulation.
 *
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */

public class SimGIGIS {
	/**
	 * Main executing function
	 * 
	 * @param args
	 *            console parameters
	 */

	public static long doSimulation(int iat, int S, long T, boolean makeReport) {
		SimParam.init(S, iat, T);
		SimState.init();
		SystemState.init();
		EventChain.init();
		/* Initialization of the global random number creator */
		RandVar.init();

		/*
		 * Checks if the number of arguments is correct and uses them for initialization of the simulation
		 * 
		 * If the number of arguments is incorrect, the arguments are set to default values
		 */

		/* Insert the first and the last event */
		EventChain.insert(new CustomerArrival(0));
		EventChain.insert(new SimulationTermination(SimParam.simulationduration));

		/*
		 * Simulation is run here
		 */
		while (!SimState.isStop()) {
			// Get the next SimEvent from the EventChain
			SimEvent e = EventChain.removeOldestEvent();
			if (e != null) {
				if (SimState.getNow() > e.getValue()) {
					System.out.println("_____________________________________________________");
					System.out.println("ERROR");
					System.out.println("Event_Time" + e.getValue());
					System.out.println("System_Time" + SimState.getNow());
					System.out.println("EVENT SHOULD BE ALREADY EXECUTED IN THE PAST");
					System.out.println("_____________________________________________________");
				}

				SimState.setNow(e.getValue());
				e.process();
				// SystemState.print();
			} else {
				System.out.println("EventChain is empty! Simulation abort!");
				SimState.setStop(true);
			}
		}

		// reporting
		if (makeReport) {
			System.out.println("angekommene Packet = " + SimState.getNumPackets());
			System.out.println("verworfene Pakete = " + SimState.getNumBlockedPackets());
			System.out.println("Packet Drop Probability = " + (double) SimState.getNumBlockedPackets()
					/ SimState.getNumPackets());
		}
		return SimState.getNumBlockedPackets();
	}
}
