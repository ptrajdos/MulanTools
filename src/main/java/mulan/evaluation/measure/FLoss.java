package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */

public class FLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4298221491398697100L;
	public FLoss() {
		super(new mulan.evaluation.loss.FLoss());
	}
	public FLoss(double beta){
		super(new mulan.evaluation.loss.FLoss(beta));
	}

}
