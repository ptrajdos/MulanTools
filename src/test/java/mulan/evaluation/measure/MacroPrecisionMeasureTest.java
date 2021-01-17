package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MacroPrecisionMeasureTest extends LossMacroTest {

	public MacroPrecisionMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MacroPrecisionMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroPrecisionMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

	

}
