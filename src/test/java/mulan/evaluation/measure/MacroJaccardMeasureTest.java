package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

public class MacroJaccardMeasureTest extends LossMacroTest {

	public MacroJaccardMeasureTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Measure getMeasure() {
		return new MacroJaccardMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroJaccardMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
