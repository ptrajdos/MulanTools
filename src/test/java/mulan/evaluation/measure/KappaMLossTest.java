package mulan.evaluation.measure;

public class KappaMLossTest extends LossTest {

	public KappaMLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new KappaMLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new KappaMLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

	

}
