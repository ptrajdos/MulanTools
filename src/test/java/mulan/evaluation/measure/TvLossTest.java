package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class TvLossTest extends LossTest {

	public TvLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new TvLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new TvLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
