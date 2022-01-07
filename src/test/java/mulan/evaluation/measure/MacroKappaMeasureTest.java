package mulan.evaluation.measure;

public class MacroKappaMeasureTest extends LossMacroTest {

	public MacroKappaMeasureTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Measure getMeasure() {
		return new MacroKappaMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroKappaMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}

}
