/*
 * Karthik Lella
 * 5/23/2016
 * Mrs. G
 */

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * A class that creates a frog object whose objective
 * it is to get to the river bank
 */
public class Frog{
	private int x, y, width, height;
	private int speed = 74;
	private Image frog;
	private boolean horizontal;
	JComponent component;
	JFrame frame;
	
	/**
	 * Creates a frog object
	 * @param c the JComponent
	 * @param f the JFrame
	 */
	public Frog(JComponent c, JFrame f) {
		frame = f; x = 450; y = 605; component = c; width = 65; height = 55; horizontal = false;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try{
			frog = ImageIO.read(ClassLoader.getSystemResourceAsStream("Frog.png"));
		}
		catch(IOException ex){}
	}
	/**
	 * Moves the frog depending on the users keyboard input
	 */
	public void move(){
		if(horizontal && x + speed/2 > 0 && x + speed < 960){
			x += (speed/2);
		}
		else if(!horizontal && y + speed > 0 && y + speed < 620){
			y += speed;
			if(y == 13){
				frame.dispose();
				Winner winner = new Winner();				
			}
			System.out.println(y);
		}
		component.repaint();
	}
	/**
	 * Determines whether the frog is in collision with a car
	 * @param car the car to determine the collision
	 * @return whether or not the frog and car are colliding
	 */
	public boolean carCollision(Vehicle car){		
		if(car.getVehicleLane() == -1 || getFrogLane() == -1)
			return false;
		else{
			if(getFrogLane() == car.getVehicleLane())
				return (x > (car.getX()-10) && x < (car.getX() + car.getWidth()));
		}
		return false;
	}
	/**
	 * Determines whether the frog is on the log
	 * @param log the log to determine the collision
	 * @return whether or not the frog is on the log
	 */
	public boolean onLog(Log log){	
		if((y == 235 || y == 161 || y == 87) && (getFrogLane() == log.getLogLane())){
//			System.out.println("Log : " + (log.getX()-50) + " - " + (log.getX() + 165));
//			System.out.println("Frog : " + x);
			return (x > (log.getX()) && x < (log.getX() + log.getWidth()));
		}
		return true;
	}
	/**
	 * Determines which lane the from is in
	 * @return the lane that the frog is in
	 */
	public int getFrogLane(){
		if(y == 309 || y == 235)
			return 1;		
		if(y == 383 || y == 161)
			return 2;
		if(y == 458 || y == 87)
			return 3;
		if(y == 531)
			return 4;
		return -1;
	}
	/**
	 * Returns the x value of the frog
	 * @return the x value of the frog
	 */
	public int getX() {
		return x;
	}
	/**
	 * Returns the y value of the frog
	 * @return the y value of the frog
	 */
	public int getY() {
		return y;
	}
	/**
	 * Returns the width of the frog
	 * @return the width of the frog
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Returns the height of the frog
	 * @return the height of the frog
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Returns the image of the frog
	 * @return the image of the frog
	 */
	public Image getImage() {
		return frog;
	}
	/**
	 * Gets the user keyboard input
	 * @param e the user keyboard input
	 */
	public void keyTyped(KeyEvent e) {
	}
	/**
	 * Gets the user keyboard input
	 * @param e the user keyboard input
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	/**
	 * Gets the user keyboard input
	 * @param e the user keyboard input
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP){
			horizontal = false;
			if(speed > 0)
				speed = -speed;
			move();
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			horizontal = false;
			speed = Math.abs(speed);
			move();
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			horizontal = true;
			if(speed > 0)
				speed = - speed;
			move();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			horizontal = true;
			speed = Math.abs(speed);
			move();
		}
	}
}
