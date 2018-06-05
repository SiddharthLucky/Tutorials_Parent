package trng.basics;
import trng.inheritence.prsn.Student;

class StudentDisplayUtil {
	int id;
	static int MAX = 34;
	final static int HIGH_VALUE;
	
	static {
		HIGH_VALUE = 34343343;
	}
	
	public static void display(Student student) {
		System.out.println("Age is: " + student.getStudentId());
		System.out.println("Marks : " + student.getMarks());
	}

	public static void displyaId() {
		//System.out.println(id);
	}
	
	public void displyaMax() {
		System.out.println(MAX);
	}
}

public class StaticUsage {
	public static void main(String args[]) {
		Student student = StudentReaderUtil.readStudentInfo();
		StudentDisplayUtil.display(student); 
//		StudentReaderUtil.modifyAge(s2.getAge());
//		StudentDisplayUtil.display(s2);
		
		
//		System.out.println(StudentReaderUtil.add("abc", 2, 3 , 4, 5, 9));
	}
	
	
	
}
