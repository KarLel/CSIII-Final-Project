/*
 * Karthik Lella
 * Mrs. G
 * 5/23/2016
 */

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This frame is displayed when the player loses a match
 * @author Karthik
 */
public class LoserFrame extends JFrame{
	private Image image;
	/**
	 * Creates a LoserFrame object
	 */
	public LoserFrame(){
		setTitle("BETTER LUCK NEXT TIME!!!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			image = ImageIO.read(ClassLoader.getSystemResourceAsStream("loser.png"));
		}
		catch(IOException ex){}
		setContentPane(new JLabel(new ImageIcon(image)));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}