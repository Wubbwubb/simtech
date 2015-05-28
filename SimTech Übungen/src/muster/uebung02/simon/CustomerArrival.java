package muster.uebung02.simon;
/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * CustomerArrival class 
 * CustomerArrival is a special SimEvent.
 * At least one CustomerArrival in the EventChain is needed to start the
 * simulation.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class CustomerArrival extends SimEvent {
	
	/**
	 * Constructor that uses the given argument
	 * 
	 * @param time
	 *            Representing the simulation time at which the event occurs
	 */
	public CustomerArrival(long time)
	{
		super(time);
		this.inter_class_priority = 1;
		this.intra_class_priority = 0;
	}
	
	/**
	 * Function describes the system behavior depending on the serverBusy
	 * attribute if a CustomArrival occurs.
	 */
	@Override
	public void process()
	{
		EventChain.insert(new CustomerArrival(SimState.getNow()
				+ SystemState.getInterArrivalTime()));
		/**
		 * If server is not busy insert the CustomerArrival in the server and
		 * set him to busy state
		 */
		if (SystemState.addPacketToServer())
		{
			// Insert the ServiceCompletion event in the EventChain
			EventChain.insert(new ServiceCompletion(SimState.getNow()
					+ (long) (RandVar.getRV() * 1000 + 1)));
			SimState.packet_accepted();
		}
		/**
		 * If server is busy insert the CustomerArrival in the queue
		 */
		else
		{
			if (SystemState.addPacketToQueue())
			{
				SimState.packet_accepted();
			} else
			{
				SimState.packet_dropped();
			}
		}
	}
}
