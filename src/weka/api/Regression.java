package weka.api;

import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SMOreg;

public class Regression {
	public static void linearRegression(String input) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		System.out.println("Step 2 - Regression (LinearRegression)");
		LinearRegression classifier = new LinearRegression();
		classifier.buildClassifier(dataset);
				
		System.out.println("Step 3 - Output");
		System.out.println(classifier);
	}
	
	public static void smoReg(String input) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		System.out.println("Step 2 - Regression (SMOreg)");
		SMOreg classifier = new SMOreg();
		classifier.buildClassifier(dataset);
				
		System.out.println("Step 3 - Output");
		System.out.println(classifier);
	}
}
