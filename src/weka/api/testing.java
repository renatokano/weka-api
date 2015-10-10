package weka.api;

public class testing {
	public static void main(String[] args) throws Exception {
		System.out.println("[START]");
		System.out.println("Test 1 ...");
		System.out.println("CSV2ARFF Class : Convert Method");
		Csv2Arff.convert("/home/renatokano/Desktop/iris-weka-api.csv", "/home/renatokano/Desktop/output.arff");
		System.out.println(".........................................");
		
		System.out.println("Test 2 ...");
		System.out.println("ARFF2CSV Class : Convert Method");
		Arff2Csv.convert("/home/renatokano/Downloads/zoo.arff","/home/renatokano/Desktop/output2.csv");		
		System.out.println(".........................................");
		
		System.out.println("Test 3 ...");
		System.out.println("AttributeFilter Class : Remove Method");
		AttributeFilter.remove("/home/renatokano/Desktop/iris-csv2arff-web-api.arff","/home/renatokano/Desktop/output3.arff","2");		
		System.out.println(".........................................");
		
		System.out.println("Test 4 ...");
		System.out.println("AttributeFilter Class : Discretize Method");
		AttributeFilter.discretize("/home/renatokano/Desktop/pendigits.arff","/home/renatokano/Desktop/output4.arff","2","1-3");				
		System.out.println(".........................................");
		
		System.out.println("Test 5 ...");
		System.out.println("InstanceFilter Class : NonSparseToSparse Method");
		InstanceFilter.nonsparsetosparse("/home/renatokano/Desktop/tic-tac-toe-b.arff","/home/renatokano/Desktop/output5.arff");				
		System.out.println(".........................................");
		
		System.out.println("Test 6 ...");
		System.out.println("AttributeFilter Class : AttrSelection Method");
		AttributeFilter.attrselection("/home/renatokano/Desktop/soybean.arff","/home/renatokano/Desktop/output6.arff");				
		System.out.println(".........................................");
		
		System.out.println("Test 7 ...");
		System.out.println("Classification Class : NaiveBayes Method");
		Classification.naivebayes("/home/renatokano/Desktop/iris-weka-api.arff");				
		System.out.println(".........................................");
		
		System.out.println("Test 8 ...");
		System.out.println("Classification Class : J48 Method");
		Classification.j48("/home/renatokano/Desktop/iris-weka-api.arff");				
		System.out.println(".........................................");
		
		System.out.println("Test 9 ...");
		System.out.println("Classification Class : SMO Method");
		Classification.smo("/home/renatokano/Desktop/iris-weka-api.arff");				
		System.out.println(".........................................");
		
		System.out.println("Test 10 ...");
		System.out.println("Regression Class : LinearRegression Method");
		Regression.linearRegression("/home/renatokano/Desktop/machine.cpu.arff");				
		System.out.println(".........................................");
		
		System.out.println("Test 11 ...");
		System.out.println("Regression Class : SMOreg Method");
		Regression.smoReg("/home/renatokano/Desktop/machine.cpu.arff");				
		System.out.println(".........................................");
		
		System.out.println("Test 12 ...");
		System.out.println("Evaluate Class : ETAN Method");
		//Evaluate.etan("/home/renatokano/tic-tac-toe/tic-tac-toe-0/tic-tac-toe.dataset.1.data-NumericToNominal-Rfirst-last.arff","/home/renatokano/tic-tac-toe/tic-tac-toe-0/tic-tac-toe.dataset.1.test-NumericToNominal-Rfirst-last.arff");				
		Evaluate.etan("/home/renatokano/Downloads/iris.arff","/home/renatokano/Downloads/iris.arff", true, 10);
		System.out.println(".........................................");
		
		System.out.println("Test 13 ...");
		System.out.println("Evaluate Class : SVM Method");
		//Evaluate.libsvm("/home/renatokano/tic-tac-toe/tic-tac-toe-0/tic-tac-toe.dataset.1.data-NumericToNominal-Rfirst-last.arff","/home/renatokano/tic-tac-toe/tic-tac-toe-0/tic-tac-toe.dataset.1.test-NumericToNominal-Rfirst-last.arff", false,10);				
		Evaluate.libsvm("/home/renatokano/Downloads/iris.arff","/home/renatokano/Downloads/iris.arff", true, 10);
		System.out.println(".........................................");
		
		System.out.println("[FINISH]");
	}
}
