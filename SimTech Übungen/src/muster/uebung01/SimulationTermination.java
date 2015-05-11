package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * SimulationTermination is a special SimEvent. This class is used to terminate the simulation.
 *
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */
public class SimulationTermination extends SimEvent {

	/**
	 * Constructor that uses the given argument
	 *
	 * @param time
	 *            Representing the simulation time at which the event occurs.
	 */
	public SimulationTermination(long time) {
		// see SimEvent
		super(time);
		inter_class_priority = 2;
		intra_class_priority = 0;
	}

	/**
	 * Function sets the stop boolean in the SimState to true which terminates the while-loop in the DES - mainclass
	 */
	public void process() {
		SimState.setStop(true);
	}
}