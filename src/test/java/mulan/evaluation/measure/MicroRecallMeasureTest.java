package mulan.evaluation.measure;

public class MicroRecallMeasureTest extends LossTest {

	public MicroRecallMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroRecallMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroRecallMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
