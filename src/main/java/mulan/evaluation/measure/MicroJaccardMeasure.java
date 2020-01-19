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

import mulan.evaluation.measure.InformationRetrievalMeasures;
import weka.core.Utils;

/**
 * Implementation of the micro-averaged Jaccardmeasure.
 *
 * @author Grigorios Tsoumakas
 * @author Pawel Trajdos
 * @version 2013.12.08
 */
public class MicroJaccardMeasure extends LabelBasedJaccardMeasure {

    /**
     * Constructs a new object with given number of labels and beta=1
     *
     * @param numOfLabels the number of labels
     */
    public MicroJaccardMeasure(int numOfLabels) {
        super(numOfLabels);
    }

    @Override
    public double getValue() {
        double tp = Utils.sum(truePositives);
        double fp = Utils.sum(falsePositives);
        double fn = Utils.sum(falseNegatives);
        return  1.0 - InformationRetrievalMeasures.JaccardMeasure(tp, fp, fn);
    }

    @Override
    public String getName() {
        return "Micro-averaged Jaccard-Measure";
    }
}