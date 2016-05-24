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
 * The winner class displays the frame when the player wins
 * @author Karthik
 */
public class Winner extends JFrame{
	private Image image;
	/**
	 * creates a Winner object
	 */
	public Winner(){
		setTitle("YOU DID IT!!!");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			image = ImageIO.read(ClassLoader.getSystemResourceAsStream("Winner.png"));
		}
		catch(IOException ex){}
		setContentPane(new JLabel(new ImageIcon(image)));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}