package muster.uebung02.simon;
/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * ServiceCompletion class 
 * ServiceCompletion is a special SimEvent.
 * Changes the SimState according to the server state if a ServiceCompletion
 * event occurs
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class ServiceCompletion extends SimEvent {
	
	/**
	 * Constructor that uses the given argument
	 * 
	 * @param time
	 *            Representing the simulation time at which the event occurs
	 */
	public ServiceCompletion(long time)
	{
		super(time);
		this.inter_class_priority = 0;
		this.intra_class_priority = 0;
	}
	
	/**
	 * Function describes the system behavior depending on the queueSize if a
	 * ServiceCompletion occurs.
	 */
	@Override
	public void process()
	{
		// System.out.println("completion: " +SimState.getNow());
		
		/**
		 * If queueSize greater than zero decrease queuesize by one and trigger
		 * the next ServiceCompletion event.
		 */
		Packet p = SystemState.completeService();
		CounterCollection.count_packet(p);
		if (SystemState.startService())
		{
			EventChain.insert(new ServiceCompletion(SimState.getNow()
					+ (long) (RandVar.getRV() * 1000 + 1)));
		}
	}
}
