import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frog{
	private int x, y, width, height;
	private int speed = 74;
	private Image frog;
	private boolean horizontal;
	JComponent component;
	JFrame frame;
	
	public Frog(JComponent c, JFrame f) {
		frame = f; x = 450; y = 605; component = c; width = 65; height = 55; horizontal = false;
		frog = Toolkit.getDefaultToolkit().createImage("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Frog.png");
	}
	public void move(boolean onLog){
		if(onLog){
			x -= 5;
		}
		if(horizontal && x + speed/4 > 0 && x + speed < 960){
			x += (speed/4);
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
	public boolean carCollision(Vehicle car){		
		if(car.getVehicleLane() == -1 || getFrogLane() == -1)
			return false;
		else{
			if(getFrogLane() == car.getVehicleLane())
				return (x > car.getX() && x < car.getX() + car.getWidth());
		}
		return false;
	}
	public boolean logCollision(Log log){		
		if(log.getLogLane() == -1 || getFrogLane() == -1)
			return false;
		else{
			if(getFrogLane() == log.getLogLane())
				return (x > log.getX() && x < log.getX() + log.getWidth());
		}
		return false;
	}
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
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public Image getImage() {
		return frog;
	}
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
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
