/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.MacroAverageMeasure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class MacroUniformMeasure extends LabelBasedTverskyMeasure implements
MacroAverageMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550732507791518974L;

	/**
	 * 
	 */
	public MacroUniformMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	@Override
	public String getName() {
		return new String("MacroUniform");
	}

	@Override
	public double getValue() {
		return 0;
	}

	@Override
	public double getValue(int labelIndex) {
		return 0;
	}

}
