package mulan.evaluation.measure;

public class ExampleBasedTverskyMeasureTest extends LossTest {

	public ExampleBasedTverskyMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new ExampleBasedTverskyMeasure();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new ExampleBasedTverskyMeasure(0.5, 0.5);
	}

	@Override
	public double getWorstValue() {
		return 1.0;
	}


}
