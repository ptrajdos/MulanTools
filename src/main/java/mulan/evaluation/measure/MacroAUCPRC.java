package mulan.evaluation.measure;

import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.evaluation.ThresholdCurvePT;
import weka.core.Instances;
import weka.core.Utils;

/**
 * Area under PRC curve
 * @author pawel trajdos
 * @since 0.4.0
 * @version 0.4.0
 *
 */

public class MacroAUCPRC extends LabelBasedAUC implements MacroAverageMeasure {

	public MacroAUCPRC(int numOfLabels) {
		super(numOfLabels);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9171591306606597726L;

	@Override
	public String getName() {
		 return "Macro-averaged AUC PRC";
	}

	@Override
	public double getValue() {
		 double[] labelAUC = new double[numOfLabels];
	        for (int i = 0; i < numOfLabels; i++) {
	            ThresholdCurve tc = new ThresholdCurvePT();
	            Instances result = tc.getCurve(m_Predictions[i], 1);
	            labelAUC[i] = ThresholdCurvePT.getPRCArea(result);
	        }
	        return Utils.mean(labelAUC);
	}

	@Override
	public double getValue(int labelIndex) {
		ThresholdCurve tc = new ThresholdCurvePT();
        Instances result = tc.getCurve(m_Predictions[labelIndex], 1);
        return ThresholdCurvePT.getPRCArea(result);  
	}

	
}
