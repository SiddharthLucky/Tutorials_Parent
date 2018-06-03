package Employee_Initial;

public class Employee 
{
	private int ein;
	private String eName;
	private int eSalary;
	private int eAge;
	private static String eCompany;
	
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
		if(geteAge() > 0 && geteAge() <= 120)
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
	
	public int HRA()
	{
		int Hra, eSalary;
		eSalary = geteSalary();
		Hra = ((eSalary * 20) / 100);
		return Hra;
	}
	
	@Override
	public String toString() {
		return "Employee [ein=" + ein + ", eName=" + eName + ", eSalary=" + eSalary + ", eAge=" + eAge + ", Company Name=" + geteCompany() +"]";
	}
	
}
