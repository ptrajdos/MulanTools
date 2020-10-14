/**
 * 
 */
package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.2.0
 * @version 0.2.0
 *
 */
public class MicroAUCLoss extends MicroAUC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8460270719767463679L;

	/**
	 * @param numOfLabels
	 */
	public MicroAUCLoss(int numOfLabels) {
		super(numOfLabels);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName() + "_Loss";
	}

	@Override
	public double getValue() {
		return 1.0 -  super.getValue();
	}

}
