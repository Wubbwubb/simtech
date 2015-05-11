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
public class SystemState {
	private static long buffercontent; // number of packets in buffer
	private static boolean serverBusy; // server busy?

	// initialize static class
	public static void init() {
		buffercontent = 0;
		serverBusy = false;
	}

	// try to add a packet to the server
	// return false if server is busy
	// return true and occupy the server if it is free
	public static boolean addPacketToServer() {
		if (serverBusy) {
			return false;
		} else {
			serverBusy = true;
			return true;
		}
	}

	// try to add a packet to the queue
	// return false if the queue is full
	// return true if the packet was added
	public static boolean addPacketToQueue() {
		if (buffercontent < SimParam.buffersize) {
			buffercontent++;
			return true;
		} else
			return false;
	}

	// packet in the server is completed
	public static void completeService() {
		serverBusy = false;
	}

	// try to serve a new packet
	// return false if no more packet is in the queue
	// return true if a packet is taken from the queue and served
	public static boolean startService() {
		if (buffercontent == 0)
			return false;
		else {
			buffercontent--;
			serverBusy = true;
			return true;
		}
	}

	// return status of the server
	public static boolean isServerBusy() {
		return serverBusy;
	}

	// print system state
	public static void print() {
		if (serverBusy)
			System.out.println("t=" + SimState.getNow() + "server busy, buffercontent: " + buffercontent);
		else
			System.out.println("t=" + SimState.getNow() + "server free");
	}

	// return number of packets in buffer
	public static long getPacketsInBuffer() {
		return buffercontent;
	}
}