package mulan.evaluation.measure;

import java.util.Random;

import junit.framework.TestCase;
import mulan.classifier.MultiLabelOutput;
import mulan.evaluation.GroundTruth;
import weka.core.Utils;

public abstract class LossTest extends TestCase {


	public LossTest(String name) {
		super(name);
	}
	
	public abstract Measure getMeasure();
	public abstract Measure getMeasure(int numLabels);
	public abstract double getWostValue();
	
	
	public void testLossRnd() {
		
		int numIterations = 100;
		int[] numLabels = {2,3,5,8};
		for(int l =0;l<numLabels.length;l++)
			for(int i=0;i<numIterations;i++) {
				Measure meas = this.getMeasure(numLabels[l]);
				boolean[] pred = this.generateBipartition(numLabels[l], i);
				double[] predsupp = this.getDoublesFromBool(pred);
				
				boolean[] gt = this.generateBipartition(numLabels[l], i+1);
				MultiLabelOutput mlo = new MultiLabelOutput(predsupp,0.5);
				GroundTruth gtO = new GroundTruth(gt);				
				meas.update(mlo, gtO);
				
				this.checkValue(meas);
			}
	}
	
	public void testLossRndM() {
			
			int numIterations = 100;
			int[] numLabels = {2,3,5,8};
			for(int l =0;l<numLabels.length;l++){
				Measure meas = this.getMeasure(numLabels[l]);
				for(int i=0;i<numIterations;i++){
					
					boolean[] pred = this.generateBipartition(numLabels[l], i);
					double[] predsupp = this.getDoublesFromBool(pred);
					
					boolean[] gt = this.generateBipartition(numLabels[l], i+1);
					MultiLabelOutput mlo = new MultiLabelOutput(predsupp,0.5);
					GroundTruth gtO = new GroundTruth(gt);				
					meas.update(mlo, gtO);
				}
				this.checkValue(meas);
			}
		}
	
	public void testLossOposite() {
		int numIterations = 1000;
		int[] numLabels = {2,3,5,8};
		for(int l =0;l<numLabels.length;l++) {
			Measure meas = this.getMeasure(numLabels[l]);
			for(int i=0;i<numIterations;i++) {
				boolean[] pred = this.generateBipartition(numLabels[l], i);
				double[] predsupp = this.getDoublesFromBool(pred);
				
				boolean[] gt = this.negate(pred);
				MultiLabelOutput mlo = new MultiLabelOutput(predsupp,0.5);
				GroundTruth gtO = new GroundTruth(gt);				
				meas.update(mlo, gtO);
				
			}
			double val = meas.getValue();
			this.checkValue(meas);
			assertTrue("Worst prediction:", val>meas.getIdealValue()  );
		}
	}
	
	
	public boolean[] generateBipartition(int numLabels, int seed) {
		boolean[] bipart = new boolean[numLabels];
		Random rnd = new Random(seed);
		for(int i=0;i<numLabels;i++)
			bipart[i] = rnd.nextBoolean();
		
		return bipart;
	}
	
	public boolean[] negate(boolean[] array) {
		
		boolean[] neg = new boolean[array.length];
		for(int i=0;i<array.length;i++)
			neg[i] = !array[i];
		return neg;
	}
	
	public double[] getDoublesFromBool(boolean[] array) {
		double[] res = new double[array.length];
		
		for(int i=0;i<array.length;i++)
			res[i] = array[i]? 1.0:0.0;
		
		return res;
	}
	
	public void checkValue(Measure measure) {
		double val = measure.getValue();
		assertTrue("Interval [0;1] checking", val <= 1.0 & val >=0);
	}
	

}
