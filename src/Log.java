import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Log{
	private final int DELAY = 30;
	private double x, y, width, height, speed;
	private Image log;
	private JComponent component;
	
	public Log(JComponent c){
		component = c; speed = 5; width = 165; height = 60;
		log = Toolkit.getDefaultToolkit().createImage("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Log.png");
		switch ((int)(Math.random()*3)+1) {
			case 1: y = 85; x = (int)(Math.random()*750); break;
			case 2: y = 158; x = (int)(Math.random()*750); break;
			case 3: y = 230; x = (int)(Math.random()*750); break;
		}
	}
	public void animate(LinkedList<Log> logs) throws InterruptedException{
		while(true){
			if(y == 85 || y == 230 && x < 1000){
				if(x > 950)
					x = -180; 
				x += speed;
			}
			else if(y == 158 && x > -200){
				if(x < -181)
					x = 900;
				x -= speed;
			}			
			pause();
		}
	}
	public int getLogLane(){
		if(y == 235)
			return 1;
		if(y == 161)
			return 2;
		if(y == 87)
			return 3;
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
		return log;
	}
	public String toString(){
		return "X: " + getX() + " Y: " + getY() + "\nWidth: " + width + " Height: " + height;
	}
}