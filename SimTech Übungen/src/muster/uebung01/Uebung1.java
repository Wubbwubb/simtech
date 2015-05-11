package muster.uebung01;

/**
 * Exercise 1 Simulationstechnink SS2015
 * 
 * Problem 1.1: Basic DES architecture, object-oriented design
 * 
 * Mainclass reading the arguments and performing the simulation.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle, Rastin Pries, Nicholas Gray
 * @version 1.1.1
 * @since 2011-05-26
 */

public class Uebung1 {
	/**
	 * Main executing fuction
	 * 
	 * @param args
	 *            consoleparameters
	 */

	public static void main(String[] args) {
		// Problem: determine the buffer space S sufficient to guarantee that
		// in 80% of simulation runs less than "max_dropped_packets" are dropped
		// after "simtime"

		// algorithm to solve the problem:
		// start with an initial buffer space "Smin" and increase it until the criterium is fullfilled
		// perform "number_of_runs" simulations in order to determine the probability that the buffer space is
		// sufficient for the criterium
		// if the probability that the criterium is fulfilled is close to the target probability
		// repeat the simulation runs "R" times

		// parameters for simulation study
		int number_of_runs = 10000;
		int R = 3;
		int Smin = 4;
		// problem parameters
		int max_dropped_packets = 10;
		int simtime = 100 * 1000;
		// system parameters
		int iat = 490; // packet inter-arrival time

		RandVar.init(4); // initialize random number generator

		int S = Smin; // initial buffer space
		double num_successfull_runs = 0;
		boolean goon = true; // goon means go on
		while ((goon)) {
			// make simulations runs with buffer size S
			num_successfull_runs = 0;
			for (int run = 0; run < number_of_runs; run++) {
				if (SimGIGIS.doSimulation(iat, S, simtime, false) < max_dropped_packets)
					num_successfull_runs++;
			}
			// print results
			System.out.println("S: " + S + " GOOD/TOTAL: " + (int) num_successfull_runs + "/" + number_of_runs
					+ " PERCENT: " + 100 * num_successfull_runs / number_of_runs + "%");
			// criterium fulfilled
			if (num_successfull_runs / number_of_runs >= 0.8)
				goon = false;
			// close to criterium: make more runs
			if (num_successfull_runs / number_of_runs >= 0.7 & num_successfull_runs / number_of_runs <= 0.9) {
				for (int r = 1; r < R; r++) {
					num_successfull_runs = 0;
					for (int run = 0; run < number_of_runs; run++) {
						if (SimGIGIS.doSimulation(iat, S, simtime, false) < max_dropped_packets)
							num_successfull_runs++;
					}
					// print results
					System.out.println("S: " + S + " GOOD/TOTAL: " + (int) num_successfull_runs + "/" + number_of_runs
							+ " PERCENT: " + 100 * num_successfull_runs / number_of_runs + "%");
					// if any of the runs don't fulfill criterium, increase buffer space
					if (num_successfull_runs / number_of_runs < 0.8) {
						goon = true;

					}
				}
			}
			if (goon)
				S++;
			{
			}
		}
	}
}