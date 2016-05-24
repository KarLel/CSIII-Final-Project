import javax.swing.*;

public class InstructionsFrame extends JFrame{
	
	public InstructionsFrame(){
		
		setTitle("Instructions");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Instructions.png")));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}