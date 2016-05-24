/*
 * Karthik Lella
 * 5/23/2016
 * Mrs. G
 */

/**
 * Runs the animation for the vehicle class
 * @author Karthik
 */
public class AnimationRunanble implements Runnable{
	private Vehicle car;
	/**
	 * Creates an object that runs threads for the vehicle class
	 * @param v
	 */
	public AnimationRunanble(Vehicle v) {
		car = v;
	}
	
	/**
	 * Runs threads
	 */
	public void run() {
		try {
			car.animate();
		} catch (InterruptedException e) {}
	}

}
