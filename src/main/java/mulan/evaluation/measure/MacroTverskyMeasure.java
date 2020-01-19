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
public class MacroTverskyMeasure extends LabelBasedTverskyMeasure implements
		MacroAverageMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5280444176813231254L;

	/**
	 * @param aNumOfLabels
	 */
	public MacroTverskyMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
	}

	/**
	 * @param aNumOfLabels
	 * @param alpha
	 * @param beta
	 */
	public MacroTverskyMeasure(int aNumOfLabels, double alpha, double beta) {
		super(aNumOfLabels, alpha, beta);
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getName()
	 */
	@Override
	public String getName() {
		String desc ="Macro_Tversky_A"+this.alpha+"_B"+this.beta;
		return desc;
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getValue()
	 */
	@Override
	public double getValue() {
		double sum = 0;
        int count = 0;
        for (int labelIndex = 0; labelIndex < this.numOfLabels; labelIndex++) {
            sum +=1.0- InformationRetrievalMeasures.Tversky(this.truePositives[labelIndex],
                    this.falsePositives[labelIndex],
                    this.falseNegatives[labelIndex], this.alpha, this.beta);
            count++;
        }
        return sum / count;
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.MacroAverageMeasure#getValue(int)
	 */
	@Override
	public double getValue(int labelIndex) {
		 return 1.0-InformationRetrievalMeasures.Tversky(this.truePositives[labelIndex],
	                this.falsePositives[labelIndex],
	                this.falseNegatives[labelIndex], this.alpha, this.beta);
	}

}
