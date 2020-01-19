package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;
import mulan.evaluation.measure.InformationRetrievalMeasures;

/**
 * Class implements Precision-based loss function
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
 *
 */
public class PrecLoss extends BipartitionLossFunctionBase {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4124588989334414161L;

	public PrecLoss(){
		super();
	}
	@Override
	public String getName() {
		return "1-Prec_Loss";
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
	         
		return 1.0 - InformationRetrievalMeasures.precision(tp, fp, fn);
	}

}
