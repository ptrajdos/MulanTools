package mulan.evaluation.measure;

public class CoverageLossTest extends LossTest {
	

	public CoverageLossTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new CoverageLoss();
	}

	@Override
	public Measure getMeasure(int numLabels) {

		return new CoverageLoss();
	}

	@Override
	public double getWorstValue() {
		return Double.POSITIVE_INFINITY;
	}
	
	@Override
	public void checkProcedureWorst(Measure measure, int numLabels) {
		//TODO check it!
		this.checkProcedure(measure,numLabels);
	}



}
