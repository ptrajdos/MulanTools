package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class ZeroOneLoss extends LossBasedBipartitionMeasureBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7213586380449489878L;

	public ZeroOneLoss() {
		super(new mulan.evaluation.loss.ZeroOneLoss());
	}

}
