package muster.uebung02.simon;
/**
 * Exercise 2 Simulationstechnink SS2015
 *
 * SimulationTermination class 
 * SimulationTermination is a special SimEvent. 
 * This class is used to terminate the simulation.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class SimulationTermination extends SimEvent {
	
	/**
	 * Constructor that uses the given argument
	 * 
	 * @param time
	 *            Representing the simulation time at which the event occurs.
	 */
	public SimulationTermination(long time)
	{
		super(time);
		this.inter_class_priority = 2;
		this.intra_class_priority = 0;
	}
	
	/**
	 * Function sets the stop boolean in the SimState to true which terminates
	 * the while-loop in the DES - mainclass
	 */
	@Override
	public void process()
	{
		SimState.setStop(true);
	}
}
