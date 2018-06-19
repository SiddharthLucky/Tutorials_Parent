package Customer_Serialize;

import java.io.IOException;

public class SerializeMain 
{
	public static void main(String[] args)
	{
		Address address = new Address("Sid", "1234", "1432", "1234", "1432", "1234", "1432", "1234", "1432", "1234", "1432", "1234");
		Customer customer = new Customer(1, "sid", "sid", "sid", "sid", "sid", "sid", "sid");
		
		try
		{
			Customer_Serialization.serializeCustomer(customer);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try {
			Customer tempHolder;
			tempHolder = (Customer)Customer_Serialization.deserializeCustomer();
		}
		catch(ClassNotFoundException|IOException e)
		{
			e.printStackTrace();
		}
	}
}
