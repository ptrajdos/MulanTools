package mulan.evaluation.measure;

public class ZeroOneLossTest extends LossTest {

	public ZeroOneLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new ZeroOneLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new ZeroOneLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
