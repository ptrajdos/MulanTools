package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoverageLossTest extends LossTest {

	public CoverageLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new CoverageLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new CoverageLoss();
	}

	@Override
	public double getWorstValue() {
		return Double.POSITIVE_INFINITY;
	}



}
