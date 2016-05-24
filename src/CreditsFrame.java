/*
 * Karthik Lella
 * 5/23/2016
 * Mrs. G
 */
import javax.swing.*;
/**
 * This class shows all the credits for the game
 * @author Karthik
 */
public class CreditsFrame extends JFrame{
	/**
	 * Creates a credits object
	 */
	public CreditsFrame(){
		
		setTitle("Credits");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Frogger.png")));
		setSize(599,499);
		setSize(600,500);
		setLocationRelativeTo(null);
		setVisible(true);
	
	}

}