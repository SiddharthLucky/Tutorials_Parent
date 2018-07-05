package Employee_Initial.CommonFiles;

import Employee_Initial.Arrays.EmployeeBaseType;

public class Employee extends EmployeeBaseType
{
	private int ein;
	private String eName;
	private int eSalary; // When you do not need multiple allocations use static and final. Memory purposes
	private int eAge;
	private static String eCompany;
	private int dno;

    public enum Department
	{
		SALES(10),
		PURCHASE(20),
		ADMINISTRATION(30),
		RESEARCH(40);
		
		private int did;
		
		Department(int dno)
		{
			this.did=dno;
		}
	}


	public int getEin() 
	{
		return ein;
	}
	public void setEin(int ein) 
	{
		this.ein = ein;
	}
	public String geteName() 
	{
		return eName;
	}
	public void seteName(String eName) 
	{
		this.eName = eName;
	}
	
	public int geteAge() 
	{
		return eAge;
	}
	public void seteAge(int eAge) 
	{
		if(geteAge() >= 0 && geteAge() <= 120)
		this.eAge = eAge;
	}
	
	public static String geteCompany() 
	{
		return eCompany;
	}
	public static void seteCompany(String eCompany) 
	{
		Employee.eCompany = eCompany;
	}
	
	public static void initCompanyName()
	{
		eCompany = "XYZCompany";
	}
	
	public int geteSalary() 
	{
		return eSalary;
	}
	
	public void seteSalary(int eSalary) 
	{
		if(eSalary>=0)
		{
			this.eSalary = eSalary;
		}
	}
	
	public void seteInitSalary() 
	{
		if(geteSalary()>=0)
		{
			this.eSalary = 10000;
		}
	}

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }
	
	public float HRA() // Functions names are not supposed to be in Capital names
	{
		float Hra; 
		int eSalary;
		eSalary = geteSalary();
		Hra = ((eSalary * 20) / 100);
		return Hra;
	}
	
	public float HRA(float perc) // Functions names are not supposed to be in Capital names
	{
		float Hra; 
		int eSalary;
		eSalary = geteSalary();
		Hra = ((eSalary * perc) / 100);
		return Hra;
	}
	
	public float DA(float perc)
	{
		int eSalary;
		float Da;
		eSalary = geteSalary();
		Da = ((eSalary * perc) / 100);
		return Da;
	}


	
	@Override
	public String toString() {
		return "Employee [ein=" + ein + ", eName=" + eName + ", eSalary=" + eSalary + ", eAge=" + eAge + ", Company Name=" + geteCompany() +"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eAge;
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + eSalary;
		result = prime * result + ein;
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
		Employee other = (Employee) obj;
		if (eAge != other.eAge)
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (eSalary != other.eSalary)
			return false;
		if (ein != other.ein)
			return false;
		return true;
	}
}
