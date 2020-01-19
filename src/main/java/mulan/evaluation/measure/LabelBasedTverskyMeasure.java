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
abstract public class LabelBasedTverskyMeasure extends LabelBasedIdealValue0Measure {

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



}
