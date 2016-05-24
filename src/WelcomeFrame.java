/*
 * Karthik Lella
 * 5/24/2016
 * Mrs. G
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	private Image playImage;
	private Image helpImage;
	private Image scoreImage;
	private Image creditImage;
	
	/**
	 * Creates a WelcomeFrame object
	 */
	public WelcomeFrame(){
		playButton	 = new JButton("PLAY");
		helpButton	 = new JButton("HELP");
		scoreButton	 = new JButton("HIGH SCORES");
		creditButton = new JButton("CREDITS");
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			playImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("PlayButton.png"));
			helpImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("HelpButton.png"));
			scoreImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("ScoresButton.png"));
			creditImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("CreditsButton.png"));
			
			playButton.setIcon(new ImageIcon(playImage));
			helpButton.setIcon(new ImageIcon(helpImage));
			scoreButton.setIcon(new ImageIcon(scoreImage));
			creditButton.setIcon(new ImageIcon(creditImage));
		}
		catch(IOException ex){}
		
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