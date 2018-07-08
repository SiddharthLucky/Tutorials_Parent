import java.io.File;
import java.jaxb.Customer.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MarshallerMainEx 
{
	public static void main(String[] args)
	{
		try 
		{    
            File file = new File("employee.xml");    
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);    
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
            Customer c=(Customer) jaxbUnmarshaller.unmarshal(file);    
            System.out.println(c.getName()+" "+c.getDOB()+" "+c.getPaymentType());          
          }
		catch (JAXBException e) {e.printStackTrace(); }
	}
}
