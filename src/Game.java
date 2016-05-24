import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame{
	private GameComponent GameComponent;
	
	public Game(){
		// TODO Auto-generated constructor stub
		GameComponent = new GameComponent(this);
		setTitle("Frogger!");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		setSize(979, 699);
		setSize(980, 700);
		setLocationRelativeTo(null);
		add(GameComponent);
		setVisible(true);
		GameComponent.startAnimation();
		GameComponent.startLogAnimation();
	}
	public void terminate(){
		dispose();
	}
}
