package selectionMenu;

import java.util.ArrayList;

import java.util.Scanner;

import player.*;
import square.*;
import run.*;

/**
 * PostSelection menu used to make decisions after player has rolled dice.
 * Different menu presented based on whether a player owns a field that can be
 * upgraded or not.
 * 
 * @author 40020788
 *
 */
public class PostSelectionMenu extends SelectionMenu implements Confirmation {

	private static boolean exitedGame;

	// private boolean harness = true;

	public static ArrayList<Integer> compList;

	ComputerManager cm = new ComputerManager();

	/**
	 * Print menu options, affected by upgrade token, if player can upgrade cafés
	 * then option is visible, else not presented.
	 */
	@Override
	public void printMenu(ArrayList<Square> gameboard, Player p, ArrayList<Player> players) {

		System.out.println("What would you like to do next?");
		System.out.println("1. Display Statistics");
		System.out.println("2. Display Board");
		// checks if player owns at least one full field.
		if (p.isLenovoOwner() || p.isDellOwner() || p.isAppleOwner() || p.isAsusOwner()) {
			System.out.println("3. Buy Upgrade");
			System.out.println("4. End Turn");
			System.out.println("5. Exit Game");
			// else print menu without upgraded system
		} else {
			System.out.println("3. End Turn");
			System.out.println("4. Exit Game");
		}
	}

	/**
	 * Allow player to choose an option using a scanner
	 */
	@Override
	public void chooseOption(Scanner scanner, ArrayList<Square> gameboard, ArrayList<Computer> computerList, Player p,
			ArrayList<Player> players) {

		int choice = 0;
		boolean valid = false;
		/*
		 * Check player can buy upgrades
		 */
		if (p.isLenovoOwner() || p.isDellOwner() || p.isAppleOwner() || p.isAsusOwner()) {
			/**
			 * Iterate until valid choice
			 */
			do {
				/**
				 * Try catch for valid int input in scanner
				 */
				try {
					printMenu(gameboard, p, players);
					choice = scanner.nextInt();

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
						cm.upgradeDisplayer(scanner, gameboard, computerList, p, players);
						valid = false;
						break;
					case 4:
						if (Confirmation.confirm(scanner)) {
							valid = true;
							break;
						} else {
							break;
						}
					case 5:
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

			/**
			 * alternative if player does not have complete field
			 */
		} else {
			/**
			 * Iterate until valid choice
			 */
			do {
				/**
				 * Try catch for valid int input in scanner
				 */
				try {
					printMenu(gameboard, p, players);
					choice = scanner.nextInt();

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

						if (Confirmation.confirm(scanner)) {
							valid = true;
						}
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
		PostSelectionMenu.exitedGame = exitedGame;
	}

}