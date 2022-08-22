/**
 * 
 */
package mulan.evaluation.measure;

/**
 * @author pawel trajdos
 * @since 0.5.0
 * @version 0.5.0
 *
 */
public class MicroBalancedAccuracyMeasureTest extends LossTest {

	public MicroBalancedAccuracyMeasureTest(String name) {
		super(name);
	}

	@Override
	public Measure getMeasure() {
		return new MicroBalancedAccuracyMeasure(2);
	}

	@Override
	public Measure getMeasure(int numLabels) {
		return new MicroBalancedAccuracyMeasure(numLabels);
	}

	@Override
	public double getWorstValue() {
		return 1.0;
	}



}
