package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;
import mulan.evaluation.measure.InformationRetrievalMeasuresPT;

/**
 * Class implements Recall-based loss function
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
 *
 */

public class RecLoss extends BipartitionLossFunctionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -934666076747356319L;

	public RecLoss(){
		super();
	}
	@Override
	public String getName() {
		return "1-Rec_Loss";
	}

	@Override
	public double computeLoss(boolean[] bipartition, boolean[] groundTruth) {
		SimpleBinaryConfusionMatrix cm = new SimpleBinaryConfusionMatrix(bipartition, groundTruth);
		return 1.0 - InformationRetrievalMeasuresPT.recall( cm.getTp(), cm.getFp(), cm.getFn() );
	}

}
