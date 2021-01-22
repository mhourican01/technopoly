/**
 * 
 */
package square;

import java.util.ArrayList;

import player.Player;

/**
 * @author Brendan
 *
 */
public class FreeSession extends Square {

	// Instance Vars
	private static final String MESSAGE = "You Have Been Granted A Free PC Session!";

	// Constructors
	/**
	 * Default Constructors
	 */
	public FreeSession() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor with Args
	 * @param name
	 * @throws Exception
	 */
	public FreeSession(SquareNames name) throws Exception {
		super(name);
	}
	
	// Methods
	/**
	 * @return the message
	 */
	public static String getMessage() {
		return MESSAGE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see square.Square#displaySquare()
	 */
	@Override
	public void displaySquare(ArrayList<Player> players) throws Exception {
		// TODO Auto-generated method stub
		super.displaySquare(players);
	}

}
