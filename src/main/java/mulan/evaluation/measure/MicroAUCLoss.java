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
 * @since 0.2.0
 * @version 0.3.0
 *
 */
public class MicroAUCLoss extends MicroAUC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8460270719767463679L;

	/**
	 * @param numOfLabels
	 */
	public MicroAUCLoss(int numOfLabels) {
		super(numOfLabels);
	}

	@Override
	public String getName() {
		return super.getName() + "_Loss";
	}

	@Override
	public double getValue() {
		ThresholdCurve tc = new ThresholdCurve();
        Instances result = tc.getCurve((ArrayList<Prediction>)all_Predictions, 1);
        
        double rarea =  ThresholdCurvePT.getROCArea(result);
		
		return 1.0 -  rarea;
	}
	
	@Override
	public double getIdealValue() {
		return 0;
	}

}
