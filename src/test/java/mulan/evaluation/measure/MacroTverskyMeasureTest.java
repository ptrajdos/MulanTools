package mulan.evaluation.measure;

public class MacroTverskyMeasureTest extends LossMacroTest {

	public MacroTverskyMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MacroTverskyMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroTverskyMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
