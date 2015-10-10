package weka.api;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import java.io.File;

public class AttributeFilter {
	
	public static void remove(String input, String output, String colIndex) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		
		System.out.println("Step 2 - Applying the filter (Remove)");
		String[] options = new String[]{"-R",colIndex};
		Remove remove = new Remove();
		remove.setOptions(options);
		remove.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, remove);
		
		System.out.println("Step 3 - Saving the file (ARFF Format)");
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File(output));
		saver.writeBatch();
		
		System.out.println("Finish");
	}
	
	public static void discretize(String input, String output, String bins, String range) throws Exception{
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		
		System.out.println("Step 2 - Applying the filter (Discretize)");
		String[] options = new String[5];
		options[0] = "-B";
		options[1] = bins;
		options[2] = "-R";
		options[3] = range;
		options[4] = "";			
		Discretize discretize = new Discretize();
		discretize.setOptions(options);
		discretize.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, discretize);
		
		System.out.println("Step 3 - Saving the file (ARFF Format)");
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File(output));
		saver.writeBatch();
		
		System.out.println("Finish");
	}
	
	public static void attrselection(String input, String output) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		
		System.out.println("Step 2 - Applying the filter (AttributeSelection)");
		AttributeSelection attsel = new AttributeSelection();
		GreedyStepwise search = new GreedyStepwise();
		search.setSearchBackwards(true);
		CfsSubsetEval eval = new CfsSubsetEval();
		attsel.setEvaluator(eval);
		attsel.setSearch(search);
		attsel.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, attsel);
		
		System.out.println("Step 3 - Saving the file (ARFF Format)");
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File(output));
		saver.writeBatch();
		
		System.out.println("Finish");
	}
}
