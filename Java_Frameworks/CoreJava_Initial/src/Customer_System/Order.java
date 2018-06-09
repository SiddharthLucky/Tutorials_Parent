package Customer_System;

import java.sql.Date;

public class Order 
{
	private final int orderID;
	private int customerIDHodler;
	private Date invoiceCreationDate;
	private Date deliveryDueDate;
	private Date paymentDueDate;
	private String otherMessage;
	
	
	
	public Order(int orderid)
	{
		this.orderID = orderid;
	}
	
}
