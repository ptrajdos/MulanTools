package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */

public class JLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 105016689738662449L;

	public JLoss() {
		super(new mulan.evaluation.loss.JLoss());
	}
}
