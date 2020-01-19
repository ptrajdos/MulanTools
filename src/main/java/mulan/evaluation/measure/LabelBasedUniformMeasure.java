/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.LabelBasedBipartitionMeasureBase;

/**
 * @author pawel
 *
 */
public class LabelBasedUniformMeasure extends  LabelBasedBipartitionMeasureBase{

	public LabelBasedUniformMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1239551724750837096L;

	@Override
	public String getName() {
		return new String("LabelBasedUniform");
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
