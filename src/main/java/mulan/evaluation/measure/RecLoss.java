package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

public class RecLoss extends LossBasedBipartitionMeasureBase {

	public RecLoss() {
		super(new mulan.evaluation.loss.RecLoss());
	}
}
