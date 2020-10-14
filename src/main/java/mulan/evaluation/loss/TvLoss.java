package mulan.evaluation.loss;

/**
 * Class implements Tversky-measure-based loss function
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
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
		SimpleBinaryConfusionMatrix cm = new SimpleBinaryConfusionMatrix(bipartition, groundTruth);
        
		return 1- mulan.evaluation.measure.InformationRetrievalMeasuresPT.Tversky( cm.getTp(), cm.getFp(), cm.getFn(), alpha, beta);
	}

}
