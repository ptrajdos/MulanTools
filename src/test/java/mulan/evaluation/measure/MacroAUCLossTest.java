package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MacroAUCLossTest extends LossMacroTest {

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
	public double getWorstValue() {
		return 1;
	}

}
