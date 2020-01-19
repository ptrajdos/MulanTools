/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package mulan.evaluation.measure;

import mulan.evaluation.measure.ExampleBasedBipartitionMeasureBase;
import mulan.evaluation.measure.InformationRetrievalMeasures;

/**
 * Implementation of the example-based F measure.
 *
 * @author Pawel Trajdos
 * @version 2013.12.08
 */
public class ExampleBasedTverskyMeasure extends ExampleBasedBipartitionMeasureBase {


    /**
	 * 
	 */
	private static final long serialVersionUID = 3247083774773240506L;
	
	protected double alpha=0.5;
	protected double beta=0.5;
	

	/**
     * Creates a new object
     *
     */
    public ExampleBasedTverskyMeasure() {
    }
    
    public ExampleBasedTverskyMeasure(double alpha,double beta) {
    	this.alpha=alpha;
    	this.beta=beta;
    }
    


    @Override
    public String getName() {
        return "Example-Based Jaccard Measure";
    }

    @Override
    public double getIdealValue() {
        return 1;
    }

    @Override
    protected void updateBipartition(boolean[] bipartition, boolean[] truth) {
        double tp = 0;
        double fp = 0;
        double fn = 0;
        for (int i = 0; i < truth.length; i++) {
            if (bipartition[i] && truth[i]) {
                tp++;
            }
            if (bipartition[i] && !truth[i]) {
                fp++;
            }
            if (!bipartition[i] && truth[i]) {
                fn++;
            }
        }

        this.sum +=1.0 -  InformationRetrievalMeasures.Tversky(tp, fp, fn, this.alpha, this.beta);
        this.count++;
    }
}