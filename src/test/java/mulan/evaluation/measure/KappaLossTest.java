package mulan.evaluation.measure;

public class KappaLossTest extends LossTest {

	public KappaLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new KappaLoss();
	}

	@Override
	public double getWorstValue() {
		return 1.0;
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new KappaLoss();
	}

	

}
