package trng.io;

import java.io.Serializable;

class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5321850779539410189L;
	String streetNo;
	String streetName;

	public Address(String streetNo, String streetName) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", streetName=" + streetName + "]";
	}

}

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 106L;

	String eName;
	String empID;
	String addInfo;
	float basicSalary;
	Address address;
	String something;
	static String COMPANY_NAME;
	transient String ssnNo;

//	static {
//		COMPANY_NAME = "ABC Company";
//	}

	// Parametrized constructor

	Employee(String name, String Id, float salary, String ssnNo, Address address) {
		eName = name;
		empID = Id;
		basicSalary = salary;
		this.ssnNo = ssnNo;
		this.address = address;
	}

	public Employee(String eName, String empID, float basicSalary) {
		super();
		this.eName = eName;
		this.empID = empID;
		this.basicSalary = basicSalary;
	}

	Employee() {
	}

	// display method
	void display() {
		System.out.println("Employee name is" + eName);
		System.out.println("employee id is" + empID);
		System.out.println("employee basicsalary is " + basicSalary);
		System.out.println("employee ssnNo is " + ssnNo);
		System.out.println("employee address is " + address);
		System.out.println("Compnay name is: " + COMPANY_NAME);
	}

	public String geteName() {
		return eName;
	}

	public String getEmpID() {
		return empID;
	}

	public float getBasicSalary() {
		return basicSalary;
	}
	
	public void setCompanyName() {
		COMPANY_NAME = "ABC Company";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addInfo == null) ? 0 : addInfo.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + Float.floatToIntBits(basicSalary);
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + ((empID == null) ? 0 : empID.hashCode());
		result = prime * result + ((ssnNo == null) ? 0 : ssnNo.hashCode());
		return result;
	}

	public String getAddInfo() {
		return addInfo;
	}

	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
}