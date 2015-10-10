package weka.api;

import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ArffSaver;
import java.io.File;

public class Csv2Arff {
	public static void convert(String input, String output) throws Exception{
		System.out.println("Step 1 - Reading the input file (CSV Format)");
		CSVLoader loader = new CSVLoader();
		//loader.setSource(new File("/home/renatokano/Desktop/iris-weka-api.csv"));
		loader.setSource(new File(input));
		Instances data = loader.getDataSet();
		
		System.out.println("Step 2 - Saving the file (ARFF Format)");
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		//saver.setFile(new File("/home/renatokano/Desktop/iris-csv2arff-web-api.arff"));
		saver.setFile(new File(output));
		saver.writeBatch();
		
		System.out.println("Finish");
	}
}
