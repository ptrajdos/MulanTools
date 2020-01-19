/**
 * 
 */
package mulan.tools.wekaCompatibility;

import mulan.data.InvalidDataFormatException;
import mulan.data.MultiLabelInstances;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Utils;

/**
 * @author pawel trajdos
 * @since 0.0.2
 * @version 0.0.2
 *
 */
public class GroundTruthExtractor {

	/**
	 * Extract ground truth from single Label Instance
	 * @param inst
	 * @return
	 */
	public static boolean[] extractGroundTruthSL(Instance inst) {
		
		int numClasses = inst.numClasses();
		int trueClassIdx =(int) inst.classValue();
		
		boolean[] response = new boolean[numClasses];
		response[trueClassIdx] = true;
		
		
		return response;
	}
	
	public static boolean[] extractGroundTruthMulan(Instance mlInstance,MultiLabelInstances dataset) throws InvalidDataFormatException {
		boolean compatible = dataset.getDataSet().checkInstance(mlInstance);
		if(!compatible)throw new InvalidDataFormatException("Inastance is incompatible");
		
		int numLabels = dataset.getNumLabels();
		boolean[] groundTruth = new boolean[numLabels];
		
		int[] labelIndices = dataset.getLabelIndices();
		double[] instanceDoubleRepresentation = mlInstance.toDoubleArray();
		Attribute labAttr = null; 
		for(int l =0 ;l<numLabels;l++){
			labAttr = dataset.getDataSet().attribute(l);
			groundTruth[l] = (labAttr.indexOfValue("1") == instanceDoubleRepresentation[labelIndices[l]])? true:false;
		}
		return groundTruth;
	}
	
	public static boolean[] createBipartitionFromDistribution(double[] distribution) {
		int numClasses = distribution.length;
		boolean[] response = new boolean[numClasses];
		response[Utils.maxIndex(distribution)]=true;
		
		return response;
	}
	
	

}
