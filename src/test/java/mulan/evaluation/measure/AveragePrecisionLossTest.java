package mulan.evaluation.measure;

public class AveragePrecisionLossTest extends LossTest {

	public AveragePrecisionLossTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Measure getMeasure() {
		return new AveragePrecisionLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new AveragePrecisionLoss();
	}

	@Override
	public double getWorstValue() {
		return 1;
	}
	
	@Override
	public void checkProcedureWorst(Measure measure, int numLabels) {
		this.checkProcedure(measure,numLabels);
	}

	

}
