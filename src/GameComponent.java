import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameComponent extends JComponent{
	private Image field;
	private static ArrayList<Vehicle> cars;
	private static LinkedList<Log> logs;
	private Frog frog;
	private JFrame frame;
	
	public GameComponent(JFrame f){
		frame = f;
		cars = new ArrayList<Vehicle>();
		logs = new LinkedList<Log>();
		fillVehicles(20);
		fillLogs(15);
		frog = new Frog(this, frame);
		field = Toolkit.getDefaultToolkit().createImage("C:\\Users\\karth\\workspace\\CSIII Final Project\\bin\\Field.png");
		implementKeyListener();
	}
	public void paintComponent(Graphics gr){
		super.paintComponent(gr);
		gr.drawImage(field, 0, 0, null);
		for(Vehicle car: cars){
			gr.drawImage(car.getImage(), (int)car.getX(), (int)car.getY(), null);
			if(frog.carCollision(car)){
				frame.dispose();
				LoserFrame frame = new LoserFrame();
			}
		}
		for(Log log: logs)
			gr.drawImage(log.getImage(), (int)log.getX(), (int)log.getY(), null);
		gr.drawImage(frog.getImage(), (int)frog.getX(), (int)frog.getY(), null);
		repaint();
	}
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
	private void fillVehicles(int numVehicles){
		int x = 0;
		for(int i = 0; i < numVehicles; i++){
			cars.add(new Vehicle(this, x));
			x += 100;
		}
		
	}
	private void fillLogs(int numLogs){
		for(int i = 0; i < numLogs; i++)
			logs.add(new Log(this));
	}
	public static ArrayList<Vehicle> getVehicles(){
		return cars;
	}
	public static LinkedList<Log> getLogs(){
		return logs;
	}
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