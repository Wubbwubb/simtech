package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * SimState class The SimState holds the whole information of the current simulation.
 *
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */
public class SimState {

	/**
	 * Attribute: representing the current simulation time.
	 */
	private static long now;
	/**
	 * Attribute: boolean used to indicate the termination of the simulation
	 */
	private static boolean stop;

	// statistics: might better kept in a seperate class
	private static long numPackets;
	private static long numBlockedPackets;

	// initialize variables for static class SimState
	public static void init() {
		now = 0;
		stop = false;

		numPackets = 0;
		numBlockedPackets = 0;
	}

	// return simulation clock
	public static long getNow() {
		return now;
	}

	// set simulation clock
	public static void setNow(long now) {
		SimState.now = now;
	}

	// arrived at the simulation end
	public static boolean isStop() {
		return stop;
	}

	// set the simulation end
	public static void setStop(boolean stop) {
		SimState.stop = stop;
	}

	// return number of arrived packets
	public static long getNumPackets() {
		return numPackets;
	}

	// return number of dropped packets
	public static long getNumBlockedPackets() {
		return numBlockedPackets;
	}

	// update statistics: packet arrived and was accepted
	public static void packet_accepted() {
		numPackets++;
	}

	// update statistics: packet arrived and was dropped
	public static void packet_dropped() {
		numPackets++;
		numBlockedPackets++;
	}

}
