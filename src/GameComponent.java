/*
 * Karthik Lella
 * 5/24/2016
 * Mrs. G
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * This class draws all the objects on the component
 * @author Karthik
 */
public class GameComponent extends JComponent{
	private Image field;
	private static Stack<Vehicle> cars;
	private static LinkedList<Log> logs;
	private Frog frog;
	private JFrame frame;
	
	/**
	 * Creates a GameComponent object 
	 * @param f the JFrame to dispose
	 */
	public GameComponent(JFrame f){
		frame = f;
		cars = new Stack<Vehicle>();
		logs = new LinkedList<Log>();
		fillVehicles(7);
		fillLogs(6);
		frog = new Frog(this, frame);
		field = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Karthik\\Documents\\GitHub\\CSIII-Final-Project\\src\\Field.png");
		implementKeyListener();
	}
	/**
	 * paints all the objects on the graphics
	 * @param gr the graphics object to draw on
	 */
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		gr.drawImage(field, 0, 0, null);
		for(Vehicle car: cars){
			gr.drawImage(car.getImage(), (int)car.getX(), (int)car.getY(), null);
//			if(frog.carCollision(car)){
//				frame.dispose();
//				LoserFrame frame = new LoserFrame();
//			}
		}
		for(Log log: logs){
			gr.drawImage(log.getImage(), (int)log.getX(), (int)log.getY(), null);
			if(!frog.onLog(log)){
				frame.dispose();
				LoserFrame frame = new LoserFrame();
			}
		}
		gr.drawImage(frog.getImage(), (int)frog.getX(), (int)frog.getY(), null);
		repaint();
	}
	/**
	 * starts the vehicle threads
	 */
	public void startAnimation(){
		ArrayList<Runnable> vehicleRunnables = new ArrayList<Runnable>();
		ArrayList<Thread> vehicleThreads = new ArrayList<Thread>();
		for(int i = 0; i < cars.size(); i++){
			vehicleRunnables.add(new AnimationRunanble(cars.get(i)));
			vehicleThreads.add(new Thread(vehicleRunnables.get(i)));		
		}
		for(Thread t: vehicleThreads)
			t.start();
	}
	/**
	 * starts the log threads
	 */
	public void startLogAnimation(){
		ArrayList<Runnable> logRunnables = new ArrayList<Runnable>();
		ArrayList<Thread> logThreads = new ArrayList<Thread>();	
		for(int i = 0; i < logs.size(); i++){
			logRunnables.add(new LogRunnable(logs.get(i)));
			logThreads.add(new Thread(logRunnables.get(i)));			
		}
		for(Thread t: logThreads)
			t.start();
	}
	/**
	 * fills the vehicle array list
	 * @param numVehicles the number of vehicles
	 */
	private void fillVehicles(int numVehicles){
		int x = 0;
		for(int i = 0; i < numVehicles; i++, x += 135)
			cars.push(new Vehicle(this, x));
	}
	/**
	 * fills the log array list
	 * @param numLogs the number of logs
	 */
	private void fillLogs(int numLogs){
		int x = 0;
		for(int i = 0; i < numLogs; i++, x += 135)
			logs.add(new Log(this, x));
	}
	/**
	 * Listens for the user input ot move the frog
	 */
	private void implementKeyListener(){
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}			
			@Override
			public void keyReleased(KeyEvent e) {frog.keyReleased(e);}
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		setFocusable(true);
	}
}