
package muster.uebung02.simon;
import java.util.PriorityQueue;

/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * EventChain class 
 * The EventChain holds all SimEvents in a Priority Queue. ==> Automatically Sorted. 
 * The way in which the Events are sorted can be seen in the SimEvent class 
 * (compareTo-Method)
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class EventChain {
	/**
	 * Priority Queue that contains the stored SimEvents
	 */
	private static PriorityQueue<SimEvent>	queue	= new PriorityQueue<SimEvent>();
	
	/**
	 * Inserts SimEvent at correct position automatically. If there is already a
	 * SimEvent at this time increase the SimEvent's Intra Class Priority
	 * until the inserting is succesfull
	 * 
	 * @param e
	 *            SimEvent
	 */
	public static void insert(SimEvent e)
	{
		while (!queue.add(e))
		{
			//System.out.println(e);
			e.incIntraClassPriority();
			//System.out.println(e);
		}
	}
	
	/**
	 * Inits the Event Chain by clearing the Priority Queue
	 */
	public static void init()
	{
		queue.clear();
	}
	
	/**
	 * Removes the first item from the Chain and returns it.
	 * 
	 * @return The first item
	 */
	public static SimEvent removeOldestEvent()
	{
		return queue.poll();
	}
}
