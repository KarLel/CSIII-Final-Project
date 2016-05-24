
public class LogRunnable implements Runnable{
	
	private Log log;
	
	public LogRunnable(Log l) {
		log = l;
	}
	
	public void run() {
		try {
			log.animate(GameComponent.getLogs());
		} catch (InterruptedException e) {}
	}

}
