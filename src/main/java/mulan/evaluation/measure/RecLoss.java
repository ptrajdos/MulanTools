package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;
/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class RecLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1750545264522857073L;

	public RecLoss() {
		super(new mulan.evaluation.loss.RecLoss());
	}
}
