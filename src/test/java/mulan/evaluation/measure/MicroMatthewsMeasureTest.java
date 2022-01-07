package mulan.evaluation.measure;

public class MicroMatthewsMeasureTest extends LossTest {

	public MicroMatthewsMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroMatthewsMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroMatthewsMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
