package weka.api;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.BayesNet;
import weka.classifiers.bayes.net.search.local.TANppfast;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.LibSVM;
import java.util.Random;

public class Evaluate {
	public static void etan (String train, String test, boolean cv, int nfolds) throws Exception {
		System.out.println("Step 1 - Reading the training data (ARFF Format)");
		DataSource source = new DataSource(train);
		Instances trainingset = source.getDataSet();
		trainingset.setClassIndex(trainingset.numAttributes()-1);
		
		System.out.println("Step 2 - Reading the testing data (ARFF Format)");
		DataSource source2 = new DataSource(test);
		Instances testset = source2.getDataSet();
		testset.setClassIndex(testset.numAttributes()-1);

		System.out.println("Step 3 - Setting ETAN Classifier");
		BayesNet bn = new BayesNet();
		TANppfast etan = new TANppfast();
		bn.setSearchAlgorithm(etan);
		bn.buildClassifier(trainingset);
		
		System.out.println("Step 4 - Evaluating");
		Evaluation eval = new Evaluation(trainingset);
		if (cv){
			Random random = new Random(1);
			eval.crossValidateModel(bn, trainingset, nfolds, random);
		}
		else {
			eval.evaluateModel(bn, testset);
		}
		
		System.out.println("Step 5 - Output");
		System.out.println(eval.toSummaryString("Evaluation results:\n", false));
		
		System.out.println("Correct % = "+eval.pctCorrect());
		System.out.println("Incorrect % = "+eval.pctIncorrect());
		System.out.println("AUC = "+eval.areaUnderROC(1));
		System.out.println("kappa = "+eval.kappa());
		System.out.println("MAE = "+eval.meanAbsoluteError());
		System.out.println("RMSE = "+eval.rootMeanSquaredError());
		System.out.println("RAE = "+eval.relativeAbsoluteError());
		System.out.println("RRSE = "+eval.rootRelativeSquaredError());
		System.out.println("Precision = "+eval.precision(1));
		System.out.println("Recall = "+eval.recall(1));
		System.out.println("fMeasure = "+eval.fMeasure(1));
		System.out.println("Error Rate = "+eval.errorRate());
		
		System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));
	
		System.out.println("Finish");
	}
	
	public static void libsvm (String train, String test, boolean cv, int nfolds) throws Exception {
		System.out.println("Step 1 - Reading the training data (ARFF Format)");
		DataSource source = new DataSource(train);
		Instances trainingset = source.getDataSet();
		trainingset.setClassIndex(trainingset.numAttributes()-1);
		
		System.out.println("Step 2 - Reading the testing data (ARFF Format)");
		DataSource source2 = new DataSource(test);
		Instances testset = source2.getDataSet();
		testset.setClassIndex(testset.numAttributes()-1);
		
		System.out.println("Step 3 - Setting LibSVM Classifier");
		LibSVM libsvm = new LibSVM();
		libsvm.setNormalize(true);
		libsvm.buildClassifier(trainingset);
		
		System.out.println("Step 4 - Evaluating");
		Evaluation eval = new Evaluation(trainingset);
		if (cv){
			Random random = new Random(1);
			eval.crossValidateModel(libsvm, trainingset, nfolds, random);
		}
		else {
			eval.evaluateModel(libsvm, testset);
		}
		
		System.out.println("SFMeanSchemeEntropy: "+eval.SFMeanSchemeEntropy());
		
		System.out.println("Step 5 - Output");
		System.out.println(libsvm.getCapabilities().toString());
		System.out.println(eval.toSummaryString("Evaluation results:\n", false));
		
		System.out.println("Correct % = "+eval.pctCorrect());
		System.out.println("Incorrect % = "+eval.pctIncorrect());
		System.out.println("AUC = "+eval.areaUnderROC(1));
		System.out.println("kappa = "+eval.kappa());
		System.out.println("MAE = "+eval.meanAbsoluteError());
		System.out.println("RMSE = "+eval.rootMeanSquaredError());
		System.out.println("RAE = "+eval.relativeAbsoluteError());
		System.out.println("RRSE = "+eval.rootRelativeSquaredError());
		System.out.println("Precision = "+eval.precision(1));
		System.out.println("Recall = "+eval.recall(1));
		System.out.println("fMeasure = "+eval.fMeasure(1));
		System.out.println("Error Rate = "+eval.errorRate());
		
		System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));
	
		System.out.println("Finish");
	}
	
}
