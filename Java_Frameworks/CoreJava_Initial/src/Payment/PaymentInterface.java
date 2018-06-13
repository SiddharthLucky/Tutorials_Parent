package Payment;

public interface PaymentInterface 
{
	public int sale(SaleRequest request);
	public int voidSale(VoidRequest request);
	public int authorization(AuthRequest request);
	public int priorAuthorizationSale(SaleRequest request);
	public int incrementAuthorization(IncrementAuthorizationRequest request);
}
