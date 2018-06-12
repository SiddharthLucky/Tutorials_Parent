package Customer_System;

public class Customer 
{
	private final int custID;
	private final String title;
	private final String firstName;
	private final String midName;
	private final String lastName;
	private final String custEmail;
	private final String custDisplay;
	private final String otherDetails;
	private final Address custAddress;
	private final Order[] orders;
	
	
	public Customer(int custID, String title, String firstName, String midName, String lastName, String custEmail,
			String custDisplay, String otherDetails, Address custAddress, Order[] orders) {
		super();
		this.custID = custID;
		this.title = title;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.custEmail = custEmail;
		this.custDisplay = custDisplay;
		this.otherDetails = otherDetails;
		this.custAddress = custAddress;
		this.orders = orders;
	}
	
	public int getCustID() {
		return custID;
	}
	public String getTitle() {
		return title;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMidName() {
		return midName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public String getCustDisplay() {
		return custDisplay;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public Address getCustAddress() {
		return custAddress;
	}
	public Order[] getOrders() {
		return orders;
	}
	
// For making some fields optional you can check the builder design patterns
// The builder class can be made static so that i can access it anywhere and if it is a method you cannot
	//access it untill the classes object is built.
}
