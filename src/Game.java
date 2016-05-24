import javax.swing.JFrame;

/**
 * Creates a game object that displays changes made in the game component
 * @author Karthik
 *
 */
public class Game extends JFrame{
	private GameComponent GameComponent;
	/**
	 * Creates a Game object
	 */
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
}
