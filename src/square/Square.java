package square;

import java.util.ArrayList;

import player.Player;

/**
 * @author Brendan
 *
 */
public abstract class Square {

	// Instance Vars
	protected SquareNames name;

	// Constructors
	/**
	 * Default Constructor
	 */
	public Square() {
	}

	/**
	 * @param name
	 * @throws Exception
	 */
	public Square(SquareNames name) throws Exception {
		super();
		this.setName(name);
	}

	// Methods

	/**
	 * @return the name
	 */
	public SquareNames getName() {
		return name;
	}

	/**
	 * @param square1 the name to set
	 * @throws Exception
	 */
	public void setName(SquareNames square1) throws Exception {
		this.name = square1;
	}

	/**
	 * Method to display the name and occupants of the square
	 * 
	 * @throws Exception
	 */
	public void displaySquare(ArrayList<Player> players) throws Exception {

		System.out.println("Name : \t\t\t\t\t" + getName());
		for (Player player : players) {
			if (this.getName().getValue() == player.getCurrentLocation()) {
				System.out.print("Current Occupants: \t\t\t");
				break;
			}
		}
		// Build arrayList for all players on a specific square
		ArrayList<Player> playerOnSquare = new ArrayList<>();
		for (Player player : players) {
			if (this.getName().getValue() == player.getCurrentLocation()) {
				playerOnSquare.add(player);
			}

		}
		for (int loop = 0; loop < playerOnSquare.size(); loop++) {
			if (playerOnSquare.size() > 0) {
				if (loop < (playerOnSquare.size() - 1)) {
					System.out.print(playerOnSquare.get(loop).getPlayerName() + ", ");
				} else {
					System.out.println(playerOnSquare.get(loop).getPlayerName());
				}
			} else {
				System.out.println(playerOnSquare.get(loop).getPlayerName());
			}
		}

	}

}