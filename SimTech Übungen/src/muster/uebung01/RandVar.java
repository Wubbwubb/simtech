package muster.uebung01;

import java.util.Random;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * RandVar class Static Class providing random numbers.
 *
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */
public class RandVar {
	/**
	 * Attribute: java random number generator. Creates random numbers between 0 and 1 uniformly distributed
	 */
	private static Random rng;

	/**
	 * Initialize Random number generator
	 */
	public static void init() {
		rng = new Random();
	}

	/**
	 * Initialize Random number generator with seed
	 * 
	 * @param s
	 *            the seed
	 */
	public static void init(long s) {
		rng = new Random(s);
	}

	/**
	 * Get next uniform random double value between 0 and 1
	 * 
	 * @return random uniform double value between 0 and 1
	 */
	public static double getRV() {
		if (rng == null) {
			rng = new Random();
		}

		return (double) rng.nextDouble();
	}

}
