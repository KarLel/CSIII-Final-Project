/*
 * Karthik Lella
 * 5/23/2016
 * Mrs. G
 */
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * This class shows all the credits for the game
 * @author Karthik
 */
public class CreditsFrame extends JFrame{
	/**
	 * Creates a credits object
	 */
	
	private Image image;
	public CreditsFrame(){
		
		setTitle("Credits");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			image = ImageIO.read(ClassLoader.getSystemResourceAsStream("Frogger.png"));
		}
		catch(IOException ex){}
		setContentPane(new JLabel(new ImageIcon(image)));
		setSize(599,499);
		setSize(600,500);
		setLocationRelativeTo(null);
		setVisible(true);
	
	}

}