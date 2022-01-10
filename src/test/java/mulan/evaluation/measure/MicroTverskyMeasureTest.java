package mulan.evaluation.measure;

public class MicroTverskyMeasureTest extends LossTest {

	public MicroTverskyMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroTverskyMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroTverskyMeasure(numLabels,0.5,0.5);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
