package muster.uebung02;

import muster.uebung01.SimState;

/**
 * Exercise 2 Simulationstechnink SS2015
 *
 * TimeDependentCounter class Class counts the given values REGARDING the simulation time
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class TimeDependentCounter extends Counter {
	/**
	 * Attribute: Simulation time of the last sample
	 */
	public long lastSampleTime;
	/**
	 * Attribute: Simulation time of the first sample
	 */
	public long firstSampleTime;

	/**
	 * Constructor that uses the given argument and the super constructor to initialize the TDCounter
	 * 
	 * @param name
	 *            name of the Counter
	 */
	public TimeDependentCounter(String name) {
		super(name);
		this.lastSampleTime = 0;
		this.firstSampleTime = 0;
	}

	/**
	 * Method resets all attributs
	 */
	@Override
	public void reset() {
		super.reset();
		this.lastSampleTime = 0;
		this.firstSampleTime = 0;
	}

	/**
	 * Method calculates and returns the mean of the observed variable regarding the counting time
	 * 
	 * @return the calculated time dependent mean
	 */
	@Override
	public double getMean() {
		long tmp = this.lastSampleTime - this.firstSampleTime;
		if (tmp > 0) {
			return this.sumPowerOne / tmp;
		}
		return 0;
	}

	/**
	 * Method calculates and returns the var of the observed variable regarding the counting time
	 * 
	 * @return the calculated time dependent var
	 */
	@Override
	public double getVariance() {
		long tmp = this.lastSampleTime - this.firstSampleTime;
		double tmp2 = this.getMean();
		if (tmp > 0) {
			return this.sumPowerTwo / tmp - tmp2 * tmp2;
		}
		return 0;
	}

	/**
	 * Method counts the given argument (regarding the time the system remained in this state) by extending the
	 * "original" counting method.
	 * 
	 * @param x
	 *            the double value to count
	 */
	@Override
	public void count(double x) {
		double tdiff = SimState.getNow() - this.lastSampleTime;
		if (tdiff < 0) {
			System.out.println("last = " + this.lastSampleTime + " now = " + SimState.getNow());
			System.exit(-1);
		}
		this.sumPowerOne += (x * tdiff);
		this.sumPowerTwo += (x * x * tdiff);
		this.lastSampleTime = SimState.getNow();
	}

	/**
	 * Method visualizes the calculated statistics by using the report method of the super class.
	 */
	@Override
	public void report() {
		System.out.println("continuous counter\n");
		super.report();
		System.out.println("interval length: " + (this.lastSampleTime - this.firstSampleTime));
	}
}
