package mulan.evaluation.measure;

public class RecLossTest extends LossTest {

	public RecLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new RecLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new RecLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

	
}
