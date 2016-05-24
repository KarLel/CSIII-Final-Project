/*
 * Karthik Lella
 * 5/24/2016
 * Mrs. G
 */

/**
 * The LogRunnable class runs the log threads
 * @author Karthik
 */
public class LogRunnable implements Runnable{
	
	private Log log;
	/**
	 * creates a LogRunnable object
	 * @param l the log to run
	 */
	public LogRunnable(Log l) {
		log = l;
	}
	/**
	 * runs the log thread
	 */
	public void run() {
		try {
			log.animate();
		} catch (InterruptedException e) {}
	}

}
