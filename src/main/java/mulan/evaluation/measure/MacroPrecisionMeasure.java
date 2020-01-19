package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasures;
import mulan.evaluation.measure.MacroAverageMeasure;

public class MacroPrecisionMeasure extends LabelBasedPrecisionMeasure implements
		MacroAverageMeasure {

	public MacroPrecisionMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "MacroPrecisionM";
	}

	@Override
	public double getValue() {
		double sum = 0;
        int count = 0;
        for (int labelIndex = 0; labelIndex < numOfLabels; labelIndex++) {
            sum +=1.0- InformationRetrievalMeasures.precision(truePositives[labelIndex],
                    falsePositives[labelIndex],
                    falseNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}

	@Override
	public double getValue(int labelIndex) {
		return 1.0-InformationRetrievalMeasures.precision(truePositives[labelIndex],
                falsePositives[labelIndex],
                falseNegatives[labelIndex]);
	}

}
