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
	//private final Address custAddress;
	
	public Customer(int custID, String title, String firstName, String midName, String lastName, String custEmail,
			String custDisplay, String otherDetails)
	{//, Address custAddress) {
	
		this.custID = custID;
		this.title = title;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.custEmail = custEmail;
		this.custDisplay = custDisplay;
		this.otherDetails = otherDetails;
		//this.custAddress = custAddress;
	}

	public String getTitle() 
	{
		return title;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getMidName() 
	{
		return midName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public String getCustEmail() 
	{
		return custEmail;
	}

	public String getCustDisplay() 
	{
		return custDisplay;
	}

	public String getOtherDetails() 
	{
		return otherDetails;
	}

	public int getCustID() 
	{
		return custID;
	}

	/*public Address getCustAddress() 
	{
		return custAddress;
	}*/
}
