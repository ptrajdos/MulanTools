/**
 * 
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.LabelBasedBipartitionMeasureBase;

/**
 * @author pawel
 *
 */
abstract public class LabelBasedTverskyMeasure extends LabelBasedBipartitionMeasureBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9159848562663436406L;
	protected double alpha;
	protected double beta;
	
	/**
	 * @param aNumOfLabels
	 */
	public LabelBasedTverskyMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		//default parameters -> F1 score
		this.alpha=0.5;
		this.beta=0.5;
	}
	public LabelBasedTverskyMeasure(int aNumOfLabels,double alpha,  double beta) {
		super(aNumOfLabels);
		this.alpha= alpha;
		this.beta=beta;
	}

	/* (non-Javadoc)
	 * @see mulan.evaluation.measure.Measure#getIdealValue()
	 */
	@Override
	public double getIdealValue() {
		return 0.0;
	}

}
