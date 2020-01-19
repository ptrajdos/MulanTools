package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;

/**
 * Class implements Tversky-measure-based loss function
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
 *
 */

public class TvLoss extends BipartitionLossFunctionBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3143830405620347966L;
	private double alpha;
	private double beta;

	public TvLoss(double alpha, double beta) {
		//alpha=beta=1 ->JLoss
		this.alpha = alpha;
		this.beta = beta;
	}

	@Override
	public String getName() {
		return "Tversky-LossA"+this.alpha+"B"+this.beta;
	}

	@Override
	public double computeLoss(boolean[] bipartition, boolean[] groundTruth) {
	 	double tp = 0;
        double fp = 0;
        double fn = 0;
        for (int i = 0; i < groundTruth.length; i++) {
            if (bipartition[i] && groundTruth[i]) {
                tp++;
            }
            if (bipartition[i] && !groundTruth[i]) {
                fp++;
            }
            if (!bipartition[i] && groundTruth[i]) {
                fn++;
            }
        }
        
		return 1- mulan.evaluation.measure.InformationRetrievalMeasures.Tversky(tp, fp, fn, alpha, beta);
	}

}
