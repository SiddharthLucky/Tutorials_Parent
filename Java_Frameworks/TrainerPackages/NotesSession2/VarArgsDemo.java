package trng.basics;

public class VarArgsDemo {

	public static void main(String[] args) {
		int sum = calculateSum(3, 4, 5, 23, 9, 2);
		System.out.println("sum is:" + sum);

		int sum2 = calculateSum(3, 4, 5);
		System.out.println("sum2 is:" + sum2);
		
		float sum3 = calculateSum(2.5f, 3.0f, 3, 4, 5, 23, 9, 2);
		System.out.println("sum3 is:" + sum3);
	}

	private static int calculateSum(int...nums) {
		int sum = 0;
		for(int num: nums) {
			sum += num;
		}
		return sum;
	}
	
	private static float calculateSum(float f1, float f2, int...nums) {
		float sum = 0;
		sum += f1;
		sum += f2;
		for(int num: nums) {
			sum += num;
		}
		return sum;
	}
	
	//can't
	/*private static float calculateSum(float... fvalues, int...nums) {
		
	}*/

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
