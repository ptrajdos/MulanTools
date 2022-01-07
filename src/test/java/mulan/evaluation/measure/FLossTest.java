package mulan.evaluation.measure;

public class FLossTest extends LossTest {

	public FLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new FLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new FLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
