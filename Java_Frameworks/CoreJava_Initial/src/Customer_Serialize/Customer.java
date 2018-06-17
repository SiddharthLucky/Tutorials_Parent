package Customer_Serialize;

import java.io.Serializable;

import Customer_System.Address;
import Customer_System.Order;

public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int custID;
	private String title;
	private String firstName;
	private String midName;
	private String lastName;
	private String custEmail;
	private String custDisplay;
	private String otherDetails;
	//private final Address custAddress;
	
	
	public Customer(int custID, String title, String firstName, String midName, String lastName, String custEmail,
			String custDisplay, String otherDetails) {
		super();
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
	/*public Address getCustAddress() {
		return custAddress;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custDisplay == null) ? 0 : custDisplay.hashCode());
		result = prime * result + ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + custID;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((midName == null) ? 0 : midName.hashCode());
		result = prime * result + ((otherDetails == null) ? 0 : otherDetails.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (custDisplay == null) {
			if (other.custDisplay != null)
				return false;
		} else if (!custDisplay.equals(other.custDisplay))
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custID != other.custID)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (midName == null) {
			if (other.midName != null)
				return false;
		} else if (!midName.equals(other.midName))
			return false;
		if (otherDetails == null) {
			if (other.otherDetails != null)
				return false;
		} else if (!otherDetails.equals(other.otherDetails))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
