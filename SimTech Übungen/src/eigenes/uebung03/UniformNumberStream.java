package eigenes.uebung03;

public class UniformNumberStream extends RandomNumberStream<UniformParameter> {

	private static final long serialVersionUID = 1L;

	public UniformNumberStream(UniformParameter parameter) {
		super(parameter);
	}

	public UniformNumberStream(UniformParameter parameter, long seed) {
		super(parameter, seed);
	}

	@Override
	public double next() {
		double nextDouble = super.nextDouble();
		return (nextDouble * (getParameter().getB() - getParameter().getA()))
				+ getParameter().getA();
	}

}
