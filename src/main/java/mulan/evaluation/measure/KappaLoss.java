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
public class KappaLoss extends LossBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1396685344069373918L;

	/**
	 * @param aLoss
	 */
	public KappaLoss() {
		super(new mulan.evaluation.loss.KappaLoss());
		
	}

}
