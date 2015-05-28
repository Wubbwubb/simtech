package muster.uebung02.simon;
/**
 * Exercise 2 Simulationstechnink SS2015
 * 
 * Uebung2 class 
 * Mainclass performing the simulation.
 * 
 * @author David Hock, Alexander Klein, Dirk Staehle
 * @version 1.1.0
 * @since 2005-11-06
 *
 */
public class Uebung2 {
	
	/**
	 * Counter - mean queue length per run
	 */
	private static TimeIndependentCounter	counter_mean_queue_length	= new TimeIndependentCounter(
																				"mean queue length per run");
	/**
	 * Histogram - mean queue length per run
	 */
	private static TimeIndependentHistogram	hist_mean_queue_length		= new TimeIndependentHistogram(
																				"mean queue length per run",
																				"ql per run.txt",
																				-0.5,
																				7.5,
																				8);
	
	private static TimeIndependentCounter	counter_mean_waiting_time	= new TimeIndependentCounter(
	"mean waiting time per run");

	private static TimeIndependentHistogram	hist_mean_waiting_time		= new TimeIndependentHistogram(
			"mean waiting per run",
			"wt per run.txt",
			0,
			5000,
			50);


	/**
	 * Main executing function
	 * 
	 * @param args
	 *            console parameters
	 */
	public static void main(String[] args)
	{
		RandVar.init(4);
		int number_of_runs = 5000;
		int max_queue = 10;
		int simtime = 100000;
		int iat = 490;
		boolean doPrintBufferContent = false;
		boolean doPrintWaitingTime = true;
		
		hist_mean_queue_length.reset();
		counter_mean_queue_length.reset();
		counter_mean_waiting_time.reset();
		hist_mean_waiting_time.reset();
		
		for (int S = 5; S <= max_queue; S++)
		{
			for (int run = 0; run < number_of_runs; run++)
			{
				simtime = 100000;
				SimGIGIS.doSimulation(iat, S, simtime, false);
				counter_mean_queue_length
						.count(CounterCollection.counter_queuelength.getMean());
				hist_mean_queue_length
						.count(CounterCollection.counter_queuelength.getMean());
				counter_mean_waiting_time.count(CounterCollection.counter_waiting_time.getMean());
				hist_mean_waiting_time.count(CounterCollection.counter_waiting_time.getMean());
			}
			hist_mean_queue_length.report("hist_mean_queue_length_" + simtime + "_" + S + ".txt");
			hist_mean_waiting_time.report("hist_mean_waiting_time_" + simtime
					+ "_" + S + ".txt");
			if (doPrintBufferContent) 
			{
				System.out.println("Buffer size: " + S + " , simulation time: "
						+ simtime + ", Mean buffer content: "
						+ counter_mean_queue_length.getMean() + " Variance: "
						+ counter_mean_queue_length.getVariance()
						+ " Coefficient of Variation: "
						+ counter_mean_queue_length.getCvar());
			}
			if (doPrintWaitingTime) 
			{
				System.out.println("Buffer size: " + S + " , simulation time: "
						+ simtime + ", Mean waiting time: "
						+ counter_mean_waiting_time.getMean() + " Variance: "
						+ counter_mean_waiting_time.getVariance()
						+ " Coefficient of Variation: "
						+ counter_mean_waiting_time.getCvar()
						+ " maximum mean waiting time: " + counter_mean_waiting_time.getMax());
			}
			hist_mean_queue_length.reset();
			counter_mean_queue_length.reset();
			counter_mean_waiting_time.reset();
			hist_mean_waiting_time.reset();
			for (int run = 0; run < number_of_runs; run++)
			{
				simtime = 1000000;
				SimGIGIS.doSimulation(iat, S, simtime, false);
				counter_mean_queue_length
						.count(CounterCollection.counter_queuelength.getMean());
				hist_mean_queue_length
						.count(CounterCollection.counter_queuelength.getMean());
				counter_mean_queue_length
				.count(CounterCollection.counter_queuelength.getMean());
				hist_mean_queue_length
				.count(CounterCollection.counter_queuelength.getMean());
				counter_mean_waiting_time.count(CounterCollection.counter_waiting_time.getMean());
				hist_mean_waiting_time.count(CounterCollection.counter_waiting_time.getMean());
			}
			hist_mean_queue_length.report("hist_mean_queue_length_" + simtime + "_" + S + ".txt");
			hist_mean_waiting_time.report("hist_mean_waiting_time_" + simtime
					+ "_" + S + ".txt");
			if (doPrintBufferContent) 
			{
				System.out.println("Buffer size: " + S + " , simulation time: "
						+ simtime + ", Mean buffer content: "
						+ counter_mean_queue_length.getMean() + " Variance: "
						+ counter_mean_queue_length.getVariance()
						+ " Coefficient of Variation: "
						+ counter_mean_queue_length.getCvar());
			}
			if (doPrintWaitingTime) 
			{
				System.out.println("Buffer size: " + S + " , simulation time: "
						+ simtime + ", Mean waiting time: "
						+ counter_mean_waiting_time.getMean() + " Variance: "
						+ counter_mean_waiting_time.getVariance()
						+ " Coefficient of Variation: "
						+ counter_mean_waiting_time.getCvar());
			}
			hist_mean_queue_length.reset();
			counter_mean_queue_length.reset();
			counter_mean_waiting_time.reset();
			hist_mean_waiting_time.reset();
		}
		
	}
	
}
