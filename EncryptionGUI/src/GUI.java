

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
	private JLabel outputLabel = new JLabel("<html><style>p {text-align: center;}</style> <p><br/>For decrypting encrypted messages</p></html>");
	private JLabel messageLabel1 = new JLabel("<html><style>p {text-align: center;}</style>"
			+ "<p>You can either enter a filename, or a plaintext message.<br/>"
			+ "    If you enter a plain message, please start the message with \"**\"<br/>"
			+ "<br/>For Encryption </p></html>");
	private JLabel spaceLabel = new JLabel("Enter amount of dummy characters");
	private JLabel alphaLabel = new JLabel("Enter what A should be equal to (Caesar Cipher)");
	private JLabel numLabel = new JLabel("Enter what 0 should equal (Number Caesar Cipher)");
	private JLabel breakLabel = new JLabel("<html><p> <br/> </p></html>");
	private JPanel inputPanel = new JPanel();
	private JTextField inField = new JTextField("", 30);
	private JTextField outField = new JTextField("", 30);
	
	GUI()
	{
		setTitle("Message Encryptor/Decryptor");
		
		
		setSize(525,350);
		inputPanel.setSize(500, 250);
		inputPanel.add(messageLabel1);
		//inputPanel.add(messageLabel2);
		inputPanel.add(inField);
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
		inputPanel.add(encrypt);
		inputPanel.add(outputLabel);
		inputPanel.add(outField);
		inputPanel.add(fileChoiceD);
		inputPanel.add(decrypt);
		add(inputPanel);
		addWindowListener(this);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
