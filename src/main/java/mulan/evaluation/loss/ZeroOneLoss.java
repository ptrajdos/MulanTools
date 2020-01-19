package mulan.evaluation.loss;

import mulan.evaluation.loss.BipartitionLossFunctionBase;

/**
 * Class implements Zero-one-criterion-based loss function
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
 *
 */

public class ZeroOneLoss extends BipartitionLossFunctionBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5300227866365526950L;

	@Override
	public String getName() {
		
		return "Zero One Loss";
	}

	@Override
	public double computeLoss(boolean[] bipartition, boolean[] groundTruth) {
		
		for(int i=0;i<groundTruth.length;i++){
			if(bipartition[i] != groundTruth[i]){
				return 1.0;
			}
		}
		return 0.0;
	}

}
