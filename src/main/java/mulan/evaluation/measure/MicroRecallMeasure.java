package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasures;
import weka.core.Utils;

public class MicroRecallMeasure extends LabelBasedRecallMeasure {

	public MicroRecallMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "MicroRecallM";
	}

	@Override
	public double getValue() {
		double tp = Utils.sum(truePositives);
        double fp = Utils.sum(falsePositives);
        double fn = Utils.sum(falseNegatives);
        return  1.0 - InformationRetrievalMeasures.recall(tp, fp, fn);
	}

}
