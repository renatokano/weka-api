package weka.api;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;
import java.io.File;

public class Arff2Csv {
	public static void convert (String input, String output) throws Exception {
		//System.out.println("Teste!");
		System.out.println("Step 1 - Reading the input file (ARFF Format)");
		ArffLoader loader = new ArffLoader();
		loader.setSource(new File(input));
		Instances data = loader.getDataSet();
		
		System.out.println("Step 2 - Saving the file (CSV Format)");
		CSVSaver saver = new CSVSaver();
		saver.setInstances(data);
		saver.setFile(new File(output));
		saver.writeBatch();
		
		System.out.println("Finish");
	}
}
