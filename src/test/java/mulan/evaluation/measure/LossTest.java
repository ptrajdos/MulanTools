package mulan.evaluation.measure;

import java.util.Arrays;
import java.util.Random;

import junit.framework.TestCase;
import mulan.classifier.MultiLabelOutput;
import mulan.evaluation.GroundTruth;

public abstract class LossTest extends TestCase {
	
	protected Random rnd = new Random(0);


	public LossTest(String name) {
		super(name);
	}
	
	public abstract Measure getMeasure();
	public abstract Measure getMeasure(int numLabels);
	public abstract double getWorstValue();
	
	
	public void testLossRndOneExample() {
		
		int numIterations = 1000;
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
				
				this.checkProcedure(meas);
			}
	}
	
	public void testLossRndCumulative() {
			
			int numIterations = 1000;
			int[] numLabels = {2,3,5,8};
			for(int l =0;l<numLabels.length;l++) {
				Measure meas = this.getMeasure(numLabels[l]);
				for(int i=0;i<numIterations;i++) {
					
					boolean[] pred = this.generateBipartition(numLabels[l], i);
					double[] predsupp = this.getDoublesFromBool(pred);
					
					boolean[] gt = this.generateBipartition(numLabels[l], i+1);
					MultiLabelOutput mlo = new MultiLabelOutput(predsupp,0.5);
					GroundTruth gtO = new GroundTruth(gt);				
					meas.update(mlo, gtO);
				}
				this.checkProcedure(meas);
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
				this.checkProcedure(meas);
			}
		}
	
	public void testLossOposite() {
		int numIterations = 1000;
		int[] numLabels = {2,3,5,8};
		int seed=0;
		for(int l =0;l<numLabels.length;l++) {
			Measure meas = this.getMeasure(numLabels[l]);
			for(int i=0;i<numIterations;i++) {
				boolean[] pred = this.generateBipartition(numLabels[l], seed++);
				double[] predsupp = this.getDoublesFromBool(pred);
				
				boolean[] gt = this.negate(pred);
				MultiLabelOutput mlo = new MultiLabelOutput(predsupp,0.5);
				GroundTruth gtO = new GroundTruth(gt);				
				meas.update(mlo, gtO);
				
			}
			this.checkProcedureWorst(meas);
		}
	}
	
	
	public void testLossPerfect() {
		int numIterations = 1000;
		int[] numLabels = {2,3,5,8};
		for(int l =0;l<numLabels.length;l++) {
			Measure meas = this.getMeasure(numLabels[l]);
			for(int i=0;i<numIterations;i++) {
				boolean[] pred = this.generateBipartition(numLabels[l], i);
				double[] predsupp = this.getDoublesFromBool(pred);
				
				boolean[] gt = Arrays.copyOf(pred, pred.length);
				MultiLabelOutput mlo = new MultiLabelOutput(predsupp,0.5);
				GroundTruth gtO = new GroundTruth(gt);				
				meas.update(mlo, gtO);
				
			}
			this.checkProcedurePerfect(meas);
		}
	}
	
	public void testLossName() {
		Measure measure = this.getMeasure();
		assertTrue("Not null name", measure.getName() != null);
	}
	
	/**
	 * Creates a random bipartition based on the given seed.
	 * @param numLabels -- number of labels in the created prediction
	 * @param seed -- random seed
	 * @return -- random, multilabel bipartition
	 */
	public boolean[] generateBipartition(int numLabels, int seed) {
		boolean[] bipart = new boolean[numLabels];
		for(int i=0;i<numLabels;i++)
			bipart[i] = rnd.nextBoolean();
		
		return bipart;
	}
	
	/**
	 * Negate the boolean array
	 * @param array -- An array to negate
	 * @return -- Negated array
	 */
	public boolean[] negate(boolean[] array) {
		
		boolean[] neg = new boolean[array.length];
		for(int i=0;i<array.length;i++)
			neg[i] = !array[i];
		return neg;
	}
	
	/**
	 * Generate doubles prediction from boolean array. 
	 * true -> 1.0
	 * false -> 0.0
	 * @param array -- array to convert
	 * @return converted array
	 */
	public double[] getDoublesFromBool(boolean[] array) {
		double[] res = new double[array.length];
		
		for(int i=0;i<array.length;i++)
			res[i] = array[i]? 1.0:0.0;
		
		return res;
	}
	
	/**
	 * Checks the measure value against:
	 * NaN, Infinity, range
	 * @param measure
	 */
	public void checkValue(Measure measure) {
		double val = measure.getValue();
		assertTrue("NaN check", !Double.isNaN(val));
		assertTrue("Finite val check", Double.isFinite(val));
		assertTrue("Interval lower bound check", val >=measure.getIdealValue());
		assertTrue("Interval upper bound check", val <= this.getWorstValue() );
	}
	/**
	 * Checks whether the value is better than the average.
	 * @param measure
	 */
	public void checkPerfect(Measure measure) {
		double val = measure.getValue();
		double idealV = measure.getIdealValue();
		double worse = this.getWorstValue();
		double compar = 0.5*(worse + idealV);
		assertTrue("Check perfect", val <= compar);
	}
	
	/**
	 * Checks whether the value is worse than the average.
	 * @param measure
	 */
	public void checkWorst(Measure measure) {
		double val = measure.getValue();
		double idealV = measure.getIdealValue();
		double worse = this.getWorstValue();
		double compar = 0.5*(worse + idealV);
		assertTrue("Check worst", val >= compar);
	}
	
	public void checkProcedure(Measure measure) {
		this.checkValue(measure);
	}
	
	public void checkProcedurePerfect(Measure measure) {
		this.checkValue(measure);
		this.checkPerfect(measure);
	}
	
	public void checkProcedureWorst(Measure measure) {
		this.checkValue(measure);
		this.checkWorst(measure);
	}
	

}
