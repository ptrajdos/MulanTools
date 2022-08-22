/**
 * 
 */
package mulan.evaluation.measure;

import weka.core.Utils;

/**
 * @author pawel
 *
 */
public class MicroBalancedAccuracyMeasure extends LabelBasedBalancedAccuracyMeasure {

	private static final long serialVersionUID = -2563829894339859470L;

	/**
	 * @param numOfLabels
	 */
	public MicroBalancedAccuracyMeasure(int numOfLabels) {
		super(numOfLabels);
	}

	@Override
	public String getName() {
		return "Micro-averaged Balanced accuracy measure";
	}

	@Override
	public double getValue() {
		double tp = Utils.sum(truePositives);
        double fp = Utils.sum(falsePositives);
        double fn = Utils.sum(falseNegatives);
        double tn = Utils.sum(trueNegatives);
        
        return  1.0 - InformationRetrievalMeasuresPT.balancedAccuracy(tp, fp, fn, tn);
	}

}
