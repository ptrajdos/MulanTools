package mulan.evaluation.measure;

public class MicroPrecisionMeasureTest extends LossTest {

	public MicroPrecisionMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroPrecisionMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroPrecisionMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
