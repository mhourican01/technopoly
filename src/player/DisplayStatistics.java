/**
 * 
 */
package player;

import java.util.ArrayList;

import square.Computer;
import square.Square;

/**
 * @author 40130998
 *
 */
public class DisplayStatistics {

	// ArrayList to Create Gameboard
	public static ArrayList<Square> Gameboard = new ArrayList<>();

	/**
	 * Displays the current player's details, including balance, location and
	 * properties owned.
	 * 
	 * @param gameboard
	 * @param p
	 */
	public static void displayStatistics(ArrayList<Square> gameboard, Player p) {

		System.out.println();
		System.out.println("Player: " + p.getPlayerName());
		System.out.println("Current balance: " + p.getCurrentBalance());
		for (Square squares : gameboard) {
			if (squares.getName().getValue() == p.getCurrentLocation()) {
				System.out.println("Current Location: " + squares.getName());
			}
		}

		System.out.println("Computers owned: ");
		int compCount = 0;
		for (Computer computer : p.computerMap.values()) {

			System.out.println(computer.getName());
			System.out.println("Level: " + computer.getUpgradeLevel());
			compCount++;
		}
		if (compCount == 0) {
			System.out.println("None");
		}
		System.out.println();
	}
}
