package mulan.evaluation.measure;

import weka.core.Utils;
/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class MicroRecallMeasure extends LabelBasedRecallMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3794564732131572341L;

	public MicroRecallMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "MicroRecallM";
	}

	@Override
	public double getValue() {
		double tp = Utils.sum(truePositives);
        double fp = Utils.sum(falsePositives);
        double fn = Utils.sum(falseNegatives);
        return  1.0 - InformationRetrievalMeasuresPT.recall(tp, fp, fn);
	}

}
