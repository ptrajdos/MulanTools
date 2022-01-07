package mulan.evaluation.measure;

public class MicroKappaMeasureTest extends LossTest {

	public MicroKappaMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroKappaMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroKappaMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
