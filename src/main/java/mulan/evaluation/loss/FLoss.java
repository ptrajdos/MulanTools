package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;
import mulan.evaluation.measure.InformationRetrievalMeasures;

/**
 * Class implements F_\beta -based loss function
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
 *
 */
public class FLoss extends BipartitionLossFunctionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -704205963162683654L;
	protected double beta;
	public FLoss() {
		this.beta=1.0;
	}
	public FLoss(double beta){
		this.beta =beta;
	}
	@Override
	public String getName() {
		return "F loss";
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
		return 1.0 - InformationRetrievalMeasures.fMeasure(tp, fp, fn, beta);
	}

}
