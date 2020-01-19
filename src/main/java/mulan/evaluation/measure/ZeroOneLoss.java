package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

public class ZeroOneLoss extends LossBasedBipartitionMeasureBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7213586380449489878L;

	public ZeroOneLoss() {
		super(new mulan.evaluation.loss.ZeroOneLoss());
	}

}
