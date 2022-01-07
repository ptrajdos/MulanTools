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
 * @since 0.4.0
 * @version 0.4.0
 *
 */
public class MacroAUCPRCLoss extends MacroAUCPRC {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5187776654581379081L;

	/**
	 * @param numOfLabels
	 */
	public MacroAUCPRCLoss(int numOfLabels) {
		super(numOfLabels);
	}
	
	@Override
	public String getName() {
		return super.getName() + "_Loss";
	}

	@Override
	public double getValue() {
		double[] labelAUC = new double[this.numOfLabels];
        for (int i = 0; i < this.numOfLabels; i++) {
            ThresholdCurve tc = new ThresholdCurvePT();
            Instances result = tc.getCurve(this.m_Predictions[i], 1);
            labelAUC[i] = ThresholdCurvePT.getPRCArea(result);
        }
        double val = 1- Utils.mean(labelAUC); 
        return val;
	}

	@Override
	public double getValue(int labelIndex) {
		ThresholdCurve tc = new ThresholdCurvePT();
        Instances result = tc.getCurve(m_Predictions[labelIndex], 1);
        double val = 1 - ThresholdCurvePT.getPRCArea(result);  
        return   val;
	}
	
	@Override
	public double getIdealValue() {
		return 1- super.getIdealValue();
	}

}
