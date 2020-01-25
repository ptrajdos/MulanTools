/**
 * 
 */
package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public abstract class LabelBasedKappaMeasure extends LabelBasedIdealValue0Measure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9127746485204736948L;



	/**
	 * @param aNumOfLabels
	 */
	public LabelBasedKappaMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

}
