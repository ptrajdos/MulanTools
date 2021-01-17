package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecLossTest extends LossTest {

	public RecLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new RecLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new RecLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

	
}
