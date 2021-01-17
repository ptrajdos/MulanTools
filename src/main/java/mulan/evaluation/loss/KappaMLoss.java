/**
 * 
 */
package mulan.evaluation.loss;

/**
 * Class implements Kappa-criterion-based loss function
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
 *
 */
public class KappaMLoss extends BipartitionLossFunctionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3840953171060315562L;

	/**
	 * 
	 */
	

	
	/* (non-Javadoc)
	 * @see mulan.evaluation.loss.MultiLabelLossFunction#getName()
	 */
	@Override
	public String getName() {
		return new String("KappaM-E");
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.loss.BipartitionLossFunctionBase#computeLoss(boolean[], boolean[])
	 */
	@Override
	public double computeLoss(boolean[] bipartition, boolean[] groundTruth) {
		SimpleBinaryConfusionMatrix cm = new SimpleBinaryConfusionMatrix(bipartition, groundTruth);
		double val = mulan.evaluation.measure.InformationRetrievalMeasuresPT.KappaM(cm.getTp(),cm.getFp(),cm.getFn(), cm.getTn()); 
		return val;
	}

}
