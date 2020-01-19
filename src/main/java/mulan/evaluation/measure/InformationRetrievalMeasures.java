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

import weka.core.Utils;

/**
 * Class for computing various information retrieval measures.
 *
 * Based on the code written by Grigorios Tsoumakas
 * @author Pawel Trajdos
 * @since 0.0.1
 * @version 0.0.2
 */
public class InformationRetrievalMeasures {
	
	public static double EPS=1E-6;
	
	 /**
     * Computation of Jaccard-measure based on tp, fp, fn. We treat special
     * cases with empty set predictions or/and ground truth as follows: (i) if
     * the algorithm outputs the empty set and the ground truth is the empty
     * set, then we consider F equal to 1 (ii) if the algorithm outputs the
     * empty set and the ground truth is not empty, then we consider Jaccard equal to
     * 0 (iii) if the ground truth is empty and the algorithm does not output
     * the empty set, then we consider Jaccard equal to 0 (iv) if neither the ground
     * truth nor the algorithm's prediction is the empty set and their
     * intersection is empty, then we consider Jaccard equal to 0.
     *
     * @param tp true positives
     * @param fp false positives
     * @param fn false negatives
     * @return the value of the Jaccard-measure
     */
    public static double JaccardMeasure(double tp, double fp, double fn) {
    	double denom = tp + fp + fn; 
        if ( denom < EPS) {
            return 1.0;
        }
        return (tp)/denom;
    }


    /**
     * Computation of F-measure based on tp, fp, fn and beta. We treat special
     * cases with empty set predictions or/and ground truth as follows: (i) if
     * the algorithm outputs the empty set and the ground truth is the empty
     * set, then we consider F equal to 1 (ii) if the algorithm outputs the
     * empty set and the ground truth is not empty, then we consider F equal to
     * 0 (iii) if the ground truth is empty and the algorithm does not output
     * the empty set, then we consider F equal to 0 (iv) if neither the ground
     * truth nor the algorithm's prediction is the empty set and their
     * intersection is empty, then we consider F equal to 0.
     *
     * @param tp true positives
     * @param fp false positives
     * @param fn false negatives
     * @param beta controls the relative importance of recall versus precision
     * @return the value of the f-measure
     */
    public static double fMeasure(double tp, double fp, double fn, double beta) {
    	double denom = tp + fp + fn; 
        if ( denom < EPS) {
            return 1.0;
        }
        double beta2 = beta * beta;
        return ((beta2 + 1) * tp) / ((beta2 + 1) * tp + beta2 * fn + fp);
    }

    /**
     * Computation of precision based on tp, fp and fn. We treat special cases
     * with empty set predictions or/and ground truth as follows: (i) if the
     * algorithm outputs the empty set and the ground truth is the empty set,
     * then we consider precision equal to 1 (ii) if the algorithm outputs the
     * empty set and the ground truth is not empty, then we consider precision
     * equal to 0.
     *
     * @param tp true positives
     * @param fp false positives
     * @param fn false negatives
     * @return the value of precision
     */
    public static double precision(double tp, double fp, double fn) {
        if (tp + fp + fn < EPS) {
            return 1.0;
        }
        if (tp + fp < EPS) {
            return 0.0;
        }
        return tp / (tp + fp);
    }

    /**
     * Computation of recall based on tp, fp and fn. We treat special cases with
     * empty set predictions or/and ground truth as follows: (i) if the
     * algorithm outputs the empty set and the ground truth is the empty set,
     * then we consider recall equal to 1 (ii) if the algorithm does not output
     * the empty set and the ground truth is empty, then we consider recall
     * equal to 0.
     *
     * @param tp true positives
     * @param fp false positives
     * @param fn false negatives
     * @return the value of recall
     */
    public static double recall(double tp, double fp, double fn) {
        if (tp + fp + fn < EPS) {
            return 1.0;
        }
        if (tp + fn < EPS) {
            return 0.0;
        }
        return tp / (tp + fn);
    }

    /**
     * Computation of specificity based on tn, fp and fn. We treat special cases
     * with empty set predictions or/and ground truth as follows: (i) if the
     * algorithm outputs the set of all labels and the ground truth is the set
     * of all labels, then we consider specificity equal to 1 (ii) if the ground
     * truth is the set of all labels and the algorithm does not output the set
     * of all labels, then we consider specificity equal to 0.
     *
     * @param tn true negatives
     * @param fp false positives
     * @param fn false negatives
     * @return the value of specificity
     */
    public static double specificity(double tn, double fp, double fn) {
        if (tn + fp + fn < EPS) {
            return 1.0;
        }
        if (tn + fp < EPS) {
            return 0.0;
        }
        return tn / (tn + fp);
    }
    
