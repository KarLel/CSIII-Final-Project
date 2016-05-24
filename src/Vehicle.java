/*
 * Karthik Lella
 * 5/23/2016
 * Mrs. G
 */
import javax.swing.*;
import java.awt.*;
/**
 * The Vehicle class creates a vehicle with given values
 * @author Karthik
 */
public class Vehicle{
	private final int DELAY = 30;
	private double x, y, width, height, speed;
	private Image car;
	private JComponent component;
	
	/**
	 * Creates a new vehicle object
	 * @param c the JComponent
	 * @param xPos the x position of the vehicle
	 */
	public Vehicle(JComponent c, int xPos){
		component = c; speed = 5;
		switch((int)(Math.random()*4)+1){
			case 1: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\Truck.png");
				width = 132; height = 65; break;
			case 2: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\Ambulance.png");
				width = 115; height = 65; break;
			case 3: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\CarOne.png");
				width = 115; height = 57; break;
			case 4: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\Lambo.png");
				width = 115; height = 57; break;
		}
		switch ((int)(Math.random()*4)+1) {
			case 1: y = 300; x = xPos; break;
			case 2: y = 375; x = xPos; break;
			case 3: y = 450; x = xPos; break;
			case 4: y = 525; x = xPos; break;
		}
	}
	/**
	 * Uses multithreading to move the cars in a loop
	 */
	public void animate() throws InterruptedException{
		while(true){
			if(y == 450 || y == 525 && x < 1050){
				if(x > 1000)
					x = -100; 
				x += speed;
			}
			else if(y == 300 || y == 375 && x > -100){
				if(x < -80)
					x = 980;
				x -= speed;
			}			
			pause();
		}
	}
	/**
	 * returns the vehicle's lane
	 * @return the vehicle's lane
	 */
	public int getVehicleLane(){
		if(y == 300)
			return 1;
		if(y == 375)
			return 2;
		if(y == 450)
			return 3;
		if(y == 525)
			return 4;
		return -1;
	}
	/**
	 * returns the vehicle's width
	 * @return the vehicle's width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * returns the vehicle's height
	 * @return the vehicle's height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * returns the vehicle's x position
	 * @return the vehicle's x position
	 */
	public double getX() {
		return x;
	}
	/**
	 * returns the vehicle's y position
	 * @return the vehicle's y position
	 */
	public double getY() {
		return y;
	}
	/**
	 * Pauses the threads
	 */
	private void pause() throws InterruptedException{
		component.repaint();
		Thread.sleep(DELAY);
	}
	/**
	 * Returns the vehicle's image
	 * @return the vehicle's image
	 */
	public Image getImage(){
		return car;
	}
	/**
	 * returns the string version of the Vehicle
	 * @return the string version of the Vehicle
	 */
	public String toString(){
		return "X: " + getX() + " Y: " + getY() + "\nWidth: " + width + " Height: " + height;
	}
}