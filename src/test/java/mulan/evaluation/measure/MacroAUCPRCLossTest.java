package mulan.evaluation.measure;

public class MacroAUCPRCLossTest  extends LossMacroTest {

	public MacroAUCPRCLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MacroAUCPRCLoss(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroAUCPRCLoss(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1;
	}
	
	@Override
	public void checkProcedureWorst(Measure measure) {
		this.checkValue(measure);
	}

	

}
