package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasuresPT;
import weka.core.Utils;
/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class MicroPrecisionMeasure extends LabelBasedPrecisionMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4681556759318070680L;

	public MicroPrecisionMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "MicroPrecisionM";
	}

	@Override
	public double getValue() {
		double tp = Utils.sum(truePositives);
        double fp = Utils.sum(falsePositives);
        double fn = Utils.sum(falseNegatives);
        return  1.0 - InformationRetrievalMeasuresPT.precision(tp, fp, fn);
	}

}
