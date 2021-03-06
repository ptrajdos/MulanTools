package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
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
