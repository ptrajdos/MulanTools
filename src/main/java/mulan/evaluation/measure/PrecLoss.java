package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class PrecLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9216141202550713090L;

	public PrecLoss() {
		super(new mulan.evaluation.loss.PrecLoss());
	}

}
