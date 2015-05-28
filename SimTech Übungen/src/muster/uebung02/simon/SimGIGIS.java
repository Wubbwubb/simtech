package muster.uebung02.simon;
/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * SimGIGIS class 
 * Mainclass performing the simulation.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class SimGIGIS {
	/**
	 * Main executing fuction
	 * @param iat inter arrival time for Customers
	 * @param S max queue length
	 * @param T simulation time
	 * @param doReport boolean - report or not
	 * 
	 * @param args
	 *            consoleparameters
	 */
	
	public static void doSimulation(int iat, int S, long T, boolean doReport)
	{
		SimState.init(T);
		SystemState.init(iat, S);
		EventChain.init();
		SimParam.init(S);
		CounterCollection.reset();
		/* Initialization of the global random number creator */
		RandVar.init();
		
		/*
		 * Checks if the number of arguments is correct and uses them for
		 * initialization of the simulation If the number of arguments is
		 * incorrect, the arguments are set to default values
		 */

		/* Insert the first and the last event */
		EventChain.insert(new CustomerArrival(0));
		EventChain.insert(new SimulationTermination(SimState
				.getSimulationDuration()));
		
		/*
		 * Simulation is run here
		 */
		while (!SimState.isStop())
		{
			// Get the next SimEvent from the EventChain
			SimEvent e = EventChain.removeOldestEvent();
			if (e != null)
			{
				if (SimState.getNow() > e.getTimeOfAppearance())
				{
					System.out
							.println("_____________________________________________________");
					System.out.println("ERROR");
					System.out.println("Event_Time" + e.getTimeOfAppearance());
					System.out.println("System_Time" + SimState.getNow());
					System.out
							.println("EVENT SHOULD BE ALREADY EXECUTED IN THE PAST");
					System.out
							.println("_____________________________________________________");
				}
				
				SimState.setNow(e.getTimeOfAppearance());
				CounterCollection.count_system_state();
				e.process();
				// SystemState.print();
			} else
			{
				System.out.println("EventChain is empty! Simulation abort!");
				SimState.setStop(true);
			}
		}
		if (doReport)
		{
			CounterCollection.report();
		}
		
	}
}
