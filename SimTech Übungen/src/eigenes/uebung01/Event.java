package eigenes.uebung01;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Event extends Observable implements Comparable<Event>, Runnable {

	private long eventTime;
	private long serviceCompletion;
	private static final Random randomGenerator = new Random();

	public Event(long eventTime, Observer o) {
		super();
		addObserver(o);
		this.eventTime = eventTime;
		this.serviceCompletion = (long) (randomGenerator.nextDouble() * 1000) + 1;
	}

	public long getEventTime() {
		return eventTime;
	}

	public long getServiceCompletion() {
		return serviceCompletion;
	}

	@Override
	public int compareTo(Event o) {
		if (o.getEventTime() > this.eventTime) {
			return -1;
		} else if (o.getEventTime() < this.eventTime) {
			return 1;
		}

		return 0;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(serviceCompletion);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			setChanged();
			notifyObservers();
		}
	}

}
