package weka.api;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.functions.SMO; 

public class Classification {
	public static void naivebayes (String input) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		System.out.println("Step 2 - Applying the classifier");
		NaiveBayes classifier = new NaiveBayes();
		
		classifier.buildClassifier(dataset);
		
		System.out.println("Step 3 - Saving the file (ARFF Format)");
		System.out.println(classifier.getCapabilities().toString());
		System.out.println(classifier.toString());
		
		System.out.println("Finish");
	}
	
	public static void j48 (String input) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		System.out.println("Step 2 - Applying the classifier");
		J48 classifier = new J48();
		
		classifier.buildClassifier(dataset);
		
		System.out.println("Step 3 - Saving the file (ARFF Format)");
		System.out.println(classifier.getCapabilities().toString());
		System.out.println(classifier.toString());
		
		System.out.println("Finish");
	}
	
	public static void smo (String input) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		
		System.out.println("Step 2 - Applying the classifier");
		SMO classifier = new SMO();
		
		classifier.buildClassifier(dataset);
		
		System.out.println("Step 3 - Saving the file (ARFF Format)");
		System.out.println(classifier.getCapabilities().toString());
		System.out.println(classifier.toString());
		
		System.out.println("Finish");
	}
}
