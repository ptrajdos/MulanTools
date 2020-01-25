package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;
import mulan.evaluation.measure.InformationRetrievalMeasures;

/**
 * Class implements Precision-based loss function
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
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
		SimpleBinaryConfusionMatrix cm = new SimpleBinaryConfusionMatrix(bipartition, groundTruth);
		return 1.0 - InformationRetrievalMeasures.precision( cm.getTp(), cm.getFp(), cm.getFn() );
	}

}
