package mulan.evaluation.measure;

import mulan.evaluation.measure.LabelBasedBipartitionMeasureBase;

abstract public class LabelBasedPrecisionMeasure extends
		LabelBasedBipartitionMeasureBase {

	public LabelBasedPrecisionMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getIdealValue() {
		return 0;
	}

}
