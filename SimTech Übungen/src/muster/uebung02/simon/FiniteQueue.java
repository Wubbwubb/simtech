package muster.uebung02.simon;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * FiniteQueue class 
 * Contains a buffer with the packets that are currently in the system
 * as well as additional information to the packet queue
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
class FiniteQueue {
	/**
	 * Attribute: total number of places in the queue
	 */
	private long			places;
	/**
	 * Attribute: The buffer representing the queue
	 */
	private Vector<Packet>	buffer;
		
	/**
	 * Create an empty queue with size places
	 * @param size total number of places
	 */
	public FiniteQueue(long size)
	{
		this.buffer = new Vector<Packet>();
		this.places = size;
		//this.occupied = 0;
	}
	
	/**
	 * Add a packet to the queue and return true if successful
	 * @param p The packet
	 * @return true - if successful
	 */
	public boolean add(Packet p)
	{
		if (this.buffer.size() < this.places)
		{
			this.buffer.addElement(p);
			return true;
		}
		return false;
	}
	
	/**
	 * Return and remove first element of queue, if queue is empty return null
	 * @return first element or null
	 */
	public Packet remove()
	{
		if (!this.buffer.isEmpty())
		{
			return this.buffer.remove(0);
		}
		return null;
	}
	
	/**
	 * Returns boolean if queue is empty or not
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		return this.buffer.isEmpty();
	}
	
	/**
	 * Returns current queue length
	 * @return queue length
	 */
	public long getQueueLength()
	{
		return this.buffer.size();
	}
	
	/**
	 * prints contents of queue
	 */
	public void print()
	{
		System.out.println(this.buffer.size()+ " packets in buffer");
		Iterator<Packet> pi = this.buffer.iterator();
		while (pi.hasNext())
		{
			pi.next().print();
		}
	}
}
