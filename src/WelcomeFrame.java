/*
 * Karthik Lella
 * 5/24/2016
 * Mrs. G
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Creates the first frame the player will see. Allows the user to 
 * choose between different actions;
 */
public class WelcomeFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton playButton;
	private JButton helpButton;
	private JButton scoreButton;
	private JButton creditButton;
	
	/**
	 * Creates a WelcomeFrame object
	 */
	public WelcomeFrame(){
		playButton	 = new JButton("PLAY");
		helpButton	 = new JButton("HELP");
		scoreButton	 = new JButton("HIGH SCORES");
		creditButton = new JButton("CREDITS");
		
		playButton.setIcon(new ImageIcon("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\PlayButton.png"));
		helpButton.setIcon(new ImageIcon("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\HelpButton.png"));
		scoreButton.setIcon(new ImageIcon("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\ScoresButton.png"));
		creditButton.setIcon(new ImageIcon("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\CreditsButton.png"));
		
		playButton.addActionListener(this);
		helpButton.addActionListener(this);
		scoreButton.addActionListener(this);
		creditButton.addActionListener(this);
		
		setTitle("Frogger!");
		setSize(750, 750);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(2,2));
		
		add(playButton);
		add(helpButton);
		add(scoreButton);
		add(creditButton);	
		
		setVisible(true);
	}

	/**
	 * ActionEvent completes an action
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(playButton)){
			dispose();
			Game game = new Game();
		}
		if(e.getSource().equals(helpButton)){
			InstructionsFrame frame = new InstructionsFrame();
		}
		if(e.getSource().equals(scoreButton)){
			JOptionPane.showMessageDialog(null, "Everyone is a winner!");
		}
		if(e.getSource().equals(creditButton)){
			CreditsFrame frame = new CreditsFrame();
		}
	}
	/**
	 * runs the WelcomeFrame
	 * @param args
	 */
	public static void main(String args[]) {
    	WelcomeFrame frame = new WelcomeFrame();
	}	
}