import java.util.concurrent.TimeUnit;



/* EncryptionGUI.java main - This is the main driver of the code
 * Logic in progress
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
	}
	
	public static void decrypt()
	{
		boolean isFile = GUI.isAFile();
	}
}