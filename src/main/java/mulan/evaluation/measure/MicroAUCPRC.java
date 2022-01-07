package mulan.evaluation.measure;

import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.evaluation.ThresholdCurvePT;
import weka.core.Instances;

public class MicroAUCPRC extends LabelBasedAUC {

	public MicroAUCPRC(int numOfLabels) {
		super(numOfLabels);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8990159096646842926L;

	@Override
    public String getName() {
        return "Micro-averaged AUC PRC";
    }

    @Override
    public double getValue() {
        ThresholdCurve tc = new ThresholdCurvePT();
        Instances result = tc.getCurve(all_Predictions, 1);
        return ThresholdCurvePT.getPRCArea(result);
    }


}
