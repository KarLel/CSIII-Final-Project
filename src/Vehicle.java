 import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Vehicle{
	private final int DELAY = 30;
	private double x, y, width, height, speed;
	private Image car;
	private JComponent component;
	
	public Vehicle(JComponent c, int xPos){
		component = c; speed = 5;
		switch((int)(Math.random()*4)+1){
			case 1: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Truck.png");
				width = 132; height = 65; break;
			case 2: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Ambulance.png");
				width = 115; height = 65; break;
			case 3: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\CarOne.png");
				width = 115; height = 57; break;
			case 4: 
				car = Toolkit.getDefaultToolkit().createImage("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Lambo.png");
				width = 115; height = 57; break;
		}
		switch ((int)(Math.random()*4)+1) {
			case 1: y = 300; x = xPos; break;
			case 2: y = 375; x = xPos; break;
			case 3: y = 450; x = xPos; break;
			case 4: y = 525; x = xPos; break;
		}
	}
	public void animate(ArrayList<Vehicle> cars) throws InterruptedException{
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
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	private void pause() throws InterruptedException{
		component.repaint();
		Thread.sleep(DELAY);
	}
	public Image getImage(){
		return car;
	}
	public String toString(){
		return "X: " + getX() + " Y: " + getY() + "\nWidth: " + width + " Height: " + height;
	}
}