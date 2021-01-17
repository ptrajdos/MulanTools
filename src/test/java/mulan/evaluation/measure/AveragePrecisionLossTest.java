package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class AveragePrecisionLossTest extends LossTest {

	public AveragePrecisionLossTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Measure getMeasure() {
		return new AveragePrecisionLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new AveragePrecisionLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

	

}
