package eigenes.uebung01;

import java.util.PriorityQueue;

public class EventChain {

	private PriorityQueue<Event> queue;
	private int capacity;

	public EventChain(int capacity) {
		this.capacity = capacity;
		this.queue = new PriorityQueue<>(capacity);
	}

	public boolean addEvent(Event e) {
		if (queue.size() < capacity) {
			return queue.add(e);
		}
		return false;
	}

	public Event getFirstEvent() {
		return queue.poll();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
