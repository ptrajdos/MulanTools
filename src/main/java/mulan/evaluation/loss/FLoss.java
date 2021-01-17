package mulan.evaluation.loss;

import mulan.evaluation.measure.InformationRetrievalMeasuresPT;

/**
 * Class implements F_\beta -based loss function
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
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
		 	SimpleBinaryConfusionMatrix cm = new SimpleBinaryConfusionMatrix(bipartition, groundTruth);
		return 1.0 - InformationRetrievalMeasuresPT.fMeasure(cm.getTp(),cm.getFp(), cm.getFn(), beta);
	}

}
