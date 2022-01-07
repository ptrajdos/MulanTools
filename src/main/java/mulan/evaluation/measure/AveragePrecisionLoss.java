/**
 * 
 */
package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class AveragePrecisionLoss extends AveragePrecision {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3709549403465454003L;


	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.RankingMeasureBase#getValue()
	 */
	@Override
	public double getValue() {
		
		return super.getIdealValue() -  super.getValue();
	}
	
	@Override
	public double getIdealValue() {
		return 0;
	}
	
	@Override
	protected void updateRanking(int[] ranking, boolean[] trueLabels) {
		//Fixes a bug in the parent class
		int preCnt = this.count;
		super.updateRanking(ranking, trueLabels);
		if (preCnt == this.count)
			this.count++;
	}

	

}
