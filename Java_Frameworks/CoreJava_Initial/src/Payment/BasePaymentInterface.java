package Payment;

public abstract class BasePaymentInterface implements PaymentInterface 
{
	public int sale(SaleRequest request)
	{
		int value = 0;
		return value;
	}
	public int authorization(AuthRequest request)
	{
		int value = 1;
		return value;
	}

}
