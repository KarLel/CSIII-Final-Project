/*
 * Karhtik Lella
 * 5/24/2016
 * Mrs. G
 */
import javax.swing.*;

/**
 * This class creates the frame that displays the instructions
 * @author Karthik
 */
public class InstructionsFrame extends JFrame{
	
	/**
	 * Creates an InstructionsFrame object
	 */
	public InstructionsFrame(){
		
		setTitle("Instructions");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\Instructions.png")));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}