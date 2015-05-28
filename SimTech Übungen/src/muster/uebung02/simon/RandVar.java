package muster.uebung02.simon;
import java.util.Random;

/**
 *
 * Exercise 2 Simulationstechnink SS2015
 * RandVar class 
 * Static Class providing random numbers.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class RandVar {
	/**
	 * Attribute: java random number generator. Creates random numbers between 0
	 * and 1 uniformly distributed
	 */
	private static Random	rng;
	
	/**
	 * Initialize Random number generator
	 */
	public static void init()
	{
		rng = new Random();
	}
	
	/**
	 * Initialize Random number generator with seed
	 * 
	 * @param s
	 *            the seed
	 */
	public static void init(long s)
	{
		rng = new Random(s);
	}
	
	/**
	 * Get next uniform random double value between 0 and 1
	 * 
	 * @return random uniform double value between 0 and 1
	 */
	public static double getRV()
	{
		if (rng == null)
		{
			rng = new Random();
		}
		// rng= new Random();
		return rng.nextDouble();
	}
	
}
