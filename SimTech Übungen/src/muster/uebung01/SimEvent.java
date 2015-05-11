package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * SimEvent class SimEvent is the super class for all types of events. Events are sorted by their time of appearance in
 * 0.01 ms
 * 
 * @author Matthias Hirth, David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */

public abstract class SimEvent implements Comparable<SimEvent> {

	/*
	 * The attributes value, inter_class_priority, and inner_class_priority define the order of the events. Value is the
	 * "time" when the event takes place and is the most important criterium. In the case of equal times we distinguish
	 * event of different classes according to the inter_class_priority. A lower inter_class_priority means that the
	 * event takes place first. In the case of equal times and equal inter_class_priorities, i.e. either if two events
	 * of the same class take place at the same time or when two classes have the same inter_class_priority, we
	 * distinguish order these events according to the intra_class_priority. A lower intra_class_priority means that the
	 * event takes place first.
	 */

	private long value;
	long inter_class_priority;
	long intra_class_priority;

	public SimEvent(long time) {
		value = time;
	}

	// change system state, make statistics, trigger new events
	public abstract void process();

	// operator definining the order of events, explanation see above
	public int compareTo(SimEvent o) {
		if (this.value == o.value) {
			if (this.inter_class_priority == o.inter_class_priority) {
				return (int) (this.intra_class_priority - o.intra_class_priority);
			} else {
				return (int) (this.inter_class_priority - o.inter_class_priority);
			}
		} else {
			return (int) (this.value - o.value);
		}
	}

	// return event time
	public long getValue() {
		return value;
	}

	// increases the intra_class_priority, see method insert of class EventChain
	public void incIntraClassPriority() {
		this.intra_class_priority++;
	}

	// for printing
	public String toString() {
		return super.toString() + " : " + value;
	}

}