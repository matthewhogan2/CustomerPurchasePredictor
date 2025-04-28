package app;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // Create some sample customers manually
        Customer c1 = new Customer("young", "high", "none", "yes", "yes");
        Customer c2 = new Customer("old", "low", "many", "no", "no");
        Customer c3 = new Customer("young", "low", "none", "yes", "yes");
        Customer c4 = new Customer("old", "high", "many", "no", "no");

        // Create a data set and add customers
        Dataset dataset = new Dataset();
        dataset.addCustomer(c1);
        dataset.addCustomer(c2);
        dataset.addCustomer(c3);
        dataset.addCustomer(c4);
        
        Dataset ds = new Dataset();
        // Create the classifier and train it
        NaiveBayesClassifier classifier = new NaiveBayesClassifier(dataset);
        classifier.train();

        // Create a new customer we want to predict
        Customer newCustomer = new Customer("young", "high", "none", "yes", ""); // empty label because we want to predict

        // Predict
        String prediction = classifier.predict(newCustomer);

        // Show result
        System.out.println("Prediction for new customer: " + prediction);
        
        new PredictorGUI(ds);
    }
}
