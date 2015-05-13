package eigenes.uebung01;

import java.util.Observable;
import java.util.Observer;

public class Simulation implements Observer {

	private EventChain eventChain;
	private final long customerArrival = 490;
	private final long simulationTermination = 100000;
	private boolean isReady;
	private long blocked;

	public Simulation(int capacity) {
		this.blocked = 0;
		this.isReady = true;
		this.eventChain = new EventChain(capacity);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.isReady = true;
	}

	public void run() throws Exception {
		final long startTime = System.currentTimeMillis();

		Thread eventCreator = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (System.currentTimeMillis() - startTime > simulationTermination) {
						break;
					}

					Event event = new Event(System.currentTimeMillis(), Simulation.this);
					if (!eventChain.addEvent(event)) {
						blocked++;
						System.out.println("Event blocked");
					} else {
						System.out.println("Event added with " + event.getServiceCompletion() + " ms");
					}

					try {
						Thread.sleep(customerArrival);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		eventCreator.start();

		while (true) {
			if (System.currentTimeMillis() - startTime > simulationTermination) {
				System.out.println(blocked + " Events blocked");
				break;
			}

			if (isReady && !eventChain.isEmpty()) {
				Event firstEvent = eventChain.getFirstEvent();
				System.out.println("Started event with " + firstEvent.getServiceCompletion() + " ms");
				isReady = false;
				firstEvent.run();
			}
		}

	}

}
