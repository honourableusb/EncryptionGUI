

import javax.swing.*;

//import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class GUI extends JFrame implements WindowListener,ActionListener{

	private final Character[] emptySpaceOrZeroEq = {'-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private final Character[] aEqualsChoice = {'-','A','B','C','D','E','F','G','H','I','J',
			'K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private JButton fileChoice = new JButton("Choose file...");
	private JButton fileChoiceD = new JButton("Choose file...");
	private JButton encrypt = new JButton("Encrypt");
	private JButton decrypt = new JButton("Decrypt");
	private JComboBox<Character> zeroEquals = new JComboBox<Character>(emptySpaceOrZeroEq);
	private JComboBox<Character> emptySpace = new JComboBox<Character>(emptySpaceOrZeroEq);
	private JComboBox<Character> aEquals = new JComboBox<Character>(aEqualsChoice);
	private JFileChooser fileInput = new JFileChooser();
	private JLabel outputLabel = new JLabel("<html><style>p {text-align: center;}</style> <p><br/>For decrypting encrypted messages</p></html>");
	private JLabel messageLabel1 = new JLabel("<html><style>p {text-align: center;}</style>"
			+ "<p>You can either enter a filename, or a plaintext message.<br/>"
			+ "    If you enter a plain message, please start the message with \"**\"<br/>"
			+ "<br/>For Encryption </p></html>");
	private JLabel spaceLabel = new JLabel("Enter amount of dummy characters");
	private JLabel alphaLabel = new JLabel("Enter what A should be equal to (Caesar Cipher)");
	private JLabel numLabel = new JLabel("Enter what 0 should equal (Number Caesar Cipher)");
	private JPanel inputPanel = new JPanel();
	private JTextField inField = new JTextField("", 30);
	private JTextField outField = new JTextField("", 30);
	File inputFile;
	
	GUI()
	{
		setTitle("Message Encryptor/Decryptor");
		setSize(525,350);
		fileInput.setMultiSelectionEnabled(false);
		inputPanel.setSize(500, 250);
		inputPanel.add(messageLabel1);
		//inputPanel.add(messageLabel2);
		inputPanel.add(inField);
		fileChoice.addActionListener(this);
		fileChoice.setActionCommand("Encrypt file selection");
		inputPanel.add(fileChoice);
		//inputPanel.add(breakLabel);
		inputPanel.add(spaceLabel);
		//inputPanel.add(breakLabel);
		inputPanel.add(emptySpace);
		inputPanel.add(alphaLabel);
		inputPanel.add(aEquals);
		//inputPanel.add(breakLabel);
		inputPanel.add(numLabel);
		inputPanel.add(zeroEquals);
		//inputPanel.add(breakLabel);
		encrypt.addActionListener(this);
		encrypt.setActionCommand("Encrypt");
		inputPanel.add(encrypt);
		inputPanel.add(outputLabel);
		inputPanel.add(outField);
		fileChoiceD.addActionListener(this);
		fileChoiceD.setActionCommand("Decrypt file selection");
		inputPanel.add(fileChoiceD);
		decrypt.addActionListener(this);
		decrypt.setActionCommand("Decrypt");
		inputPanel.add(decrypt);
		add(inputPanel);
		addWindowListener(this);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionName = e.getActionCommand();
		//if the action is received from a 'Select file...' button, open a file dialog.
		if(actionName.equals("Encrypt file selection") || actionName.equals("Decrypt file selection")) 
		{
			/* fileInput.setVisible(true); */
			int returnVal = fileInput.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				inputFile = fileInput.getSelectedFile();
				if(actionName.equals("Encrypt file selection"))
					inField.setText(inputFile.getAbsolutePath());
				else
					outField.setText(inputFile.getAbsolutePath());
			}
		}
		//If the encrypt button is pressed
		if(actionName.equals("Encrypt"))
		{
			//TODO What happens when you press the magic button?
			/*  1. Checks if file exists, if not, throw an error
			 *  2. Check that all the dropdown menus are completed, if not throw an error
			 *  3. ???
			 *  4. Profit
			 */
		}
		//If the decrypt button is pressed
		if(actionName.equals("Decrypt"))
		{
			//TODO What happens when you press the antimagic button?
			/*  1. Checks that the file exists, if not throw an error
			 *  2. ???
			 *  3. Profit 
			 */
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
