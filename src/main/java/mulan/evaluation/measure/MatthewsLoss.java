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
public class MatthewsLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4124041045975950900L;

	/**
	 * @param aLoss
	 */
	public MatthewsLoss() {
		super(new mulan.evaluation.loss.MatthewsLoss());
		
	}

}
