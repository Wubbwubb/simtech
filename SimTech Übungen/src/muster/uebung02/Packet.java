package muster.uebung02;

/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * Packet class Basic class containing information for a single packet
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class Packet {
	/**
	 * Attribute: time of packet arrival
	 */
	private long t_arrival;
	/**
	 * Attribute: time of packet serving start
	 */
	private long t_start_service;
	/**
	 * Attribute: time of packet service completion
	 */
	private long t_completed;
	/**
	 * Attribute: boolean if packet is currently waiting
	 */
	private boolean isWaiting;
	/**
	 * Attribute: boolean if packet is currently served
	 */
	private boolean isServed;
	/**
	 * Attribute: boolean if packet serving already completed
	 */
	private boolean isCompleted;

	/**
	 * Create a Packet with arrival time t
	 * 
	 * @param t
	 *            arrival time
	 */
	public Packet(long t) {
		this.isWaiting = true;
		this.isServed = false;
		this.isCompleted = false;
		this.t_arrival = t;
		this.t_start_service = 0;
		this.t_completed = 0;
	}

	/**
	 * Start packet serving at time t
	 * 
	 * @param t
	 *            time of packet serving start
	 */
	public void startService(long t) {
		this.isWaiting = false;
		this.isServed = true;
		this.t_start_service = t;
	}

	/**
	 * Complete packet serving at time t
	 * 
	 * @param t
	 *            time of packet serving completion
	 */
	public void completeService(long t) {
		this.isServed = false;
		this.isCompleted = true;
		this.t_completed = t;
	}

	/**
	 * Returns waiting time of packet
	 * 
	 * @return waiting time
	 */
	public long getWaitingTime() {
		if (this.isServed | this.isCompleted) {
			return this.t_start_service - this.t_arrival;
		}
		return -1;
	}

	/**
	 * Returns service time of packet
	 * 
	 * @return service time
	 */
	public long getServiceTime() {
		if (this.isCompleted) {
			return this.t_completed - this.t_start_service;
		}
		return -1;
	}

	/**
	 * Returns time of packet in system
	 * 
	 * @return time of packet in system
	 */
	public long getSystemTime() {
		if (this.isCompleted) {
			return this.t_completed - this.t_arrival;
		}
		return -1;
	}

	/**
	 * Prints information about the packet
	 */
	public void print() {
		if (this.isWaiting) {
			System.out.println("Currently Waiting, arrived " + this.t_arrival);
		}
		if (this.isServed) {
			System.out.println("Currently Served, arrived " + this.t_arrival + ", serving start "
					+ this.t_start_service);
		}
		if (this.isCompleted) {
			System.out.println("Completed, arrived " + this.t_arrival + ", serving start " + this.t_start_service
					+ ", completed " + this.t_completed);
		}
	}
}
