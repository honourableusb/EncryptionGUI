import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



/* EncryptionGUI.java main - This is the main driver of the code
 * Logic in progress - I am not smart
 */

public class Main {
	
	public static void main(String[] args)
	{
	//System.out.println("A");
	new GUI();
	while(GUI.isReady() == false) // while the GUI isn't ready to encrypt/decrypt
		//I know this form is bad but all the other implementations I saw used multithreading, and that didn't make sense for me to use
	{
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Sleep function interrupted");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	//System.out.println("Code executing!");
	
	boolean encrypt = GUI.isEncryption();
	
	if(encrypt)
		encrypt();
	else
		decrypt();
		
	}
	
	public static void encrypt()
	{
		char[] cipherChoices = GUI.getCipherChoices();
		boolean isFile = GUI.isAFile();
		if(isFile) // if our input method is a file, use this way of extracting the message.
			//there is also a different method of storing the key for files as opposed to plaintext.
		{
			File inputFile = GUI.getEncryptFile();
			Scanner fileIn = null;
			int lineCount = 0;
			String[] message;
			
			try {
				fileIn = new Scanner(inputFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.printf("File not found: %s\n", inputFile.getName());
				e.printStackTrace();
				System.exit(1);
			}
			while(fileIn.hasNextLine()) //get the amount of lines the file contains, we need this to create an array with the right size
			{
				lineCount++;
				fileIn.nextLine();
			}
			//System.out.println("Line count: " + lineCount);
			message = new String[lineCount];
			try {
				fileIn = new Scanner(inputFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.printf("File not found: %s\n", inputFile.getName());
				e.printStackTrace();
				System.exit(1);

			}
			for(int i = 0; i < lineCount; i++)
			{
				message[i] = fileIn.nextLine();
				message[i] = messUpLine(message[i], cipherChoices);
			}
			//test code, print our message
			/*
			 * for(String line : message) { System.out.println(line); }
			 */
			
		}
		else // if not, use this way!
		{
			String message = GUI.getEncryptField().replace("**","");
			System.out.println(message);
			messUpLine(message, cipherChoices);
		}
	}
	
	
	/**
	 * This function encrypts the individual lines based on the user's GUI inputs
	 * @param line	line to be encrypted
	 * @param cipherChoices the different encryption options (dummy characters, alphabet cipher, number/special character cipher)
	 * @return the mumbled and jumbled line
	 */
	public static String messUpLine(String line, char[] cipherChoices)
	{
		Random r = new Random(System.nanoTime());
		final int RANGE = 93; //the amount of characters we can choose from is 93, ascii values 33-126
		final int LOWER_BOUND = 33; //the first character we can pick for random generation (!)
		final int INTEGER_START = 48; //the ascii value of 0		
		
		int dummyCharacterAMT = cipherChoices[0] - INTEGER_START;
		char characterShift = cipherChoices[1];
		int numberShift = (int)cipherChoices[2] - INTEGER_START;
		
		int characterDifference = characterShift - 'A';
		StringBuilder newLine = new StringBuilder();
		
		//adding dummy characters
		for(int i = 0; i < line.length(); i++)
		{
			newLine.append(line.charAt(i));
			for (int j = 0; j < dummyCharacterAMT; j++)
			{
				int asciiVal = r.nextInt(RANGE) + LOWER_BOUND;
				char dummy = (char) asciiVal;
				newLine.append(dummy);
				//System.out.println(newLine);
			}
		}
		System.out.println(newLine);
		r = null;
		
		//Caesar cipher(s)		
		for(int i = 0; i < newLine.length(); i++)
		{
			if(isAlpha(newLine.charAt(i)))
			{
				newLine.setCharAt(i, alphaShift(newLine.charAt(i), characterDifference));
			}
			else if(!isUneditable(newLine.charAt(i)))
			{
				newLine.setCharAt(i,numShift(newLine.charAt(i), numberShift));
			}
			else
			{
				//The character is a space or special ascii character
			}
		}
		System.out.println(newLine);
		return newLine.toString();
	}
	
	private static char numShift(char charAt, int numberShift) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static char alphaShift(char value, int difference)
	{
		char newValue = (char)(value + difference);
		//wraparound function to ensure that alphabet stays alphabet
		//if the new character value is not a character anymore, wrap around to the next characters
		if((newValue < 97 && newValue > 90) || (newValue > 122))
		{
			if(newValue > 90 && newValue < 97) //if it was originally 
			{
				int wraparound = (int)(newValue - 'Z') - 1;
				newValue = (char)('a' + wraparound);
			}
			else
			{
				int wraparound = (int)(newValue - 'z') -1;
				newValue = (char)('A' + wraparound);
			}
			//System.out.printf("Original char: %c New char: %c\n", value, newValue);
		}
		return newValue;
	}
	
	
	/**
	 * This function evaluates the character passed to it, and returns depending on the 
	 * program's capability to edit it.
	 * The program will not edit spaces, ascii values 0-31, or the delete ascii value.
	 * It may later.
	 * @param charAt The evaluated character
	 * @return false if a number, letter, or special character (#$^*@), true otherwise
	 */
	private static boolean isUneditable(char charAt) 
	{
		int indexValue = charAt;
		if (indexValue <= 32 || indexValue == 127)
			return true;
		return false;
	}
	
	private static boolean isAlpha(char charAt) {
		int indexValue = (int)charAt;
		//if the character is either a lowercase letter or uppercase letter, return true
		if((indexValue < 91 && indexValue > 64) || (indexValue < 123 && indexValue > 96))
			return true;
		return false;
	}

	public static void decrypt()
	{
		boolean isFile = GUI.isAFile();
	}
}