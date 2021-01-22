/**
 *
 */
package run;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

import selectionMenu.*;
import player.*;
import square.*;

/**
 * @author 40130998
 *
 */
public class Main implements Confirmation {

	/**
	 * Game arrayLists
	 *
	 * @param args
	 */
	public static ArrayList<Square> gameboard = new ArrayList<>();
	public static ArrayList<Computer> computerList = new ArrayList<>();
	public static ArrayList<Player> playerArray = new ArrayList<>();

	/**
	 * Constants for board generation and timers
	 */
	public final static int NO_OF_COMPUTERS = 10;
	public final static int LOADERTIME = 200;
	public final static int TEXTPAUSE = 1000;
	public final static int TEXTSPEED = 3;
	/**
	 * Booleans for running and exiting game.
	 */
	public static boolean running = true;
	public static boolean exitGame = false;
	/**
	 * Main code execution method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Clear Arrays if new game started after previous one finishes
		gameboard.clear();
		computerList.clear();
		playerArray.clear();

		// Generate the board
		computerList = Computer.generateComputerArray(NO_OF_COMPUTERS);
		gameboard = Computer.generateGameBoard(computerList, NO_OF_COMPUTERS);

		// New game message generation
		System.out.println(
				" .----------------.  .----------------.  .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .----------------.  .----------------. ");
		System.out.println(
				"| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |");
		System.out.println(
				"| |  _________   | || |  _________   | || |     ______   | || |  ____  ____  | || | ____  _____  | || |     ____     | || |   ______     | || |     ____     | || |   _____      | || |  ____  ____  | |");
		System.out.println(
				"| | |  _   _  |  | || | |_   ___  |  | || |   .' ___  |  | || | |_   ||   _| | || ||_   \\|_   _| | || |   .'    `.   | || |  |_   __ \\   | || |   .'    `.   | || |  |_   _|     | || | |_  _||_  _| | |");
		System.out.println(
				"| | |_/ | | \\_|  | || |   | |_  \\_|  | || |  / .'   \\_|  | || |   | |__| |   | || |  |   \\ | |   | || |  /  .--.  \\  | || |    | |__) |  | || |  /  .--.  \\  | || |    | |       | || |   \\ \\  / /   | |");
		System.out.println(
				"| |     | |      | || |   |  _|  _   | || |  | |         | || |   |  __  |   | || |  | |\\ \\| |   | || |  | |    | |  | || |    |  ___/   | || |  | |    | |  | || |    | |   _   | || |    \\ \\/ /    | |");
		System.out.println(
				"| |    _| |_     | || |  _| |___/ |  | || |  \\ `.___.'\\  | || |  _| |  | |_  | || | _| |_\\   |_  | || |  \\  `--'  /  | || |   _| |_      | || |  \\  `--'  /  | || |   _| |__/ |  | || |    _|  |_    | |");
		System.out.println(
				"| |   |_____|    | || | |_________|  | || |   `._____.'  | || | |____||____| | || ||_____|\\____| | || |   `.____.'   | || |  |_____|     | || |   `.____.'   | || |  |________|  | || |   |______|   | |");
		System.out.println(
				"| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |");
		System.out.println(
				"| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |");
		System.out.println(
				" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ");
		System.out.println(
				"                                                                      Copyright 2019, Group 16 Industries. All rights reserved. \n");
		System.out.println(
				"Welcome to Technopoly, a cutthroat world of business and technology where YOU can become the greatest Technology Tycoon in the world...if you're smart enough! \n");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"You begin this game with $8000, and will receive another $400 every time you pass the GO square.");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"This ostentatious wealth can be used to purchase and upgrade types of Computer Products with which you can make your fortune!");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"These Computers are represented by the various squares on the game board, and each one specialises in a specific type of computer.");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"As you travel across the board by rolling dice, you can purchase the production rights to these computers.");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"If another player lands on that square, they will purchase a computer of that type, and be forced to pay you! God bless capitalism!");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"Each type of computer is part of a brand, such as Dell or Apple. If you own the production rights to all computers within a field, you own the company, and can start upgrading!");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"You can upgrade a computer's RAM three times, and upgrade it's Processor once. Be warned: you can only upgrade the processor once you have three RAM upgrades!");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"The more you upgrade a computer, the more it will cost when another player lands on it. Use this to set your friends on a fast track for bankrupcy! It's profitable AND fun!");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"On your turn, you can use the number keys on your keyboard to choose what to do on your turn, from rolling dice to move, to buying and upgrading computers.");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"Through this innovative and high-tech interface, we handle all the difficult sums, and you can focus on the important stuff: leaving your friends penniless and destitute! Hooray!");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println(
				"The game ends either when a player ends it manually on their turn, or when one player runs out of money.");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println("In either case, the player(s) with the most money are the winner! \n");
		TimeUnit.SECONDS.sleep(TEXTSPEED);
		System.out.println("Now, enough chitchat. Let's get down to business! CAPITALISM HO! \n");
		TimeUnit.SECONDS.sleep(TEXTSPEED);

		try (Scanner scanner = new Scanner(System.in);) {

			ArrayList<Player> players = Player.enterNames(scanner, playerArray);

			PreSelectionMenu preMenu = new PreSelectionMenu();

			PostSelectionMenu postMenu = new PostSelectionMenu();

			System.out.println(
					"Each player begins on " + SquareNames.GO + " with $" + Player.getPlayer_Resources() + ".");
			System.out.println();

			/**
			 * Main game run thread
			 */
			while (running) {
				for (Player p : players) {
					if (!exitGame) {
						System.out.println();
						System.out.println(p.getPlayerName() + ", it is your turn!");
						// display selection menu to player
						preMenu.chooseOption(scanner, gameboard, computerList, p, players);
						if (!exitGame) {
							postMenu.chooseOption(scanner, gameboard, computerList, p, players);
						}

					} else {
						running = false;
						break;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Thanks for playing!");

		}
	}

}