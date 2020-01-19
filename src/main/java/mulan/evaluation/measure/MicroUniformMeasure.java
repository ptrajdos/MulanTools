package mulan.evaluation.measure;

import mulan.evaluation.measure.LabelBasedBipartitionMeasureBase;

public class MicroUniformMeasure extends LabelBasedBipartitionMeasureBase {

	

	public MicroUniformMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3089082592000339532L;

	@Override
	public String getName() {
		return new String("MicroUniform");
	}

	@Override
	public double getValue() {
		return 0;
	}

	@Override
	public double getIdealValue() {
		return 0;
	}

}
