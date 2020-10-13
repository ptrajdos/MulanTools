package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasuresPT;
import mulan.evaluation.measure.MacroAverageMeasure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */

public class MacroRecallMeasure extends LabelBasedRecallMeasure implements
		MacroAverageMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4769652556141525136L;

	public MacroRecallMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "MacroRecallM";
	}

	@Override
	public double getValue() {
		double sum = 0;
        int count = 0;
        for (int labelIndex = 0; labelIndex < numOfLabels; labelIndex++) {
            sum +=1.0- InformationRetrievalMeasuresPT.recall(truePositives[labelIndex],
                    falsePositives[labelIndex],
                    falseNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}

	@Override
	public double getValue(int labelIndex) {
		return 1.0-InformationRetrievalMeasuresPT.recall(truePositives[labelIndex],
                falsePositives[labelIndex],
                falseNegatives[labelIndex]);
	}

}
