package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class TvLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2446382318512731886L;
	public TvLoss(double alpha, double beta) {
		super(new mulan.evaluation.loss.TvLoss(alpha,beta));
	}
	public TvLoss(){
		super(new mulan.evaluation.loss.TvLoss(0.5,0.5));
	}

}
