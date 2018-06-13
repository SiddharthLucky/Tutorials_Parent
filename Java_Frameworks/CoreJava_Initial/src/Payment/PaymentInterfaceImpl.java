package Payment;

public class PaymentInterfaceImpl implements PaymentInterface
{
	private int value;
	@Override
	public int sale(SaleRequest request) {
		value = 1;
		return value;
	}

	@Override
	public int voidSale(VoidRequest request) {
		// TODO Auto-generated method stub
		value = 2;
		return value;
	}

	@Override
	public int authorization(AuthRequest request) {
		// TODO Auto-generated method stub
		value = 3;
		return value;
	}

	@Override
	public int priorAuthorizationSale(SaleRequest request) {
		// TODO Auto-generated method stub
		value = 4;
		return value;
	}

	@Override
	public int incrementAuthorization(IncrementAuthorizationRequest request) {
		// TODO Auto-generated method stub
		value = 5;
		return value;
	}
	
}
