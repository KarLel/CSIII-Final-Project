
public class AnimationRunanble implements Runnable{
	
	private Vehicle car;
	
	public AnimationRunanble(Vehicle v) {
		car = v;
	}
	
	public void run() {
		try {
			car.animate(GameComponent.getVehicles());
		} catch (InterruptedException e) {}
	}

}
