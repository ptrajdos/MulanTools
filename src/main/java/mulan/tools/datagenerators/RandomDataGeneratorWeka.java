/**
 * 
 */
package mulan.tools.datagenerators;

import java.io.Serializable;
import java.util.Arrays;

import mulan.data.LabelNodeImpl;
import mulan.data.LabelsMetaDataImpl;
import mulan.data.MultiLabelInstances;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.Remove;
import weka.tools.data.DataGenerator;
import weka.tools.data.RandomDataGenerator;

/**
 * @author pawel trajdos
 * @since 0.4.0
 * @version 0.4.0
 *
 */
public class RandomDataGeneratorWeka implements Serializable, MulanDataGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -354029768414685265L;
	
	protected DataGenerator generator = new RandomDataGenerator();

	/**
	 * 
	 */
	public RandomDataGeneratorWeka() {
	}
	
	public RandomDataGeneratorWeka(DataGenerator generator) {
		this.generator = generator;
	}

	/**
	 * @return the generator
	 */
	public DataGenerator getGenerator() {
		return this.generator;
	}

	/**
	 * @param generator the generator to set
	 */
	public void setGenerator(DataGenerator generator) {
		this.generator = generator;
	}

	@Override
	public MultiLabelInstances generateData()throws Exception {
		Instances slInstances = this.generator.generateData();
		
		MultiLabelInstances mlInstances = this.generateInternal(slInstances);
		
		return mlInstances;
	}
	
	protected MultiLabelInstances generateInternal(Instances data) throws Exception {
		if(data.classIndex() == -1)
			throw new Exception("No class Attribute is set");
		
		Instances copiedInstances = new Instances(data);
		Remove classRemover = new Remove();
		classRemover.setInvertSelection(false);
		classRemover.setAttributeIndicesArray(new int[] {data.classIndex()});
		classRemover.setInputFormat(copiedInstances);
		
		Instances classRemovedInstances = Filter.useFilter(copiedInstances, classRemover); 
		
		copiedInstances = new Instances(classRemovedInstances, 0);
		
	
		
		int numLabels = data.numClasses();
		LabelsMetaDataImpl metadata = new LabelsMetaDataImpl();
		
		for(int i=0;i<numLabels;i++) {
			String labelName = "L_"  + i;
			Add addLabel = new Add();
			addLabel.setAttributeIndex("last");
			addLabel.setAttributeName(labelName);
			addLabel.setNominalLabels("0,1");
			addLabel.setInputFormat(copiedInstances);
			
			copiedInstances = Filter.useFilter(copiedInstances, addLabel);
			metadata.addRootNode(new LabelNodeImpl(labelName));
		}
		
		
		
		MultiLabelInstances mli = new MultiLabelInstances(copiedInstances, metadata);
		
		int[] labelIndices = mli.getLabelIndices();
		int numInstances = classRemovedInstances.numInstances();
		int numOVerallAttributes = copiedInstances.numAttributes();
		
		Instance tmpSLInstance; 
		Instance tmpMLInstance;
		double[] slreprezentation;
		double[] mlreprezentation;
		
		
		for(int i=0;i<numInstances;i++) {
			
			tmpSLInstance = classRemovedInstances.get(i);
			int classIdx = (int) data.get(i).classValue();
			slreprezentation = tmpSLInstance.toDoubleArray();
			
			mlreprezentation = Arrays.copyOf(slreprezentation, numOVerallAttributes);
			mlreprezentation[labelIndices[classIdx]]=1.0;
			
			tmpMLInstance = new DenseInstance(1.0, mlreprezentation);
			tmpMLInstance.setDataset(copiedInstances);
			
			copiedInstances.add(tmpMLInstance);
		
		}
		
		return mli;
	}
	

}
