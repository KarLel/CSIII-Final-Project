/*
 * Karhtik Lella
 * 5/24/2016
 * Mrs. G
 */
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class creates the frame that displays the instructions
 * @author Karthik
 */
public class InstructionsFrame extends JFrame{
	private Image image;
	/**
	 * Creates an InstructionsFrame object
	 */
	public InstructionsFrame(){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			image = ImageIO.read(ClassLoader.getSystemResourceAsStream("Instructions.png"));
		}
		catch(IOException ex){}
		setTitle("Instructions");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon(image)));
		setSize(599,599);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}