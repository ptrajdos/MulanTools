package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExampleBasedJaccardMeasureTest extends LossTest {

	public ExampleBasedJaccardMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new ExampleBasedJaccardMeasure();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new ExampleBasedJaccardMeasure();
	}

	@Override
	public double getWorstValue() {
		return 1.0;
	}


}
