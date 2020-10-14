/**
 * 
 */
package mulan.evaluation.measure;

import weka.core.Utils;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class MicroKappaMeasure extends LabelBasedMathewsMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2523449785467406241L;

	/**
	 * @param aNumOfLabels
	 */
	public MicroKappaMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getName()
	 */
	@Override
	public String getName() {
		return new String("Micro_Kappa");
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
        return  InformationRetrievalMeasuresPT.Kappa(tp, fp, fn, tn);
	}

}
