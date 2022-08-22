/**
 * 
 */
package mulan.evaluation.measure;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author pawel
 *
 */
public class MacroBalancedAccuracyMeasureTest extends LossMacroTest {

	public MacroBalancedAccuracyMeasureTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Measure getMeasure() {
		return new MacroBalancedAccuracyMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MacroBalancedAccuracyMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1.0;
	}



}
