package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * SimParam class
 * 
 * Class containing the simulation parameters
 *
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */

public class SimParam {
	public static int buffersize;
	public static int interarrivaltime;
	public static long simulationduration;

	public static void init(int S, int iat, long sd) {
		buffersize = S;
		interarrivaltime = iat;
		simulationduration = sd;
	}
}
