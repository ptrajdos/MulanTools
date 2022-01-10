/**
 * 
 */
package mulan.evaluation.measure;

import java.util.ArrayList;

import weka.classifiers.evaluation.Prediction;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.evaluation.ThresholdCurvePT;
import weka.core.Instances;

/**
 * @author pawel trajdos
 * @since 0.4.0
 * @version 0.4.0
 *
 */
public class MicroAUCPRCLoss extends MicroAUCPRC {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2169952539244250913L;

	/**
	 * @param numOfLabels
	 */
	public MicroAUCPRCLoss(int numOfLabels) {
		super(numOfLabels);
	}
	
	@Override
	public String getName() {
		return super.getName() + "_Loss";
	}

	@Override
	public double getValue() {	
		return 1.0  -  super.getValue();
	}
	
	@Override
	public double getIdealValue() {
		return 0;
	}

}
