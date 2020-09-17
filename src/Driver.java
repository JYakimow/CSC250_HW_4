import java.util.Scanner;

//Write a function in Java that takes a String representation of a binary number as a parameter and returns a String representation of the hexadecimal equivalent.
public class Driver 
{
	public static void main(String[] args) //begins main method
	{	
		/*
		while(true)
		{
			System.out.println("What would you like to do?");
			System.out.println("[1] Input a number.");
			System.out.println("[2] Convert current number to binary.");
			System.out.println("[3] Convert current number from binary to decimal.");
			System.out.println("[4] Convert inputed number to binary.");
		}
		*/
		
		String binary = inputBinary();
		String output = binaryToHex(binary);

		System.out.print("The hexadecimal equivalent of the inputed number is: ");
		System.out.println(output);

		//------------ Keep all main method code above this line ------------
		//System.out.println("[End Program]"); //informs user that the program has ended
	} //ends main method
	
	static Integer inputDecimal()
	{
		//input value to be checked using scanner class
		Scanner decInput = new Scanner(System.in); //opens the scanner
		Integer userInput = 0; //create variable to use inputed string after converted to an integer later
		
		while(true)
		{
			System.out.println("Please enter the number you wish converted: ");
			String initialString = decInput.nextLine(); //takes value inputed and assigns value to a variable.
			
			try //this code will be executed if possible unless input is not proper type
			{
				userInput = Integer.parseInt(initialString); //convert the string to an integer to be used later in program
				decInput.close(); //close scanner resource leak
				break;
			}
			catch(Exception a) //if code above fails in line 17-22 this will be executed. Designed to catch improper user-input error.
			{
				System.out.println("You must enter a number.");
			}
		} //end while loop
		return userInput;
	}
	
	static String inputBinary()
	{
		//input value to be checked using scanner class
		Scanner binaryInput = new Scanner(System.in);
		String userInput = "";
		System.out.println("Please enter the binary number you wish converted to hexadecimal: ");
		String initialString = binaryInput.nextLine(); 
		userInput = initialString;
		binaryInput.close();
		return userInput;
	}
	
	static String DecimalToBinary(Integer startInt) 
	{
		//define local variables
		Integer start = startInt;
		Integer currentNum = 0;
		Integer remainder = 0;
		String binary = "";
		
		//logic to calculate binary equivalent
		currentNum = start; //assign starting value to currentNum variable
		while(true)
		{
			remainder = currentNum % 2; //get remainder of modulo division of currentNum by 2 (repeat till number cannot be divided further)
			binary = remainder + binary; //creating binary string using the output remainders
			currentNum = currentNum / 2; //divide currentNum by 2 to adjust future modulo division to get remainders
			if(currentNum == 0) { //check if number can still be divided any further
				break; //break while loop
			}
		}//end while loop
		return binary; //return binary string
	}//end convertToBinary function
	
	static Integer binaryToDecimal(String startString)
	{
		//define variables
		String start = startString;
		char[] binaryArray = start.toCharArray();
		Integer currentNum = 0;
		//char digit = 'a';
		Integer count = 0;
		Integer output = 0;
		
		//calculate decimal
		for(int i = 0; i < start.length(); i++)
		{
			count = i; //set position of position counter
			String temp = Character.toString(binaryArray[count]);
			Integer digit = Integer.parseInt(temp);
			currentNum = 2 * currentNum;
			currentNum = currentNum + digit;
		}
		output = currentNum;
		return output;
	}
	
	static String binaryToHex(String startBinary) 
	{
		//define local variables
		Integer start = binaryToDecimal(startBinary);
		Integer currentNum = 0;
		Integer remainder = 0;
		String hex = "";
		
		//logic
		currentNum = start; 
		while(true)
		{
			String temp = "";
			remainder = currentNum % 16;
			while(true) 
			{
				if(remainder == 10) 
				{
					temp = "A";
					break;
				}
				else if(remainder == 11) 
				{
					temp = "B";
					break;
				}
				else if(remainder == 12) 
				{
					temp = "C";
					break;
				}
				else if(remainder == 13) 
				{
					temp = "D";
					break;
				}
				else if(remainder == 14) 
				{
					temp = "E";
					break;
				}
				else if(remainder == 15) 
				{
					temp = "F";
					break;
				}
				else
				{
					temp = Integer.toString(remainder);
					break;
				}
			}
			hex = temp + hex; 
			currentNum = currentNum / 16; 
			if(currentNum == 0) { 
				break; 
			}
		}//end while loop
		return hex;
	}//end DecimalToHex function
}//end Driver Class