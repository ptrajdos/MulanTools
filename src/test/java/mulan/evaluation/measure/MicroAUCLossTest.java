package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MicroAUCLossTest extends LossTest {

	public MicroAUCLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroAUCLoss(2);
	}

	@Override
	public double getWostValue() {
		return 1.0;
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroAUCLoss(numLabels);
	}

}
