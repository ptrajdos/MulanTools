package mulan.evaluation.measure;

import mulan.evaluation.measure.LabelBasedBipartitionMeasureBase;

public abstract class LabelBasedRecallMeasure extends
		LabelBasedBipartitionMeasureBase {

	public LabelBasedRecallMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	@Override
	public double getIdealValue() {
		return 0;
	}

}
