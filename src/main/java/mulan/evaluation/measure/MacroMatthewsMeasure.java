/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.InformationRetrievalMeasuresPT;
import mulan.evaluation.measure.MacroAverageMeasure;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public class MacroMatthewsMeasure extends LabelBasedMathewsMeasure implements
MacroAverageMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2283447286057936132L;

	/**
	 * @param aNumOfLabels
	 */
	public MacroMatthewsMeasure(int aNumOfLabels) {
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
            sum += InformationRetrievalMeasuresPT.Matthews(this.truePositives[labelIndex], this.falsePositives[labelIndex],
            												this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}
	
	
	@Override
	public String getName() {
		return new String("Macro_Matthews");
	}

	@Override
	public double getValue(int labelIndex) {
		return  InformationRetrievalMeasuresPT.Matthews(this.truePositives[labelIndex], this.falsePositives[labelIndex],
				this.falseNegatives[labelIndex], this.trueNegatives[labelIndex]);
	}

}
