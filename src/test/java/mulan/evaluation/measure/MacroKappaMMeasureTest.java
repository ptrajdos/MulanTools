package mulan.evaluation.measure;

public class MacroKappaMMeasureTest extends LossMacroTest {

	public MacroKappaMMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MacroKappaMMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {

		return new MacroKappaMMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}



}
