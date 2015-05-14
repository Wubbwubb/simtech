package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 *
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * CustomerArrival is a special SimEvent. At least one CustomerArrival in the EventChain is needed to start the
 * simulation.
 *
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */
public class CustomerArrival extends SimEvent {

	/**
	 * Constructor that uses the given argument
	 *
	 * @param time
	 *            Representing the simulation time at which the event occurs
	 */
	public CustomerArrival(long time) {
		super(time);
		// see SimEvent
		inter_class_priority = 1;
		intra_class_priority = 0;
	}

	// change system state, make statistics, trigger new events
	public void process() {
		// always trigger next arrival event
		EventChain.insert(new CustomerArrival(SimState.getNow() + SimParam.interarrivaltime));

		// try to add the packet to the server
		if (SystemState.addPacketToServer()) {
			// success: packet is served, trigger service completion event for the packet
			EventChain.insert(new ServiceCompletion(SimState.getNow() + (long) (RandVar.getRV() * 1000 + 1)));
			// inform SimState (or better extra class reponsible for statistics) that a packet was accepted
			SimState.packet_accepted();
		}
		// no success, server is busy
		else {
			// try to store the packet in the buffer
			if (SystemState.addPacketToQueue()) {
				// success: inform SimState (or better extra class reponsible for statistics) that a packet was accepted
				SimState.packet_accepted();
			} else {
				// no success: inform SimState (or better extra class reponsible for statistics) that a packet was
				// dropped
				SimState.packet_dropped();
			}
		}
	}
}
