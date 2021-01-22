package selectionMenu;

import java.util.ArrayList;
import java.util.Scanner;

import player.*;
import square.*;
import run.*;

public class PreSelectionMenu extends SelectionMenu implements Confirmation {

	private static boolean exitedGame;

	/**
	 * Print menu options
	 */
	@Override
	public void printMenu(ArrayList<Square> gameboard, Player p, ArrayList<Player> players) {
		System.out.println("What would you like to do next?");
		System.out.println("1. Display Statistics");
		System.out.println("2. Display Board");
		System.out.println("3. Roll Dice");
		System.out.println("4. Exit Game");
	}

	/**
	 * Allow player to choose an option using a scanner
	 */
	@Override
	public void chooseOption(Scanner scanner, ArrayList<Square> gameboard, ArrayList<Computer> computerList, Player p,
			ArrayList<Player> players) {

		boolean valid = false;

		/**
		 * Iterate until valid choice
		 */
		do {
			/**
			 * Try catch for valid int input in scanner
			 */
			try {

				printMenu(gameboard, p, players);
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					DisplayStatistics.displayStatistics(gameboard, p);
					valid = false;
					break;
				case 2:
					Computer.displayBoard(computerList, players);
					valid = false;
					break;
				case 3:
					PlayerLocationUpdater.updatePlayerLocation(scanner, p, gameboard, computerList, players);
					valid = true;
					break;
				case 4:
					if (Confirmation.confirm(scanner)) {
						setExitedGame(true);
						EndGame.gameEnder(scanner, p, players);
						valid = true;
						break;
					} else {
						break;
					}

				default:
					System.out.println("Invalid selection, try again");
					valid = false;
				}

			} catch (Exception e) {
				System.out.println("Invalid input, please try again.");
				scanner.nextLine();

			}
		} while (!valid);
	}

	/**
	 * Returns exitedGame Boolean
	 * 
	 * @return
	 */
	public static boolean isExitedGame() {
		return exitedGame;
	}

	/**
	 * Sets the exitedGame Boolean to determine if a player chose exit game
	 * 
	 * @param exitedGame
	 */
	public void setExitedGame(boolean exitedGame) {
		PreSelectionMenu.exitedGame = exitedGame;
	}

}