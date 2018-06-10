package Customer_System;

import java.sql.Date;

public class Order 
{
	private int orderID;
	private int customerIDHodler;
	private Date invoiceCreationDate;
	private Date deliveryDueDate;
	private Date paymentDueDate;
	private String otherMessage;
	private OrderProducts[] ordProd;
	
	
	public int getCustomerIDHodler() {
		return customerIDHodler;
	}


	public void setCustomerIDHodler(int customerIDHodler) {
		this.customerIDHodler = customerIDHodler;
	}


	public Date getInvoiceCreationDate() {
		return invoiceCreationDate;
	}


	public void setInvoiceCreationDate(Date invoiceCreationDate) {
		this.invoiceCreationDate = invoiceCreationDate;
	}


	public Date getDeliveryDueDate() {
		return deliveryDueDate;
	}


	public void setDeliveryDueDate(Date deliveryDueDate) {
		this.deliveryDueDate = deliveryDueDate;
	}


	public Date getPaymentDueDate() {
		return paymentDueDate;
	}


	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}


	public String getOtherMessage() {
		return otherMessage;
	}


	public void setOtherMessage(String otherMessage) {
		this.otherMessage = otherMessage;
	}


	public int getOrderID() {
		return orderID;
	}
	
}
