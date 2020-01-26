package mulan.evaluation.loss;

/**
 * Class implements Jaccard-criterion-based loss function
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
 *
 */

public class JLoss extends BipartitionLossFunctionBase {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6728507069355366560L;

	@Override
	public String getName() {
		return "Jaccard Loss";
	}

	@Override
	public double computeLoss(boolean[] bipartition, boolean[] groundTruth) {
		SimpleBinaryConfusionMatrix cm = new SimpleBinaryConfusionMatrix(bipartition, groundTruth);
		return 1.0 - mulan.evaluation.measure.InformationRetrievalMeasuresPT.JaccardMeasure(cm.getTp(), cm.getFp(), cm.getFn());
	}

}
