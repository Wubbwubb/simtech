package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 *
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * ServiceCompletion is a special SimEvent. Changes the SimState according to the server state if a ServiceCompletion
 * event occurs
 *
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */
public class ServiceCompletion extends SimEvent {

	/**
	 * Constructor that uses the given argument
	 *
	 * @param time
	 *            Representing the simulation time at which the event occurs
	 */
	public ServiceCompletion(long time) {
		// see SimEvent
		super(time);
		inter_class_priority = 0;
		intra_class_priority = 0;
	}

	// change system state, make statistics, trigger new events
	public void process() {
		// inform SystemState that serving packet is finished
		SystemState.completeService();
		// try to serve next packet
		if (SystemState.startService()) {
			// success: trigger service completion event
			EventChain.insert(new ServiceCompletion(SimState.getNow() + (long) (RandVar.getRV() * 1000 + 1)));
		}
	}
}