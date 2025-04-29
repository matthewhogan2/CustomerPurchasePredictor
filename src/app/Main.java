package app;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	Dataset dataset = new Dataset();
    	
    	//level 2 load data set 
        dataset.loadFromCSV("data/customerData.csv");

        System.out.println("loaded customers: "+ dataset.getCustomers().size());
        
        //build the classifier and train it
        NaiveBayesClassifier classifier = new NaiveBayesClassifier(dataset);
        classifier.train();//dynamic training based on full data set
        
        //level 4 splitting the data
        List<Customer>allCustomers=dataset.getCustomers();
        int total=allCustomers.size();
        
        //new dataset
        if(total>=200) {
        	 List<Customer>trainingData=allCustomers.subList(0, 150);
        	 List<Customer>testingData=allCustomers.subList(150, 200);
        	 
        	 Dataset trainingSet = new Dataset();
        	 
        	 for (Customer c: trainingData) {
        		  trainingSet.addCustomer(c);
        		 
        	 }
        	 
        	 NaiveBayesClassifier testClassifier = new NaiveBayesClassifier(trainingSet);
        	 testClassifier.train();
        	 
        	 int correct = 0;
        	 for (Customer test: testingData) {
        		 String actual=test.getMadePurchase(); //real answer from data set
        		 String predicted=testClassifier.predict(test);// model guess

        		 if (actual.equalsIgnoreCase(predicted)) {
        			 correct++;//model gets it right count it
        	        }
        	    }
        	 
        	 //separate into yes/no lists
        	 //then shuffle
        	 
        	 
        	 double accuracy=(double)correct /testingData.size();
        	 System.out.println("Accuracy on 50 test cases: "+accuracy);
        	 
        }
        else{
            System.out.println("Not enough data need 200 rows");
        }
        

        new PredictorGUI(dataset);
        
    	
    }
}
