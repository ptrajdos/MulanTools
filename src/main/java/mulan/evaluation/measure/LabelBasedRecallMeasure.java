package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */

public abstract class LabelBasedRecallMeasure extends
		LabelBasedIdealValue0Measure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8273442149840300880L;

	public LabelBasedRecallMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}
}
