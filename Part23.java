import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Part23 {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		//Random and scanner
		//Needed for password generation and user input
		Random rn = new Random();
		Scanner reader = new Scanner(System.in);
		//Writer
		//Output to Logdata.csv
		FileWriter fw = new FileWriter("Logdata.csv");
		fw.write("User, Scheme, Time, Login, Count, SuccessCount, FailCount, \n");
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//Showing the user the generated password
		String cdate;
		//Password for each of the three possible passwords
		String pwEmail = "";
		String pwBank = "";
		String pwShopping = "";
		int loop = 1;
		
		//Get user's id
		System.out.println("Hello There! This is a program to test a randomly assigned password.");
		System.out.println("Please Enter a Username:");
		String name = reader.nextLine();
		
		//Tell the user their three passwords
		System.out.println("Your randomly assigned password for E-mail is: ");
		for (int i = 0; i < 8; i++) {
			int num = rn.nextInt(7) + 1;
			pwEmail = pwEmail.concat(Integer.toString(num));
		}
		//Showing the user the generated password
		System.out.println(pwEmail);
		cdate = timeStamp;
		//Test their password until they can get it successfully
		while (loop == 1) {
			System.out.println("Please enter your randomly assigned password for E-mail: ");
			String input = reader.nextLine();
			if (input.equals(pwEmail)) {
				System.out.println("Well done!");
				loop = 0;
			}
		}
		loop = 1;
		//Tell the user their three passwords
		String timeStamp2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println("Your randomly assigned password for Banking is: ");
		for (int i = 0; i < 8; i++) {
			int num = rn.nextInt(7) + 1;
			pwBank = pwBank.concat(Integer.toString(num));
		}
		//Showing the user the generated password
		System.out.println(pwBank);
		cdate = timeStamp2;
		//Test their password until they can get it successfully
		while (loop == 1) {
			System.out.println("Please enter your randomly assigned password for Banking: ");
			String input = reader.nextLine();
			if (input.equals(pwBank)) {
				System.out.println("Well done!");
				loop = 0;
			}
		}
		loop = 1;
		
		
		String timeStamp3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//Tell the user their three passwords
		System.out.println("Your randomly assigned password for Shopping is: ");
		for (int i = 0; i < 8; i++) {
			int num = rn.nextInt(7) + 1;
			pwShopping = pwShopping.concat(Integer.toString(num));
		}
		
		//Showing the user the generated password
		System.out.println(pwShopping);
		cdate = timeStamp3;
		//Test their password until they can get it successfully
		while (loop == 1) {
			System.out.println("Please enter your randomly assigned password for Shopping: ");
			String input = reader.nextLine();
			if (input.equals(pwShopping)) {
				System.out.println("Well done!");
				loop = 0;
			}
		}
		loop = 1;
		
		String input2 = "y";
		int numLogins = 0;
		int numLoginsS = 0;
		int numLoginsF = 0;
		System.out.println("Ready to test? Y/N");
		input2 = reader.nextLine();
		String input3 = "";
		int loop2 = 1;
		int testRandom = rn.nextInt(3) + 1;
		int incorrectCounter = 0;
		String timeStamp4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			switch (testRandom) {
			//Testing Email password
				case 1:
					while (loop2 == 1) {
						if (incorrectCounter == 3) {
							System.out.println("3 Incorrect Passwords!");
							System.exit(0);
							}
						//Test the user
						if (input2.equals("Y") || input2.equals("y")) {
							System.out.println("Please enter your E-mail password");
							input3 = reader.nextLine();		
							//fw.write(timeStamp4 + ",enter,start \n");
							
							//Display results
							if (input3.equals(pwEmail)) {
								System.out.println("Correct!");
								loop2 = 0;
								numLogins++;
								numLoginsS++;
								SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
								String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
								String d = date.split(" ")[1];
								String c = cdate.split(" ")[1];
			        			Date date1 = format.parse(c);
			        			Date date2 = format.parse(d);
			        			long difference = date2.getTime() - date1.getTime(); 
			        			difference = difference/1000;
			        			
			        			fw.write(name + ",P2," + String.valueOf(difference) + ",1,"+  numLogins + ","+ numLoginsS + "," + numLoginsF + "\n");
							}
							else {
								System.out.println("Incorrect!");
								incorrectCounter++;
								numLogins++;
								numLoginsF++;
								SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
								String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
								String d = date.split(" ")[1];
								String c = cdate.split(" ")[1];
			        			Date date1 = format.parse(c);
			        			Date date2 = format.parse(d);
			        			long difference = date2.getTime() - date1.getTime(); 
			        			difference = difference/1000;
			        			fw.write(name + ",P2," + String.valueOf(difference) + ",0,"+  + numLogins + ","+ numLoginsS + "," + numLoginsF + "\n");
							}
						}
					}
					//Testing Banking password
				case 2:
					while (loop2 == 1) {
						if (incorrectCounter == 3) {
							System.out.println("3 Incorrect Passwords!");
							System.exit(0);
						}
						//Test the user
						if (input2.equals("Y") || input2.equals("y")) {
							System.out.println("Please enter your Banking password");
							input3 = reader.nextLine();		
							//fw.write(timeStamp + ",enter, start \n");
							//Display results
							if (input3.equals(pwBank)) {
								System.out.println("Correct!");
								loop2 = 0;
								numLogins++;
								numLoginsS++;
								SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
								String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
								String d = date.split(" ")[1];
								String c = cdate.split(" ")[1];
			        			Date date1 = format.parse(c);
			        			Date date2 = format.parse(d);
			        			long difference = date2.getTime() - date1.getTime(); 
			        			difference = difference/1000;
			        			
								fw.write(name + ",P2," + String.valueOf(difference) + ",1,"+  numLogins + ","+ numLoginsS + "," + numLoginsF + "\n");
							}
							else {
								System.out.println("Incorrect!");
								incorrectCounter++;
								numLogins++;
								numLoginsF++;
								SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
								String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
								String d = date.split(" ")[1];
								String c = cdate.split(" ")[1];
			        			Date date1 = format.parse(c);
			        			Date date2 = format.parse(d);
			        			long difference = date2.getTime() - date1.getTime(); 
			        			difference = difference/1000;
								fw.write(name + ",P2," + String.valueOf(difference) + ",0,"+  + numLogins + ","+ numLoginsS + "," + numLoginsF + "\n");
							}
						}
					}
					//Testing Shopping Password
				case 3:
					while (loop2 == 1) {
						if (incorrectCounter == 3) {
							System.out.println("3 Incorrect Passwords!");
							System.exit(0);
						}
						//Test the user
						if (input2.equals("Y") || input2.equals("y")) {
							System.out.println("Please enter your Shopping password");
							input3 = reader.nextLine();		
							//fw.write(timeStamp4 + ",enter,start \n");
							
							//Display results
							if (input3.equals(pwShopping)) {
								System.out.println("Correct!");
								loop2 = 0;
								numLogins++;
								numLoginsS++;
								SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
								String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
								String d = date.split(" ")[1];
								String c = cdate.split(" ")[1];
			        			Date date1 = format.parse(c);
			        			Date date2 = format.parse(d);
			        			long difference = date2.getTime() - date1.getTime(); 
			        			difference = difference/1000;
			        			
			        			fw.write(name + ",P2," + String.valueOf(difference) + ",1,"+  numLogins + ","+ numLoginsS + "," + numLoginsF + "\n");
							}
							else {
								System.out.println("Incorrect!");
								incorrectCounter++;
								numLogins++;
								numLoginsF++;
								SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
								String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
								String d = date.split(" ")[1];
								String c = cdate.split(" ")[1];
			        			Date date1 = format.parse(c);
			        			Date date2 = format.parse(d);
			        			long difference = date2.getTime() - date1.getTime(); 
			        			difference = difference/1000;
			        			fw.write(name + ",P2," + String.valueOf(difference) + ",0,"+  + numLogins + ","+ numLoginsS + "," + numLoginsF + "\n");
							}
							}
						}
						
				}
				fw.close();
		}
	
}
