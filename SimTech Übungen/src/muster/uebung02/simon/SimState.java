package muster.uebung02.simon;
/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * SimState class 
 * The SimState holds information of the current simulation.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class SimState {
	
	/**
	 * Attribute: representing the current simulation time.
	 */
	private static long		now					= 0;
	/**
	 * Attribute: boolean used to indicate the termination of the simulation
	 */
	private static boolean	stop				= false;
	/**
	 * Attribute: simulation duration
	 */
	private static long		simulationDuration;
	/**
	 * Attribute: Number of waiting customers
	 */
	private static long		numPackets			= 0;
	/**
	 * Attribute: Number of blocked packets
	 */
	private static long		numBlockedPackets	= 0;
	
	/**
	 * SimState constructor Using the given arguments to initialize the SimState
	 * 
	 * @param iat
	 *            <-> interArrivalTime
	 * @param sct
	 *            <-> serviceCompletionTime
	 * @param sd
	 *            <-> simulationDuration
	 */
	public static void init(long sd)
	{
		now = 0;
		numPackets = 0;
		numBlockedPackets = 0;
		stop = false;
		simulationDuration = sd;
	}
	


	
	/**
	 * @return the now
	 */
	public static long getNow()
	{
		return now;
	}




	/**
	 * @param now the now to set
	 */
	public static void setNow(long now)
	{
		SimState.now = now;
	}




	/**
	 * @return the stop
	 */
	public static boolean isStop()
	{
		return stop;
	}




	/**
	 * @param stop the stop to set
	 */
	public static void setStop(boolean stop)
	{
		SimState.stop = stop;
	}




	/**
	 * @return the simulationDuration
	 */
	public static long getSimulationDuration()
	{
		return simulationDuration;
	}




	/**
	 * @param simulationDuration the simulationDuration to set
	 */
	public static void setSimulationDuration(long simulationDuration)
	{
		SimState.simulationDuration = simulationDuration;
	}




	/**
	 * @return the numPackets
	 */
	public static long getNumPackets()
	{
		return numPackets;
	}




	/**
	 * @param numPackets the numPackets to set
	 */
	public static void setNumPackets(long numPackets)
	{
		SimState.numPackets = numPackets;
	}




	/**
	 * @return the numBlockedPackets
	 */
	public static long getNumBlockedPackets()
	{
		return numBlockedPackets;
	}




	/**
	 * @param numBlockedPackets the numBlockedPackets to set
	 */
	public static void setNumBlockedPackets(long numBlockedPackets)
	{
		SimState.numBlockedPackets = numBlockedPackets;
	}




	/**
	 * Reacts on the accept of a packet
	 */
	public static void packet_accepted()
	{
		numPackets++;
	}
	
	/**
	 * Reacts on the drop of a packet
	 */
	public static void packet_dropped()
	{
		numPackets++;
		numBlockedPackets++;
	}
	
}
