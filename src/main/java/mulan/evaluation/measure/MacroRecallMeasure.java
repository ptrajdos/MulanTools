package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasures;
import mulan.evaluation.measure.MacroAverageMeasure;

public class MacroRecallMeasure extends LabelBasedRecallMeasure implements
		MacroAverageMeasure {

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
            sum +=1.0- InformationRetrievalMeasures.recall(truePositives[labelIndex],
                    falsePositives[labelIndex],
                    falseNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}

	@Override
	public double getValue(int labelIndex) {
		return 1.0-InformationRetrievalMeasures.recall(truePositives[labelIndex],
                falsePositives[labelIndex],
                falseNegatives[labelIndex]);
	}

}
