package mulan.evaluation.measure;

public class MacroPrecisionMeasure extends LabelBasedPrecisionMeasure implements
		MacroAverageMeasure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7117382660843737685L;

	public MacroPrecisionMeasure(int aNumOfLabels) {
		super(aNumOfLabels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "MacroPrecisionM";
	}

	@Override
	public double getValue() {
		double sum = 0;
        int count = 0;
        for (int labelIndex = 0; labelIndex < numOfLabels; labelIndex++) {
            sum +=1.0- InformationRetrievalMeasuresPT.precision(truePositives[labelIndex],
                    falsePositives[labelIndex],
                    falseNegatives[labelIndex]);
            count++;
        }
        return sum / count;
	}

	@Override
	public double getValue(int labelIndex) {
		return 1.0-InformationRetrievalMeasuresPT.precision(truePositives[labelIndex],
                falsePositives[labelIndex],
                falseNegatives[labelIndex]);
	}

}
