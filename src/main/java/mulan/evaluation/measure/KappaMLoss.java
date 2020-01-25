/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class KappaMLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1396685344069373918L;

	/**
	 * @param aLoss
	 */
	public KappaMLoss() {
		super(new mulan.evaluation.loss.KappaMLoss());
		
	}

}
