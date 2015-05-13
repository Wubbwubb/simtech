package muster.uebung01;

import java.util.PriorityQueue;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * EventChain class The EventChain holds all SimEvents in an PriorityQueue. ==> Automatically Sorted.
 * 
 * Please notice: To avoid to events at the same time not being inserted, the second event appearing at the same time is
 * increased by 0.01 ms and so inserted directly after
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */
public class EventChain {
	/**
	 * Priority Queue that contains the stored SimEvents
	 */
	private static PriorityQueue<SimEvent> queue = new PriorityQueue<SimEvent>();

	// insert event into eventchain
	public static void insert(SimEvent e) {
		/*
		 * queue.add returns false if an event with equal time and equal inter_class_priority already exists in the
		 * queue. equality is broken by increasing the intra_class_priority
		 */
		while (!queue.add(e)) {
			e.incIntraClassPriority();
		}
	}

	// initialize empty event chain
	public static void init() {
		queue.clear();
	}

	// return next event
	public static SimEvent removeOldestEvent() {
		return queue.poll();
	}
}
