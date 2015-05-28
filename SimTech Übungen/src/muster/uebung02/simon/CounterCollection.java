package muster.uebung02.simon;
/**
 *
 * Exercise 2 Simulationstechnink SS2015
 *
 * CounterCollection class Consists of Counters and Histograms
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 */
public class CounterCollection {
	/**
	 * Counter - waiting time per customer
	 */
	public static TimeIndependentCounter	counter_waiting_time	=
																			new TimeIndependentCounter(
																					"waiting time per customer");
	/**
	 * Histogram - waiting time per customer
	 */
	public static TimeIndependentHistogram	hist_waiting_time		=
																			new TimeIndependentHistogram(
																					"waiting time per customer",
																					"wtc.txt",
																					0,
																					SimParam.buffersize * 1000,
																					10);
	/**
	 * Counter - queue length
	 */
	public static TimeDependentCounter		counter_queuelength		=
																			new TimeDependentCounter(
																					"queue length");
	/**
	 * Histogram - queue length
	 */
	public static TimeDependentHistogram	hist_queuelength		=
																			new TimeDependentHistogram(
																					"queue length",
																					"ql.txt",
																					0,
																					SimParam.buffersize,
																					SimParam.buffersize + 1);
	
	/**
	 * Function calls the reset method of all counters and histograms
	 */
	public static void reset()
	{
		counter_waiting_time.reset();
		hist_waiting_time.reset();
		counter_queuelength.reset();
		hist_queuelength.reset();
	}
	
	/**
	 * Function calls the report method of all counters and histograms
	 */
	public static void report()
	{
		counter_waiting_time.report();
		counter_queuelength.report();
		hist_waiting_time.report();
		hist_queuelength.report();
		
	}
	
	/**
	 * Count the waiting time of the given packet
	 * 
	 * @param p
	 *            the given packet
	 */
	public static void count_packet(Packet p)
	{
		counter_waiting_time.count(p.getWaitingTime());
		hist_waiting_time.count(p.getWaitingTime());
	}
	
	/**
	 * Count the queue length
	 */
	public static void count_system_state()
	{
		counter_queuelength.count(SystemState.getPacketsInBuffer());
		hist_queuelength.count(SystemState.getPacketsInBuffer());
	}
	
}
