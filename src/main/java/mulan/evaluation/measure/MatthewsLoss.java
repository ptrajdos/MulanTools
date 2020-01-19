/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

/**
 * @author pawel
 *
 */
public class MatthewsLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4124041045975950900L;

	/**
	 * @param aLoss
	 */
	public MatthewsLoss() {
		super(new mulan.evaluation.loss.MatthewsLoss());
		
	}

}
