import java.util.Scanner;

public class Calculator {

	static Scanner enteredInt = new Scanner(System.in);
	// static int a,b;

	public static void main(String[] args) {
		int a = 0, b = 0;
		// calculator();
		// public static void calculator() {
		// a = enteredInt.nextInt();
		// b = enteredInt.nextInt();

		String k = option();
		do {
			switch (k) {
			case "A":
				System.out.println("You are going to calculate the sum of 2 numbers.");
				System.out.println("The sum of your entered numbers is: " + addition());
				return;
			case "S":
				System.out.println("You are going to calculate the difference of 2 numbers.");
				System.out.println("The difference of your entered numbers is: " + substitution(a, b));
				return;
			case "M":
				System.out.println("You are going to calculate the multiplication of 2 numbers.");
				System.out.println("The multiplication of your entered numbers is: " + multiplication(a, b));
				return;
			case "D":
				System.out.println("You are going to calculate the division of 2 numbers.");
				System.out.println("The division of your entered numbers is: " + division(a, b));
				return;
			default:
				System.out.println("Your entered option does not exist. Please, try again later.");
//				k = option();
				// calculator();
				break;
			}
			k = option();
		} while (!k.equals("Q"));
		System.out.println("You quited from the program");
	}

	public static int addition() {
		System.out.println("Enter the first integer:");
		int a = enteredInt.nextInt();
		System.out.println("Enter the second integer:");
		int b = enteredInt.nextInt();
		return a + b;
	}

	public static int substitution(int a, int b) {
		System.out.println("Enter the first integer:");
		a = enteredInt.nextInt();
		System.out.println("Enter the second integer:");
		b = enteredInt.nextInt();
		return a - b;
	}

	public static int multiplication(int a, int b) {
		System.out.println("Enter the first integer:");
		a = enteredInt.nextInt();
		System.out.println("Enter the second integer:");
		b = enteredInt.nextInt();
		return a * b;
	}

	public static float division(float a, float b) {
		System.out.println("Enter the first integer:");
		a = enteredInt.nextInt();
		System.out.println("Enter the second integer:");
		b = enteredInt.nextInt();
		return a / b;
	}

	public static String option() {
		System.out.println(
				"Type the first letter of the following options to proceed: Addition, Substitution, Multiplication, Division. Type Q for quit.");
		// String entered = "";
		String option = enteredInt.next();
		return option;

		// if (!option.equals("A") /*|| option == "S" || option == "M" || option ==
		// "D"*/) {
		// entered = option;
		// return option;
		// System.out.println("You entered invalid option.");
		// option();
		// }
		// else
		// {
		// entered = option;
		// System.out.println("entered = " + entered);
		// System.out.println("option = " + option);
		// return entered;
		//
		// }
		// System.out.println("enterd2 = " + entered);
		// return "";
	}
	// public static String returnedLetter (String a) {
	// option();
	// while (!option().equals("A")) {
	// System.out.println("You entered invalid option.");
	// option();
	// }
	// a = option();
	// return a;
	// }

}