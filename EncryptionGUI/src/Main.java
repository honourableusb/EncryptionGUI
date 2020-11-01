import java.util.concurrent.TimeUnit;



/* EncryptionGUI.java main - This is the main driver of the code, 
 * 
 */

public class Main {
	
	public static void main(String[] args)
	{
	System.out.println("A");
	new GUI();
	while(GUI.isReady() == false) // while the Generate button has not been pressed
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
	System.out.println("Code executing!");
	}
}