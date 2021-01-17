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
public class MacroKappaMeasure extends LabelBasedMathewsMeasure implements
MacroAverageMeasure {

	/**
	 * 
	 */
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 764384227158542451L;

	/**
	 * @param aNumOfLabels
	 */
	public MacroKappaMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getValue()
	 */
	@Override
	public double getValue() {
		double sum = 0;
        int count = 0;
        for (int labelIndex = 0; labelIndex < this.numOfLabels; labelIndex++) {
            sum += InformationRetrievalMeasuresPT.Kappa(this.truePositives[labelIndex], this.falsePositives[labelIndex],
            												this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}
	
	
	@Override
	public String getName() {
		return new String("Macro_Kappa");
	}

	@Override
	public double getValue(int labelIndex) {
		return  InformationRetrievalMeasuresPT.Kappa(this.truePositives[labelIndex], this.falsePositives[labelIndex],
				this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
	}

}
