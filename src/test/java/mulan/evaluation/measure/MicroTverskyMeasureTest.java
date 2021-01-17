package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

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
		return new MicroTverskyMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
