/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasures;
import mulan.evaluation.measure.MacroAverageMeasure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class MacroKappaMMeasure extends LabelBasedMathewsMeasure implements
MacroAverageMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4426969987682134160L;

	/**
	 * @param aNumOfLabels
	 */
	public MacroKappaMMeasure(int aNumOfLabels) {
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
            sum += InformationRetrievalMeasures.KappaM(this.truePositives[labelIndex], this.falsePositives[labelIndex],
            												this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}
	
	
	@Override
	public String getName() {
		return new String("Macro_KappaM");
	}

	@Override
	public double getValue(int labelIndex) {
		return  InformationRetrievalMeasures.KappaM(this.truePositives[labelIndex], this.falsePositives[labelIndex],
				this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
	}

}
