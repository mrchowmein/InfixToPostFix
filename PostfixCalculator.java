import java.util.Scanner;

public class PostfixCalculator{
	

	public static void main (String [] args){

		Scanner sc = new Scanner(System.in);
		boolean state = true;

		System.out.println("\nWelcome to Jason's Infix to Postfix Calculator!");

		while(state == true){

			System.out.print("\nPlease enter an infix expression: ");
			String input = sc.nextLine();
			String postfix = Converter.toPostFix(input);
			System.out.println("Postfix: " + postfix);
			System.out.println("Answer: " + Calculator.evaluatePostFix(postfix));
			
			menu();
		}
	
	}


	public static void menu(){
		
		boolean state = true;
		Scanner sc = new Scanner(System.in);

		while(state){

			System.out.println("\nWhat would you like to do next?: \n");
			System.out.println("1: Try another expression");
			System.out.println("2: Exit");
			System.out.print("Input: ");
			String input = sc.nextLine();
			
			if (input.equals("1")){
				state = false;
			} else if ( input.equals("2")){
				System.exit(0);
			} else {
				System.out.println("Error: Invalid input");
			}

		}
		

	}
}