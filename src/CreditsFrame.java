import javax.swing.*;

@SuppressWarnings("serial")
public class CreditsFrame extends JFrame{
	
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