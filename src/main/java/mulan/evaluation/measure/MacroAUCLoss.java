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
public class MacroAUCLoss extends MacroAUC {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5610720512188215356L;

	/**
	 * @param numOfLabels
	 */
	public MacroAUCLoss(int numOfLabels) {
		super(numOfLabels);
	}

	@Override
	public String getName() {
		return super.getName() + "_Loss";
	}

	@Override
	public double getValue() {
		return 1.0 - super.getValue();
	}

	@Override
	public double getValue(int labelIndex) {
		return 1.0- super.getValue(labelIndex);
	}

}
