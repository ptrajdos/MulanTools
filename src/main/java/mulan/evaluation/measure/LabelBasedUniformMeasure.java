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
public class LabelBasedUniformMeasure extends  LabelBasedIdealValue0Measure{

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

	


}
