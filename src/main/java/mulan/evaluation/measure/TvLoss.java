package mulan.evaluation.measure;

import mulan.evaluation.measure.LossBasedBipartitionMeasureBase;

public class TvLoss extends LossBasedBipartitionMeasureBase {

	public TvLoss(double alpha, double beta) {
		super(new mulan.evaluation.loss.TvLoss(alpha,beta));
	}
	public TvLoss(){
		super(new mulan.evaluation.loss.TvLoss(0.5,0.5));
	}

}
