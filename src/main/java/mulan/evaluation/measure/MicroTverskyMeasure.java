package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasures;
import weka.core.Utils;
/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class MicroTverskyMeasure extends LabelBasedTverskyMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6046960386407111204L;

	public MicroTverskyMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	public MicroTverskyMeasure(int aNumOfLabels, double alpha, double beta) {
		super(aNumOfLabels, alpha, beta);
	}

	@Override
	public String getName() {
		String name = "MicroTversky_A"+this.alpha+"B_"+this.beta;
		return name;
	}

	@Override
	public double getValue() {
		 double tp = Utils.sum(truePositives);
	        double fp = Utils.sum(falsePositives);
	        double fn = Utils.sum(falseNegatives);
	        return  1.0 - InformationRetrievalMeasures.Tversky(tp, fp, fn, this.alpha, this.beta);
	}

}
