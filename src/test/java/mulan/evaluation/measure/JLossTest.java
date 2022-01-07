package mulan.evaluation.measure;

public class JLossTest extends LossTest {

	public JLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new JLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new JLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
