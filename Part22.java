import java.util.Random;
import java.util.Scanner;

public class Part22 {
	
	public static void main(String[] args) {
		
		//Random and scanner
		//Needed for password generation and user input
		Random rn = new Random();
		Scanner reader = new Scanner(System.in);
		
		//Showing the user the generated password
		String pw = "";
		System.out.println("Hello There! This is a program to test a randomly assigned password.");
		System.out.println("Your randomly assigned password is: ");
		for (int i = 0; i < 8; i++) {
			int num = rn.nextInt(7) + 1;
			pw = pw.concat(Integer.toString(num));
		}
		//Showing the user the generated password
		System.out.println(pw);
		
		String input = "y";
		
		//Loop so user can keep testing password
		while (!input.equals("n") || input.equals("N")) {
			System.out.println("Ready to test? Y/N");
			input = reader.nextLine();
			
			//Test the user
			if (input.equals("Y") || input.equals("y")) {
				System.out.println("Please enter your password");
				input = reader.nextLine();		
				
				//Display results
				if (input.equals(pw)) {
					System.out.println("Correct!");
				}
				else {
					System.out.println("Incorrect!");
				}
				
				//Try again
				System.out.println("Try again? Y/N");
				input = reader.nextLine();
			}
		}
	}
}
