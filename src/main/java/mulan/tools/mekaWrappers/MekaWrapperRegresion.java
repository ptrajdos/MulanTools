/**
 * 
 */
package mulan.tools.mekaWrappers;

import meka.classifiers.multilabel.MultilabelClassifier;
import mulan.classifier.InvalidDataException;
import mulan.classifier.MultiLabelOutput;
import weka.core.Instance;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
 *
 */
public class MekaWrapperRegresion extends MekaWrapper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3998343820190994680L;

	/**
	 * @param mekaClassifier
	 */
	public MekaWrapperRegresion(MultilabelClassifier mekaClassifier) {
		super(mekaClassifier);
	}
	
	/* (non-Javadoc)
	 * @see mulan.classifier.MultiLabelLearnerBase#makePredictionInternal(weka.core.Instance)
	 */
	@Override
	protected MultiLabelOutput makePredictionInternal(Instance instance)
			throws Exception, InvalidDataException {
		double[] supports;
		Instance infoInstance = (Instance)instance.copy();
		infoInstance.setDataset(this.setInfo.getDataSet());
		supports = this.mekaClassifier.distributionForInstance(infoInstance);
		double eps = 1E-6;
		if(supports.length == 2*this.numLabels){
		
			double[] convSupports = new double[this.numLabels];
			for(int i=0;i<this.numLabels;i++){
					convSupports[i] = supports[i+this.numLabels];
			}
		
			return new MultiLabelOutput(convSupports, 0.5);
		}
		return new MultiLabelOutput(supports, 0.5);
	}

}
