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
		
        double val = 1.0- super.getValue(); 
        return val;
	}

	@Override
	public double getValue(int labelIndex) {
		
        double val = 1.0 - super.getValue(labelIndex);  
        return   val;
	}
	
	@Override
	public double getIdealValue() {
		return 1- super.getIdealValue();
	}

}
