/**
 * 
 */
package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;

/**
 * Class implements Mathews-correlation-coeffiecient-based loss function
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
 *
 */
public class MatthewsLoss extends BipartitionLossFunctionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3259861817542242089L;

	
	/* (non-Javadoc)
	 * @see mulan.evaluation.loss.MultiLabelLossFunction#getName()
	 */
	@Override
	public String getName() {
		return new String("Matthews-E");
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.loss.BipartitionLossFunctionBase#computeLoss(boolean[], boolean[])
	 */
	@Override
	public double computeLoss(boolean[] bipartition, boolean[] groundTruth) {
		SimpleBinaryConfusionMatrix cm = new SimpleBinaryConfusionMatrix(bipartition, groundTruth);
		return mulan.evaluation.measure.InformationRetrievalMeasuresPT.Matthews(cm.getTp(),cm.getFp(),cm.getFn(), cm.getTn());
	}

}
