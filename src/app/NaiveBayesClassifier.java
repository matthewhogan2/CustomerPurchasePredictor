package app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveBayesClassifier {
	
	//Training data counts yes and no from customers placed in hashmap frequncy table sepretly
	private Dataset dataset;
	private Map<String,Map<String, Integer>> yesCounts;
	private Map<String,Map<String, Integer>> noCounts;
	private int totalYes;
	private int totalNo;
	
	
	//constructor
	public NaiveBayesClassifier(Dataset dataset) {
		this.dataset= dataset;
		yesCounts= new HashMap<>();
		noCounts= new HashMap<>();
		totalYes=0;
		totalNo=0;//start count at 0
		
	}
	
	
	public void train() {
		List<Customer> customers= dataset.getCustomers();
		
		for(Customer customer: customers) {//goes through customer 1 by 1 and gets yes or no
			
			String label= customer.getMadePurchase();
			
			if(label.equalsIgnoreCase("yes")) {
				totalYes++;
				updateCounts(yesCounts, customer); 
			}
			else if(label.equalsIgnoreCase("no")) {
				totalNo++;
				updateCounts(noCounts, customer)	;
			}
			
		}//end for loop
	}
	
	
	
	//method
	// for the given customer above this updates value of the features and how often they occur
	private void updateCounts(Map<String, Map<String, Integer>> counts, Customer customer) {
		addCount(counts,"ageGroup", customer.getAgeGroup());
	    addCount(counts,"incomeLevel", customer.getIncomeLevel());
	    addCount(counts, "previousPurchases", customer.getPreviousPurchases());
	    addCount(counts,"promoInterest", customer.getPromoInterest());
	}
	
	//helper
	//check if features exits in counts if not adds new empty hashmap for that feature 
	private void addCount(Map<String, Map<String ,Integer>>counts, String feature, String value) {
		counts.putIfAbsent(feature, new HashMap<>());
	    Map<String, Integer> valueCounts = counts.get(feature);
	    valueCounts.put(value, valueCounts.getOrDefault(value, 0) + 1);
	    
	}
	
	
	//Method for prediction
	public String predict(Customer customer) {
	    double yesProbability = calculateProbability(yesCounts, customer, totalYes);
	    double noProbability = calculateProbability(noCounts, customer, totalNo);
	    return yesProbability > noProbability ? "yes" : "no";
	}
	
	//helper
	private double calculateProbability(Map<String, Map<String, Integer>> counts, Customer customer, int total) {
	    double probability= 1.0; //starts at 1 and multiply's
	    probability*= getFeatureProbability(counts, "ageGroup", customer.getAgeGroup(), total);
	    probability *= getFeatureProbability(counts, "incomeLevel", customer.getIncomeLevel(), total);
        probability *= getFeatureProbability(counts, "previousPurchases", customer.getPreviousPurchases(), total);
        probability *= getFeatureProbability(counts, "promoInterest", customer.getPromoInterest(), total);
	    probability *= ((double) total) /  (totalYes + totalNo);
	    
	    return probability;
	}
	
	
	private double getFeatureProbability(Map<String, Map<String, Integer>> counts, String feature, String value, int total) {
	    
		if (!counts.containsKey(feature)) {
	    	return 1.0 / total;
	    }
	    
	    Map<String, Integer> valueCounts = counts.get(feature);
	    int count =valueCounts.getOrDefault(value, 0);
	    return((double) count + 1)/ ((double) total + 2);//avioid 0 division
	}

	
	
	
	
	
}
