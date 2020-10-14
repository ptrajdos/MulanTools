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
		
		return this.getIdealValue() -  super.getValue();
	}

	

}
