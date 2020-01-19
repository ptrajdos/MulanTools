/**
 * 
 */
package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;

/**
 * Class implements Mathews-correlation-coeffiecient-based loss function
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
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
		double tp = 0;
        double fp = 0;
        double fn = 0;
        double tn = 0;
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
            
            if (!bipartition[i] && !groundTruth[i]) {
                tn++;
            }
            
        }
		return mulan.evaluation.measure.InformationRetrievalMeasures.Matthews(tp, fp, fn, tn);
	}

}
