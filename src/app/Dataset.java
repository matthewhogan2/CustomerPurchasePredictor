package app;

import java.util.ArrayList;
import java.util.List;


public class Dataset {
	
	private List<Customer> customers;
	
	public Dataset() {
		customers = new ArrayList<>();
		
	}
	
	public void addCustomer(Customer customer) {
			customers.add(customer);
			
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
}
