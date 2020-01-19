package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

public class JLoss extends LossBasedBipartitionMeasureBase {

	public JLoss() {
		super(new mulan.evaluation.loss.JLoss());
	}
}
