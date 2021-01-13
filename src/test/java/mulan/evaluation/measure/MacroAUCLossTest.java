package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MacroAUCLossTest extends LossTest {

	public MacroAUCLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MacroAUCLoss(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroAUCLoss(numLabels);
	}

	@Override
	public double getWostValue() {
		return 1;
	}

}
