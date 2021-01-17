package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MacroRecallMeasureTest extends LossMacroTest {

	public MacroRecallMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MacroRecallMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroRecallMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}


}
