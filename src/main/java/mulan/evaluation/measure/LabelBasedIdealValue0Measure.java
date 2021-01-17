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

/**
 * @author pawel trajdos
 * @since 0.0.1
 * @version 0.0.2
 *
 */
public abstract class LabelBasedIdealValue0Measure extends LabelBasedBipartitionMeasureBase {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5319494912620820220L;

	/**
     * Constructs a new object with given number of labels and beta parameter
     *
     * @param numOfLabels the number of labels
     * @param beta the beta parameter
     */
    public LabelBasedIdealValue0Measure(int numOfLabels) {
        super(numOfLabels);
    }

    @Override
    public double getIdealValue() {
        return 0;
    }

}