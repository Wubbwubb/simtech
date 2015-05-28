package eigenes.uebung03;

import java.util.Random;

public abstract class RandomNumberStream<T extends Parameter> extends Random {

	private static final long serialVersionUID = 1L;
	
	private T parameter;
	
	public RandomNumberStream(T parameter) {
		super();
		setParameter(parameter);
	}
	
	public RandomNumberStream(T parameter, long seed) {
		super(seed);
		setParameter(parameter);
	}
	
	protected void setParameter(T parameter) {
		this.parameter = parameter;
	}
	
	public T getParameter() {
		return parameter;
	}
	
	public abstract double next();

}
