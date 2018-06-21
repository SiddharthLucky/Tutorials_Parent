package Customer_Serialize;

import Employee_Initial.CommonFiles.EmployeeUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Customer_Serialization {
	
	public static void serializeCustomer(Customer cust) throws IOException {
		
		File file = initfileFromUser();
		
		if(file.exists())
		{
			FileOutputStream fos = new FileOutputStream(file);

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(cust);
			
			oos.flush();
			fos.flush();
			fos.close();
			oos.close();
		}
		
	}
	
	public static Customer deserializeCustomer() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(initfileFromUser());

		ObjectInputStream ois = new ObjectInputStream(fis);

		Customer cust = (Customer) ois.readObject();

		fis.close();
		ois.close();

		return cust;
	}
	
	private static File initfileFromUser()
	{
		String filePath = "C:\\Users\\siddh\\Desktop\\IMCS_Parent\\Java_Frameworks\\CoreJava_Initial\\src\\Customer_Serialize\\CustomerInfo.dat";
		File file = new File(filePath);
        EmployeeUtil.createFile(file);
        return file;
	}
}
