/**
 * 
 */
package mulan.evaluation.loss;

import java.io.Serializable;

/**
 * A class creates simple bianry confusion matrix.
 * The class is calculated using two boolean vectors -- bipartition and ground truth
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
 *
 */
public class SimpleBinaryConfusionMatrix implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6386413077720987757L;
	
	private double tp,fp,fn,tn;
	

	/**
	 * Create the object
	 * @param bipartition -- bipartition produced by a classifier (for example)
	 * @param groundTruth -- ground truth partition provided by an expert
	 */
	public SimpleBinaryConfusionMatrix(boolean[] bipartition, boolean[] groundTruth) {
		for (int i = 0; i < groundTruth.length; i++) {
            if (bipartition[i] && groundTruth[i]) {
                this.tp++;
            }
            if (bipartition[i] && !groundTruth[i]) {
                this.fp++;
            }
            if (!bipartition[i] && groundTruth[i]) {
                this.fn++;
            }
            
            if (!bipartition[i] && !groundTruth[i]) {
                this.tn++;
            }
            
        }
	}


	/**
	 * @return the tp
	 */
	public double getTp() {
		return this.tp;
	}


	/**
	 * @return the fp
	 */
	public double getFp() {
		return this.fp;
	}


	/**
	 * @return the fn
	 */
	public double getFn() {
		return this.fn;
	}


	/**
	 * @return the tn
	 */
	public double getTn() {
		return this.tn;
	}
	
	

}
