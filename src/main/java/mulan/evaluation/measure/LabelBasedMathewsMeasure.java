/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.LabelBasedBipartitionMeasureBase;

/**
 * @author pawel
 *
 */
public abstract class LabelBasedMathewsMeasure extends LabelBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9127746485204736948L;



	/**
	 * @param aNumOfLabels
	 */
	public LabelBasedMathewsMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}



	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getIdealValue()
	 */
	@Override
	public double getIdealValue() {
		return 0;
	}

}
