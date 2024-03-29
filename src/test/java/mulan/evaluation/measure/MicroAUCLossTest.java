package mulan.evaluation.measure;

public class MicroAUCLossTest extends LossTest {

	public MicroAUCLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroAUCLoss(2);
	}

	@Override
	public double getWorstValue() {
		return 1.0;
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroAUCLoss(numLabels);
	}

}
