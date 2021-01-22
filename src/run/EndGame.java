package run;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

import player.Player;
import selectionMenu.PostSelectionMenu;
import selectionMenu.PreSelectionMenu;

/**
 * @author Cormac This class holds all methods relating to ending the game,
 *         either through exiting manually or one player going below 0 on their
 *         balance
 *
 */
public class EndGame {

	/**
	 * This method begins the process of ending the game
	 * 
	 * @param player
	 * @param players
	 * @return
	 * @throws Exception
	 */
	public static void gameEnder(Scanner scanner, Player player, ArrayList<Player> players) throws Exception {
		try {

			// determining whether or not the player has manually exited the game
			if (PreSelectionMenu.isExitedGame() == true || PostSelectionMenu.isExitedGame() == true) {
				System.out.println(player.getPlayerName() + " took the coward's way out. Game Over!");
				TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			} else {
				System.out.println(player.getPlayerName() + " has gone bankrupt. Game Over!");
				TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			}

			// calling a method to determine the winner of the game and print the result to
			// screen
			determineWinner(players, player);

			System.out.println(
					"Sadly, all good things must come to an end. And so this game of Technopoly draws to a close.");
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			System.out.println(
					"But, just for you, I'm willing to let you take another ride on the Technopoly rollercoaster. Do you want to play again?");
			System.out.println("1. Yes");
			System.out.println("2. No");

			// the player choosing whether or not they wish to play the game again
			int restartGameChoice;
			boolean valid = false;
			do {
				try {
					restartGameChoice = scanner.nextInt();
					switch (restartGameChoice) {
					case 1:
						System.out.println("As you wish! The Cosmic Ballet goes on!");
						Main.main(null);
						valid = true;
						break;
					case 2:
						System.out.println("As you wish. Until we meet again, my friends!");
						valid = true;
						Main.exitGame = true;
						break;
					default:
						System.out.println("Invalid selection, try again");
						valid = false;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid input, please try again.");
					scanner.next();
				}
			} while (!valid);

		} catch (Exception e) {
			System.out.println("yahooo");
		}

	}

	/**
	 * This method determines the winner of the game, or whether or not there was a
	 * draw, and prints the result to screen
	 * 
	 * @param players
	 */
	public static void determineWinner(ArrayList<Player> players, Player p) {
		try {
			int highestBalance = 0;
			String winner = "";
			boolean draw = false;
			for (Player player : players) {
				if (!player.equals(p)) {
					if (player.getCurrentBalance() > highestBalance) {
						highestBalance = player.getCurrentBalance();
						winner = player.getPlayerName();
					} else if (player.getCurrentBalance() == highestBalance) {
						draw = true;
					}
				}
			}
			if (draw == true) {
				TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
				System.out.println(
						"The game has ended as a draw, with the following players sharing the wealth and glories of victory! "
								+ "Truly, the real Technopoly was friendship all along.");
				for (Player player : players) {
					if (!player.equals(p)) {
						if (player.getCurrentBalance() == highestBalance) {
							System.out.println(player.getPlayerName());
						}
					}
				}

				System.out.println();
				TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			} else {
				System.out.println(
						"Congratulations, " + winner + ", you have won the game with an astonishing $" + highestBalance
								+ " in the bank! You may lord this victory over your friends for the rest of time.");
				System.out.println();
				TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			}

			System.out.println("Final Rankings: ");
			// Ranking Message for exitedGame scenario
			if (PreSelectionMenu.isExitedGame() == true || PostSelectionMenu.isExitedGame() == true) {

				for (Player player : players) {
					if (!player.equals(p)) {

						System.out.println(player.getPlayerName() + " ended the game with $"
								+ player.getCurrentBalance() + " in their account.");
					} else {
						System.out.println(player.getPlayerName() + " ended the game with $"
								+ player.getCurrentBalance()
								+ " in their account. However, for their cowardice, they shall not be eligible to WIN!");
					}
				}
			}
			// Ranking message for bankruptcy scenario
			else {
				for (Player player : players) {
					if (!player.equals(p)) {
						System.out.println(player.getPlayerName() + " ended the game with $"
								+ player.getCurrentBalance() + " in their account. ");
					} else {
						System.out.println(player.getPlayerName() + " ended the game with $"
								+ player.getCurrentBalance()
								+ " in their account, making them the least ruthless capitalist. Which is, I suppose, perhaps the greatest victory of all.");
					}
				}

			}
			System.out.println();
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
		} catch (Exception e) {

		}
	}
}