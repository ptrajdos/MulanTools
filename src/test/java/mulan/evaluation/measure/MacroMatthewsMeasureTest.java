package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MacroMatthewsMeasureTest extends LossMacroTest {

	public MacroMatthewsMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MacroMatthewsMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroMatthewsMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

}