    /**
     * Computation of Tversky index based on tn, fp and fn. We treat special cases
     * with empty set predictions or/and ground truth as follows: (i) if the
     * algorithm outputs the set of all labels and the ground truth is the set
     * of all labels, then we consider specificity equal to 1 (ii) if the ground
     * truth is the set of all labels and the algorithm does not output the set
     * of all labels, then we consider specificity equal to 0.
     *
     * @param n00 true negatives
     * @param fp false positives
     * @param fn false negatives
     * @return the value of Tversky index
     */
    public static double Tversky(double tp, double fp, double fn,double alpha,double beta) {
        if (Utils.eq(tp+alpha*fn+beta*fp, 0)) {
            return 1.0;
        }
  
        
        return tp / (tp+alpha*fn+beta*fp );
    }
    
    /**
     * Calculates Mathews correlation coefficient
     * Scaled to [0,1]. The original interval is [-1,1]
     * 0 -- perfect classification
     * 0.5 -- no better than random
     * 1 -- total disagreement between prediction and ground truth
     * @param tp
     * @param fp
     * @param fn
     * @param tn
     * @return
     */
    public static double Matthews(double tp, double fp, double fn,double tn) {
    	
    	double a,b,c,d;
    	double denominator =0;
    	a = tp + fp;
    	b = tp + fn;
    	c = tn + fp;
    	d = tn + fn;
    	if(a < EPS || b < EPS || c < EPS || d < EPS ){
    		denominator =1.0;
    	}else{
    		denominator = Math.sqrt(a*b*c*d);
    	}
    	
    	double numerator = tp*tn - fp*fn;
    	double matthews = 1.0 -  (1 + numerator/denominator)*0.5;		
    	
    	return matthews;
    }
    
    public static double Kappa(double tp, double fp, double fn,double tn) {
    	double sum = tp+fp+fn+tn;
    	double p0 = (tp+tn)/sum;
    	double pYes = (tp+fp)*(tp+fn)/(sum*sum);
    	double pNo = (tn+fn)*(fp+tn)/(sum*sum);
    	double pE = pYes + pNo;
    	
    	double denom=(1-pE);
    	double kappa;
    	if(denom < EPS) {
    		kappa=p0;
    	}else {
    		kappa = (p0-pE)/(1-pE);
    	}
    	
    	double kappaNormalized = 1.0 -  (1 + kappa)*0.5;
    	return kappaNormalized;
    }
    
    /**
     * The method implements Kappa_m function described in 
     * @inproceedings{bifet2015efficient,
 		author = {Bifet, Albert and de Francisci Morales, Gianmarco and Read, Jesse and Holmes, Geoff and Pfahringer, Bernhard},
 		title = {Efficient Online Evaluation of Big Data Stream Classifiers},
 		booktitle = {Proceedings of the 21th ACM SIGKDD International Conference on Knowledge Discovery and Data Mining - KDD '15},
 		pages = {59--68},
 		year = {2015},
 		organization = {ACM},
 		doi = {10.1145/2783258.2783372},
 		source = {Crossref},
 		url = {https://doi.org/10.1145/2783258.2783372},
 		publisher = {ACM Press},
 		isbn = {9781450336642},
		}
	 * @author pawel trajdos
     * @param tp
     * @param fp
     * @param fn
     * @param tn
     * @return
     */
    
    public static double KappaM(double tp, double fp, double fn,double tn) {
    	double sum = tp + fp +fn + tn;
    	double p0 = (tp+tn)/sum;
    	
    	double pp = (tp + fp)/sum;
    	double pn = (tn + fn)/sum;
    	double pm = Math.max(pp, pn);
    	double denom = 1 - pm;
    	double kappa;
    	if(denom < EPS) {
    		kappa = p0;
    	}else {
    		kappa = (p0 - pm)/denom;
    	}
    	
    	 
    	double kappaNormalized = 1.0 -  (1 + kappa)*0.5;
    	return kappaNormalized;
    }
    
    
    public static double Hamming(double tp, double fp, double fn,double tn) {
    	double denominator = tp+fp+fn+tn;
    	double numerator = fp+fn;
    	return numerator/denominator;
    }
    
    
    public static double ZeroOne(double tp, double fp, double fn,double tn) {

    	double val = fp+fn;
    	
    	return val>0?1:0;
    }
}