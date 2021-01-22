package run;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import player.*;
import square.*;

/**
 * This class holds the "updatePlayerLocation" method, facilitating the player's
 * movement around the Game Board
 * 
 * @author Cormac
 *
 */
public class PlayerLocationUpdater {

	/**
	 * This method updates the player location variable, facilitating their changing
	 * position on the gameboard as it relates to the Gameboard Arraylist.
	 * 
	 * @param player
	 * @param Gameboard
	 * @param players
	 * @throws Exception
	 */
	public static ArrayList<Square> updatePlayerLocation(Scanner scanner, Player player, ArrayList<Square> gameboard,
			ArrayList<Computer> computerList, ArrayList<Player> players) throws Exception {

		// moving the player through the gameboard
		int counter = player.getCurrentLocation();
		int dice = Dice.rollDice();

		for (int count = 0; count < dice; count++) {
			counter++;
			player.setCurrentLocation(player.getCurrentLocation() + 1);
			if (counter > 11) {
				player.setCurrentLocation(0);
				Go.payday(player);
				counter = 0;
			}
		}

		// Determining what occurs on the square the player has landed on

		if (player.getCurrentLocation() == (SquareNames.FREE_SESSION.getValue())) {
			System.out.println(FreeSession.getMessage());
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);

		} else if (player.getCurrentLocation() == (SquareNames.GO.getValue())) {
			Go.goMessage();
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);

		} else {
			// the player has landed on a computer square, determine if the current
			// player owns the square, if another player owns it or whether it is owned at
			// all.

			System.out.print("You have landed on ");
			for (Computer c : computerList) {
				if (c.getName().getValue() == player.getCurrentLocation()) {
					System.out.print(c.getField() + " " + c.getName());
				}
			}
			System.out.println(".");

			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);

			for (Computer computer : computerList) {

				// Player owns the square - do nothing
				if (player.getCurrentLocation() == computer.getName().getValue()) {
					// System.out.println(computer.getName());
					if (computer.getOwner() == player.getPlayerName()) {
						System.out.println("You already own these models! Relax and enjoy a well-earned break.");

						// Other player owns the square, pay rent.
					} else if (computer.getOwner() != null) {
						System.out.println("You have purchased a " + computer.getField() + " " + computer.getName()
								+ " from " + computer.getOwner() + "!");
						run.ComputerManager.paySessionPrice(scanner, player, players, computerList, gameboard);
//					
						// If Square is unowned, provide option to buy.
					} else {

						run.ComputerManager.buyComputer(scanner, player, computer, players, computerList);
					}
				}
			}
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			gameboard = Computer.castToGameboard(computerList);

		}

		return gameboard;
	}
}