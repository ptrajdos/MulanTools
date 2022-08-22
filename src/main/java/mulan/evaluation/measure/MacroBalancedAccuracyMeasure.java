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
public class MacroBalancedAccuracyMeasure extends LabelBasedBalancedAccuracyMeasure implements MacroAverageMeasure {

	
	public MacroBalancedAccuracyMeasure(int numOfLabels) {
		super(numOfLabels);
	}

	private static final long serialVersionUID = -4763723604251562348L;

	@Override
	public double getValue(int labelIndex) {
		double value = 1.0 - InformationRetrievalMeasuresPT.balancedAccuracy(this.truePositives[labelIndex],
				this.falsePositives[labelIndex], this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
		return value;
	}

	@Override
	public String getName() {
		return "Macro-averaged balanced accuracy";
	}

	@Override
	public double getValue() {
		double sum = 0;
        int count = 0;
        for (int labelIndex = 0; labelIndex < this.numOfLabels; labelIndex++) {
            sum += 1.0- InformationRetrievalMeasuresPT.balancedAccuracy(this.truePositives[labelIndex],
                    this.falsePositives[labelIndex],
                    this.falseNegatives[labelIndex],this.trueNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}

}
