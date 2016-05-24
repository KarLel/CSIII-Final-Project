/*
 * Karthik Lella
 * Mrs. G
 * 5/23/2016
 */

import javax.swing.*;

/**
 * The winner class displays the frame when the player wins
 * @author Karthik
 */
public class Winner extends JFrame{
	/**
	 * creates a Winner object
	 */
	public Winner(){
		setTitle("YOU DID IT!!!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\Winner.png")));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}