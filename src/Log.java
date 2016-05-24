/*
 * Karthik Lella
 * 5/24/2016f
 * Mrs. G
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The log class displays logs that the frog can use to get to the bank
 * @author Karthik
 */
public class Log{
	private final int DELAY = 30;
	private double x, y, width, height, speed;
	private Image log;
	private JComponent component;
	/**
	 * Creates a log object 
	 * @param c the JComponent to repaint
	 * @param xPos the x position of the log
	 */
	public Log(JComponent c,int xPos){
		component = c; speed = 5; width = 165; height = 60;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			log = ImageIO.read(ClassLoader.getSystemResourceAsStream("Log.png"));
		}
		catch(IOException ex){}
		switch ((int)((Math.random()*3)+1)) {
			case 1: y = 85; x = xPos; break;
			case 2: y = 158; x = xPos; break;
			case 3: y = 230; x = xPos; break;
		}
	}
	/**
	 * moves the logs in a constant motion
	 * @throws InterruptedException
	 */
	public void animate() throws InterruptedException{
		while(true){
			if(y == 85 || y == 230 && x < 950){
				if(x > 900)
					x = -100; 
				x += speed;
			}
			else if(y == 158 && x > -200){
				if(x < -80)
					x = 980;
				x -= speed;
			}			
			pause();
		}
	}
	/**
	 * returns the log's lane
	 * @return the log's lane
	 */
	public int getLogLane(){
		if(y == 230)
			return 1;
		if(y == 158)
			return 2;
		if(y == 85)
			return 3;
		return -1;
	}
	/**
	 * returns the log's width
	 * @return the log's width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * returns the log's height
	 * @return the log's height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * returns the log's x position
	 * @return the log's x position
	 */
	public double getX() {
		return x;
	}
	/**
	 * returns the log's y position
	 * @return the log's y position
	 */
	public double getY() {
		return y;
	}
	/**
	 * pauses the threads
	 * @throws InterruptedException
	 */
	private void pause() throws InterruptedException{
		component.repaint();
		Thread.sleep(DELAY);
	}
	/**
	 * returns the log's image
	 * @return the log's image
	 */
	public Image getImage(){
		return log;
	}
	/**
	 * returns the string version of the log
	 * @return the string version of the log
	 */
	public String toString(){
		return "X: " + getX() + " Y: " + getY() + "\nWidth: " + width + " Height: " + height;
	}
}