/*
 * Karthik Lella
 * Mrs. G
 * 5/23/2016
 */

import javax.swing.*;

/**
 * This frame is displayed when the player loses a match
 * @author Karthik
 */
public class LoserFrame extends JFrame{
	
	/**
	 * Creates a LoserFrame object
	 */
	public LoserFrame(){
		setTitle("BETTER LUCK NEXT TIME!!!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\Loser.png")));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}