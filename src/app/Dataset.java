package app;

import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Dataset {
	
    private List<Customer> customers;

    public Dataset() {
        customers= new ArrayList<> ();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    
    public void loadFromCSV(String filename) {
        try (BufferedReader br= new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;

            while((line=br.readLine())!=null){ 
                if (firstLine){
                    firstLine=false;
                    continue;
                }
                String[] parts=line.split(",");
                
                if (parts.length==5) {
                    Customer c = new Customer(
                        parts[0].trim(), // ageGroup
                        parts[1].trim(),// incomeLevel
                        parts[2].trim(),// previousPurchases
                        parts[3].trim(),// promoInterest
                        parts[4].trim()// madePurchase
                    );
                    
                    customers.add(c);
                }
                
            }
        } 
   
        catch (IOException e) {
            System.out.println("Error loading CSV: " + e.getMessage());
            
        }
    }
    
    
}
