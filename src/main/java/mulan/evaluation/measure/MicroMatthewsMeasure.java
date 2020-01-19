/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasures;
import weka.core.Utils;

/**
 * @author pawel
 *
 */
public class MicroMatthewsMeasure extends LabelBasedMathewsMeasure {

	/**
	 * @param aNumOfLabels
	 */
	public MicroMatthewsMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getName()
	 */
	@Override
	public String getName() {
		return new String("Micro Matthews");
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getValue()
	 */
	@Override
	public double getValue() {
		double tp = Utils.sum(truePositives);
        double fp = Utils.sum(falsePositives);
        double fn = Utils.sum(falseNegatives);
        double tn = Utils.sum(trueNegatives);
        return  InformationRetrievalMeasures.Matthews(tp, fp, fn, tn);
	}

}
