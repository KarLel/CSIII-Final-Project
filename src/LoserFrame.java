/*
 * Karthik Lella
 * Mrs. G
 * 5/23/2016
 */

import javax.swing.*;

public class LoserFrame extends JFrame{
	
	public LoserFrame(){
		setTitle("BETTER LUCK NEXT TIME!!!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Loser.png")));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}