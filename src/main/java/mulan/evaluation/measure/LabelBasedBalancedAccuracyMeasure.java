/**
 * 
 */
package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.5.0
 * @version 0.5.0
 *
 */
public abstract class LabelBasedBalancedAccuracyMeasure extends LabelBasedIdealValue0Measure {



	private static final long serialVersionUID = 8519231631787920628L;

	public LabelBasedBalancedAccuracyMeasure(int numOfLabels) {
		super(numOfLabels);
	}
	

}
