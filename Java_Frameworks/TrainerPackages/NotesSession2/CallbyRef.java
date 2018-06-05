package trng.basics;
public class CallbyRef {
	public static void main(String[] argsa) {
		//MyFirstName mfn = new MyFirstName();
		
		String[] args = {"ab", "xy", "pq", "mn"};
		CallbyRef cref = new CallbyRef();
		
		System.out.println(" Before update ");
		cref.displayArray(args);
		
		cref.replaceArrElement(args, "pq", "op");
		
		System.out.println("\n After update ");
		cref.displayArray(args);
    }
	
	private void displayArray(String[] arr) {
		for (String str : arr) {
			System.out.print(str + " ");
		}
	}
	
	private void  replaceArrElement(String[] array, String elementToReplace, String elementToReplaceWith) {
		for (int i=0; i<array.length; i++) {			
			if (elementToReplace.equals(array[i])) { 
				array[i] = elementToReplaceWith;
				break;
			}
		}
	}
}

