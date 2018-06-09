package Customer_System;

public class Utilities 
{
	// this file is common for all
	Customer customer;
	
	public static Customer getCustomerInfo(Customer customer)
	{
		customer = new Customer(1, "a", "a", "a", "a", "a",
				"a", "a");//, Address custAddress);
		
		return customer;
	}
	
}
