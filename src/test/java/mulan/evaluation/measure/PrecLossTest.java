package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrecLossTest extends LossTest {

	public PrecLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new PrecLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new PrecLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
