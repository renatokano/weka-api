package weka.api;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.instance.NonSparseToSparse;
import weka.filters.Filter;
import java.io.File;

public class InstanceFilter {
	public static void nonsparsetosparse(String input, String output) throws Exception {
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		DataSource source = new DataSource(input);
		Instances dataset = source.getDataSet();
		
		System.out.println("Step 2 - Applying the filter (SparseToNonSparse)");
		NonSparseToSparse sp = new NonSparseToSparse();
		sp.setInputFormat(dataset);
		Instances newData = Filter.useFilter(dataset, sp);
				
		System.out.println("Step 3 - Saving the file (ARFF Format)");
		ArffSaver saver = new ArffSaver();
		saver.setInstances(newData);
		saver.setFile(new File(output));
		saver.writeBatch();
		
		System.out.println("Finish");
		
	}
}
