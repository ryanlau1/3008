import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Part12 {	
	
	
	
	public static void main(String[] args) throws ParseException, IOException {
		
		StringBuilder fileStringB = new StringBuilder();
		
		String fileString;
		
		String outString = "";
		Scanner scanner = null;
		
		//Open the appropriate file
		//NOTE: may have to change the file destination
		try {
			scanner = new Scanner(new File("D:\\Desktop\\Imagept21.csv"));
			//scanner = new Scanner(new File("D:\\Desktop\\Text21.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
        	fileStringB.append(scanner.next()+",");
        }
        scanner.close();

        fileString = fileStringB.toString();
        
        
        FileWriter fw = new FileWriter("OutputImagept21.csv");
        //FileWriter fw = new FileWriter("Text21.csv");
        fw.write("User, Scheme, Time, Login, Count, SuccessCount, FailCount, \n");
        //The number of logins
        int numLogins =0;
        int numLoginsS =0;
        int numLoginsF =0;
        
        
        //loop through each line
        String[] lines = fileString.split("\n");        	
       
        for (int i = 0; i < lines.length; i++){
        	//Split each line by spaces
        	String[] lines2 = lines[i].split(",");
        	
        	try {     	
        		//If the current line we are reading is a login success or fail
        		if (lines2[5].equals("\"login\"") && lines2[6].equals("\"success\"") || lines2[5].equals("\"login\"") && lines2[6].equals("\"failure\"")) {
        			//Add the user and password scheme to the output
        			outString = outString.concat(lines2[1] + ",");
                	outString = outString.concat(lines2[4] + ","); 
                	fw.write(lines2[1] + ",");
                	fw.write(lines2[4] + ",");
                	
        			int j = i - 1;
        			String enterTime = "";
        			int loop = 1;
        			//the time between login and enter start
        			//enterTime will have the time of the enter start entry
        			while (lines[j] != null && j > 0 && lines[j].split(",")[1].equals(lines2[1]) && loop == 1) {
        				if (lines[j].split(",")[5].equals("\"enter\"") && lines[j].split(",")[6].equals("\"start\"")) {
        					enterTime = lines[j].split(",")[0];
        					loop = 0;
        				}
        				j--;
        			}
        			
        			//Calculating the time between login and entry
        			//Output in seconds
        			String loginTime = lines2[0];
        			
        			String loginT = loginTime.split(" ")[1];
        			String enterT = enterTime.split(" ")[1];
        			
        			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        			Date date1 = format.parse(enterT);
        			Date date2 = format.parse(loginT);
        			long difference = date2.getTime() - date1.getTime(); 
        			difference = difference/1000;
        			
        			outString = outString.concat(String.valueOf(difference + ","));
        			fw.write(String.valueOf(difference + ","));
        			//If login succeeded or failed, as well as current number of logins 
        			if (lines2[6].equals("\"failure\"")) {
        				outString = outString.concat("0,");
        				fw.write("0,");
        				numLoginsF++;
        			}
        			else {
        				outString = outString.concat("1,");
        				fw.write("1,");
        				numLoginsS++;
        			}
        			numLogins++;
        			
        			//Output the number of logins
        			outString = outString.concat(numLogins + ",");
        			fw.write(numLogins + ",");
        			outString = outString.concat(numLoginsS + ",");
        			fw.write(numLoginsS + ",");
        			outString = outString.concat(numLoginsF + ",");
        			fw.write(numLoginsF + ",");
        			outString = outString.concat("\n");
        			fw.write("\n");
        		}
        		
        		//If the user is not the same, reset the number of logins
        		if (lines[i+1] != null) {
    				if (!lines2[1].equals(lines[i+1].split(",")[1])) {
    					numLogins = 0;
    					numLoginsS = 0;
    					numLoginsF = 0;
    				}
    			}
        	}
        	catch(ArrayIndexOutOfBoundsException exception){
        		
        	}
        }
        //Print out the string
        System.out.println(outString);
        fw.close();
	}

}
