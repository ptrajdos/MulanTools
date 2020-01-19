/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

/**
 * @author pawel
 *
 */
public class KappaLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1396685344069373918L;

	/**
	 * @param aLoss
	 */
	public KappaLoss() {
		super(new mulan.evaluation.loss.KappaLoss());
		
	}

}
