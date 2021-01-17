/**
 * 
 */
package mulan.evaluation.measure;

import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.evaluation.ThresholdCurvePT;
import weka.core.Instances;
import weka.core.Utils;

/**
 * @author pawel trajdos
 * @since 0.2.0
 * @version 0.3.0
 *
 */
public class MacroAUCLoss extends MacroAUC {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5610720512188215356L;

	/**
	 * @param numOfLabels
	 */
	public MacroAUCLoss(int numOfLabels) {
		super(numOfLabels);
	}

	@Override
	public String getName() {
		return super.getName() + "_Loss";
	}

	@Override
	public double getValue() {
		double[] labelAUC = new double[numOfLabels];
        for (int i = 0; i < numOfLabels; i++) {
            ThresholdCurve tc = new ThresholdCurve();
            Instances result = tc.getCurve(m_Predictions[i], 1);
            labelAUC[i] = ThresholdCurvePT.getROCArea(result);
        }
        double val = 1- Utils.mean(labelAUC); 
        return val;
	}

	@Override
	public double getValue(int labelIndex) {
		ThresholdCurve tc = new ThresholdCurve();
        Instances result = tc.getCurve(m_Predictions[labelIndex], 1);
        double val = 1 - ThresholdCurvePT.getROCArea(result);  
        return   val;
	}
	
	@Override
	public double getIdealValue() {
		return 1- super.getIdealValue();
	}

}
