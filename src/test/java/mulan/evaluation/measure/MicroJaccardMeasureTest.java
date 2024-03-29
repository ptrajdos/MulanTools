package mulan.evaluation.measure;

public class MicroJaccardMeasureTest extends LossTest {

	public MicroJaccardMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroJaccardMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroJaccardMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
