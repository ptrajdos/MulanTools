package mulan.evaluation.loss;

/**
 * Class implements Jaccard-criterion-based loss function
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
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
	return 1.0 - mulan.evaluation.measure.InformationRetrievalMeasures.JaccardMeasure(tp, fp, fn);
	}

}
