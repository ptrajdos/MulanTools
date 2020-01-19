/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.AveragePrecision;

/**
 * @author pawel
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
		
		return this.getIdealValue() -  super.getValue();
	}

	

}
