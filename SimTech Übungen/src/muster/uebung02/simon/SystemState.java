package muster.uebung02.simon;
/**
 * Exercise 2 Simulationstechnink SS2015
 *
 * SystemState class 
 * The SystemState holds the information of the current system.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class SystemState {
	/**
	 * Attribute: time between CustomArrivals
	 */
	private static long			interArrivalTime;
	/**
	 * Attribute: queue containing the packets
	 */
	private static FiniteQueue	queue;
	/**
	 * Attribute: currently served packet
	 */
	private static Packet		served_packet;
	/**
	 * Attribute: current server state (busy = true)
	 */
	private static boolean		serverBusy;
	
	/**
	 * Attribute: minimum of waiting customers
	 */
	
	/**
	 * SimState constructor Using the given arguments to initialize the SimState
	 * 
	 * @param iat
	 *            <-> interArrivalTime
	 * @param S
	 *            <-> max queue length
	 */
	public static void init(long iat, long S)
	{
		interArrivalTime = iat;
		queue = new FiniteQueue(S);
		serverBusy = false;
		served_packet = null;
	}
	
	/**
	 * Adds a packet to the server - returns true on success
	 * @return true or false
	 */
	public static boolean addPacketToServer()
	{
		if (serverBusy)
		{
			return false;
		}
		serverBusy = true;
		served_packet = new Packet(SimState.getNow());
		served_packet.startService(SimState.getNow());
		return true;
	}
	
	/**
	 * Adds a packet to the queue - returns true on success
	 * @return true or false
	 */
	public static boolean addPacketToQueue()
	{
		if (queue.add(new Packet(SimState.getNow())))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Completes serving of and returns currently served packet
	 * @return packet, whose service is completed
	 */
	public static Packet completeService()
	{
		Packet p;
		serverBusy = false;
		p = served_packet;
		p.completeService(SimState.getNow());
		served_packet = null;
		return p;
	}
	
	/**
	 * Starts serving of next packet if queue not empty
	 * @return boolean for success
	 */
	public static boolean startService()
	{
		if (queue.isEmpty())
		{
			return false;
		}
		served_packet = queue.remove();
		served_packet.startService(SimState.getNow());
		serverBusy = true;
		return true;
	}
	
	/**
	 * @return the interArrivalTime
	 */
	public static long getInterArrivalTime()
	{
		return interArrivalTime;
	}

	/**
	 * @param interArrivalTime the interArrivalTime to set
	 */
	public static void setInterArrivalTime(long interArrivalTime)
	{
		SystemState.interArrivalTime = interArrivalTime;
	}

	/**
	 * @return the serverBusy
	 */
	public static boolean isServerBusy()
	{
		return serverBusy;
	}

	/**
	 * @param serverBusy the serverBusy to set
	 */
	public static void setServerBusy(boolean serverBusy)
	{
		SystemState.serverBusy = serverBusy;
	}

	/**
	 * Prints out information about the current state
	 */
	public static void print()
	{
		if (serverBusy)
		{
			System.out.println("t=" + SimState.getNow());
			served_packet.print();
			queue.print();
		} else
		{
			System.out.println("t=" + SimState.getNow());
		}
	}
	
	/**
	 * Returns numbers of packets in the queue
	 * @return numbers of packets in the queue
	 */
	public static long getPacketsInBuffer()
	{
		return queue.getQueueLength();
	}
}
