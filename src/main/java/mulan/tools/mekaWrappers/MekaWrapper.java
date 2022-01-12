/**
 * 
 */
package mulan.tools.mekaWrappers;

import meka.classifiers.multilabel.MultilabelClassifier;
import mulan.classifier.InvalidDataException;
import mulan.classifier.MultiLabelLearnerBase;
import mulan.classifier.MultiLabelOutput;
import mulan.data.MultiLabelInstances;
import weka.classifiers.AbstractClassifier;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Randomizable;
import weka.core.TechnicalInformation;

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.1
 *
 */
public class MekaWrapper extends MultiLabelLearnerBase implements Randomizable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7813157755476938221L;
	MultilabelClassifier mekaClassifier;
	MultiLabelInstances setInfo;

	/**
	 * 
	 */
	public MekaWrapper(MultilabelClassifier mekaClassifier) {
		try {
			this.mekaClassifier = (MultilabelClassifier) AbstractClassifier.makeCopy(mekaClassifier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see mulan.classifier.MultiLabelLearnerBase#buildInternal(mulan.data.MultiLabelInstances)
	 */
	@Override
	protected void buildInternal(MultiLabelInstances trainingSet)
			throws Exception {
		Instances tmpInstances = trainingSet.getDataSet();
		tmpInstances.setClassIndex(this.numLabels);
		this.mekaClassifier.buildClassifier(tmpInstances);
		
		this.setInfo = new MultiLabelInstances(new Instances(trainingSet.getDataSet(), 0), trainingSet.getLabelsMetaData());

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
				if(Math.abs(1-supports[i])<eps){
					convSupports[i] = supports[i+this.numLabels];
				}else{
					convSupports[i] = 1-supports[i+this.numLabels];
				}
			}
		
			return new MultiLabelOutput(convSupports, 0.5);
		}
		return new MultiLabelOutput(supports, 0.5);
	}

	/* (non-Javadoc)
	 * @see mulan.classifier.MultiLabelLearnerBase#getTechnicalInformation()
	 */
	@Override
	public TechnicalInformation getTechnicalInformation() {
		return null;
	}

	public MultilabelClassifier getBaseClassifier(){
		return this.mekaClassifier;
	}
	
	public String globalInfo() {
		return "A wrapper that allows Mulan to use a Meka classifier";
	}

	@Override
	public void setSeed(int seed) {
		if(this.mekaClassifier instanceof Randomizable){
			((Randomizable)this.mekaClassifier).setSeed(seed);
		}
		
	}

	@Override
	public int getSeed() {
		int seed=0;
		if(this.mekaClassifier instanceof Randomizable){
			seed=((Randomizable)this.mekaClassifier).getSeed();
			
		}
		return seed;
	}

	

}
