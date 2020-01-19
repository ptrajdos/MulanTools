package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

public class PrecLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9216141202550713090L;

	public PrecLoss() {
		super(new mulan.evaluation.loss.PrecLoss());
	}

}
