package muster.uebung02.simon;
/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * SimEvent class 
 * SimEvent is the super class for all types of events. 
 * Events are sorted by their time of appearance first. 
 * If this time is equal for two or more events, the Events 
 * are further sorted by their inter class priority, which gives 
 * priority to different types of Events.
 * If there are more then one Event of the same type with equal time
 * an intra class priority attribute is used to differ those Events  
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class SimEvent implements Comparable<SimEvent> {
	
	/**
	 * Attribute: Representing the simulation time at which the event occurs
	 */
	private long	t_appearance;
	/**
	 * Attribute: inter class priority of the Event
	 * different for different Event types
	 */
	long			inter_class_priority;
	/**
	 * Attribute: intra class priority of the Event
	 * normally 0, only used if more than one Event with equal t_appearance
	 * and inter_class_priority
	 */
	long			intra_class_priority;
	
	/**
	 * Creates a SimEvent with time of appearance time 
	 * @param time of apperance
	 */
	public SimEvent(long time)
	{
		this.t_appearance = time;
	}
	
	/**
	 * Interface of SimEvents. This function has to be overwritten by all
	 * extending classes.
	 */
	public void process()
	{
		return;
	}
	
	public int compareTo(SimEvent o)
	{
		if (this.t_appearance == o.t_appearance)
		{
			if (this.inter_class_priority == o.inter_class_priority)
			{
				return (int) (this.intra_class_priority - o.intra_class_priority);
			}
			return (int) (this.inter_class_priority - o.inter_class_priority);
		}
		return (int) (this.t_appearance - o.t_appearance);
	}
	
	/**
	 * Returns the time of appearance
	 * @return time of appearance
	 */
	public long getTimeOfAppearance()
	{
		return this.t_appearance;
	}
	
	/**
	 * Increases the intra_class_priority
	 */
	public void incIntraClassPriority()
	{
		this.intra_class_priority++;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " : " + this.t_appearance;
	}
	
}
