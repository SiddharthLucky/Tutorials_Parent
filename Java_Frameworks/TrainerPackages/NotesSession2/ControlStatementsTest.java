package trng.basics;
import java.util.Scanner;

public class ControlStatementsTest {
	
	public static void main(String[] args) {
		ControlStatementsTest controlStatementsTest = new ControlStatementsTest();
		controlStatementsTest.switchStatement2();
	}
	
	
	//Student score evaluation using if-else-if
	void controlStatementIfElseIf() {
		int score = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student marks (0-100): ");
		int marks = scanner.nextInt(); 
		
		System.out.println("Enter sports rank(1-10) : ");
		int sportsRank = scanner.nextInt(); 
		
		System.out.println("Enter behaviour (E/G/A/W) : ");
		char behaviour = scanner.next().charAt(0);
		
		if (marks < 35 || sportsRank < 4) {
			score = 15;
		} if (marks < 35 && sportsRank >= 4) {
			score = 20;
		} else if ((marks >= 35 && marks <= 50) && sportsRank < 4) {
			score = 45;
		} else if ((marks >= 35 && marks <= 50) && (sportsRank >= 4 && sportsRank < 8)) {
			score = 60;
		} else if ((marks >= 35 && marks <= 50) && sportsRank >= 8) {
			score = 80;
		} else if ((marks > 55 && marks <= 100) && sportsRank > 8) {
			score = 90;
		} else {
			System.out.println("Invalid data to evaluate the score");
			score = 0;
		}
		
		if (behaviour ==  'E') {
			score += 10;
		} else if (behaviour ==  'G') {
			score = score + 5;
		} else if (behaviour ==  'A') {
			score = score + 2;
		} else if (behaviour ==  'W') {
			score -= 2;
		}
		
		System.out.println("Score is: " + score);
	}
	
	//Student score evaluation using if-else-if
	void controlStatementIfElse() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student marks: ");
		int marks = scanner.nextInt(); 
		String result;
		
		if (marks > 35) {
			result = "pass";
		} else {
			result = "fail";
		}
		
		System.out.println("Student result: " + result);		
	}
	
	//Student score evaluation using if-else-if
	void controlStatementIf() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student marks: ");
		int marks = scanner.nextInt(); 
		String result = "fail";
		
		if (marks > 35) {
			result = "pass";
		}
		
		System.out.println("Student result: " + result);		
	}
	
	void controlStatementNestedIf() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student marks: ");
		int marks = scanner.nextInt(); 
		
		
		System.out.println("Enter student subject (Java/.Net/C/others): ");
		String selectedSubject = "Java";
		int cost;
		
		if (marks > 35) {
			if (selectedSubject.equals("Java")) {
				cost = 100;
			} else if (selectedSubject.equals(".Net")) {
				cost = 80;
			} else if (selectedSubject.equals("C")) {
				cost = 60;
			} else {
				cost = 50;
			}
		} else {
			cost = 200;
		}
		
		System.out.println("courese cost: " + cost);		
	}
	
	void switchStatement() {
		Scanner in = new Scanner(System.in);
        System.out.print("Enter month's number: ");
        int monthNumber;
        monthNumber = in.nextInt();
        switch (monthNumber) {
        case 1:
              System.out.println("January");
              break;
        case 2:
              System.out.println("February");
              break;
        case 3:
              System.out.println("March");
              break;
        case 4:
              System.out.println("April");
              break;
        case 5:
              System.out.println("May");
              break;
        case 6:
              System.out.println("June");
              break;
        case 7:
              System.out.println("July");
              break;
        case 8:
              System.out.println("August");
              break;
        case 9:
              System.out.println("September");
              break;
        case 10:
              System.out.println("October");
              break;
        case 11:
              System.out.println("November");
              break;
        case 12:
              System.out.println("December");
              break;
        default:
              System.out.println("Invalid month.");
              break;
        }
	}
	
	void switchStatement2() {
		 Scanner in = new Scanner(System.in);
         System.out.print("Enter month's number: ");
         int monthNumber;
         monthNumber = in.nextInt();
         switch (monthNumber) {
         //Default can be any where inside the switch. 
         default:
             System.out.println("Invalid month.");
             break;
         case 1:
         case 3:
         case 5:
         case 7:
         case 8:
         case 10:
         case 12:
               System.out.println("Number of days: 31");
               break;
         case 4:
         case 6:
         case 9:
         case 11:
               System.out.println("Number of days: 30");
               break;
         case 2:
               System.out.println("Number of days: 28");
               break;
         /*default:
               System.out.println("Invalid month.");
               break;*/

         }
	}
	
	void whileDemo() {
		int count = 0;
		
		while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
	}
	
	void doWhileDemo() {
		int count = 1;
		
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
	}
	
	
	void forLoopDemo() {
		for(int i=0 ;i<10; i++) {
			System.out.println(i);
		}
	}
	
	void enhanceForLoopDemo() {
		int[] numbers = {2, 6, 3, 8, 9, 4};
		for(int number : numbers) {
			System.out.println(number);
		}
	}
}
