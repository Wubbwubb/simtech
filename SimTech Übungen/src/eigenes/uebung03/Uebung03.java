package eigenes.uebung03;

import java.util.ArrayList;
import java.util.List;

import muster.uebung02.TimeIndependentCounter;

public class Uebung03 {

	public static void main(String[] args) {
		
		int n = 1000;
		
		int a = 1;
		int b = 5;

		double lambda = 2.3;

		RandomNumberStream<?> uniformGenerator = new UniformNumberStream(new UniformParameter(a, b));
		RandomNumberStream<?> exponentialGenerator = new ExponentialNumberStream(new ExponentialParameter(lambda));
		
		List<Double> uniformNumbers = new ArrayList<>(n);
		List<Double> exponentialNumbers = new ArrayList<>(n);

		TimeIndependentCounter uniformCounter = new TimeIndependentCounter("counter for uniform numbers");
		TimeIndependentCounter exponentialCounter = new TimeIndependentCounter("counter for exponential numbers");
		
		uniformCounter.reset();
		exponentialCounter.reset();
		
		double tmp;
		for (int i = 0; i < n; i++) {
			tmp = uniformGenerator.next();
			uniformNumbers.add(tmp);
			uniformCounter.count(tmp);
			tmp = exponentialGenerator.next();
			exponentialNumbers.add(tmp);
			exponentialCounter.count(tmp);
		}
		
		System.out.println();

	}
}
