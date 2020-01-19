/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasures;
import mulan.evaluation.measure.MacroAverageMeasure;

/**
 * @author pawel
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
            sum += InformationRetrievalMeasures.Kappa(this.truePositives[labelIndex], this.falsePositives[labelIndex],
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
		return  InformationRetrievalMeasures.Kappa(this.truePositives[labelIndex], this.falsePositives[labelIndex],
				this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
	}

}
