package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatthewsLossTest extends LossTest {

	public MatthewsLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MatthewsLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MatthewsLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

	

}
