package Payment;

import java.util.Scanner;

public class PaymentApp {

	public static void main(String[] args) 
	{
		PaymentInterfaceImpl paymentimpl = new PaymentInterfaceImpl();
		SaleRequest val1 = null;
		VoidRequest val2 = null;
		AuthRequest val3 = null;
		IncrementAuthorizationRequest val4 = null;
		
		int finalval = 0;
		while (true) 
		{
			System.out.println("Enter your choice: ");
			Scanner uinput = new Scanner(System.in);
			int userval = uinput.nextInt();
			switch(userval)
			{
				case 1: finalval = paymentimpl.sale(val1);
						System.out.println("Sale Selected.");
						break;
				case 2: finalval = paymentimpl.voidSale(val2);
						System.out.println("Sale Voided.");
						break;
				case 3: finalval = paymentimpl.authorization(val3);
						System.out.println("Authorization granted.");
						break;
				case 4: finalval = paymentimpl.priorAuthorizationSale(val1);
						System.out.println("Prior Auth triggered.");
						break;
				case 5: finalval = paymentimpl.incrementAuthorization(val4);
						System.out.println("Increased authorization.");
						break;
				default: System.out.println("Enter another value.");		
			}
		}
	}

}
