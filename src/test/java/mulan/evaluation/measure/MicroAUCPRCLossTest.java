package mulan.evaluation.measure;

public class MicroAUCPRCLossTest extends LossTest {

	public MicroAUCPRCLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroAUCPRCLoss(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroAUCPRCLoss(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1.0;
	}
	
	@Override
	public void checkProcedureWorst(Measure measure, int numLabels) {
		this.checkValue(measure,numLabels);
	}

	

}
