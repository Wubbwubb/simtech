package muster.uebung02.simon;
/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * SimParam class 
 * Class including the simulation parameters
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 */
class SimParam {
	/**
	 * Attribute: max queue length S
	 */
	public static int	buffersize;
	
	/**
	 * Set max queue length to S
	 * 
	 * @param S
	 *            new max queue length
	 */
	public static void init(int S)
	{
		buffersize = S;
	}
}
