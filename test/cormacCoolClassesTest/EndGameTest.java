package cormacCoolClassesTest;



import java.util.ArrayList;
import java.util.InputMismatchException;


import org.junit.Before;
import org.junit.Test;

import player.Player;
import run.EndGame;
import run.Main;

public class EndGameTest extends EndGame {

	/**
	 * Test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Testing the ExitGame method to ensure code viability
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGameEnderExitGame() throws Exception {

		// Test Data
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", 5, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 600, 0);

		ArrayList<Player> players = new ArrayList<>();

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		boolean exitedGame = true;

		// Methods
		if (exitedGame == true) {
			System.out.println(player1.getPlayerName() + " took the coward's way out. Game Over!");
		} else {
			System.out.println(player1.getPlayerName() + " has gone bankrupt. Game Over!");
		}
		determineWinner(players, player1);

		System.out.println(
				"Sadly, all good things must come to an end. And so this game of Technopoly draws to a close.");
		System.out.println(
				"But, just for you, I'm willing to let you take another ride on the Technopoly rollercoaster. Do you want to play again?");
		System.out.println("Please make your selection: ");
		System.out.println("1. Yes");
		System.out.println("2. No");

		int restartGameChoice = 2;
		boolean valid = false;
		do {
			try {
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
			}
		} while (!valid);
	}

	/**
	 * Testing the
	 */
	@Test
	public void testGameEnderBankrupcy() {

		// Test Data
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", -50, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 600, 0);

		ArrayList<Player> players = new ArrayList<>();

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		// Methods
		determineWinner(players, player4);

		boolean exitedGame = false;

		if (exitedGame == true) {
			System.out.println(player1.getPlayerName() + " took the coward's way out. Game Over!");
		} else {
			System.out.println(player1.getPlayerName() + " has gone bankrupt. Game Over!");
		}
		determineWinner(players, player1);

		System.out.println(
				"Sadly, all good things must come to an end. And so this game of Technopoly draws to a close.");
		System.out.println(
				"But, just for you, I'm willing to let you take another ride on the Technopoly rollercoaster. Do you want to play again?");
		System.out.println("Please make your selection: ");
		System.out.println("1. Yes");
		System.out.println("2. No");

		int restartGameChoice = 2;
		boolean valid = false;
		do {
			try {
				switch (restartGameChoice) {
				case 1:
					System.out.println("As you wish! The Cosmic Ballet goes on!");
					// startGame();
					valid = true;
					break;
				case 2:
					System.out.println("As you wish. Until we meet again, my friends!");
					valid = true;
					break;
				default:
					System.out.println("Invalid selection, try again");
					valid = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again.");
			}
		} while (!valid);

	}

	/**
	 * Testing the functionality of the Determine Winner Method
	 */
	@Test
	public void testDetermineWinner() {
		// Test Data
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", 5, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 600, 0);

		ArrayList<Player> players = new ArrayList<>();

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		// Methods
		determineWinner(players, player1);

	}

	@Test
	public void testDrawDetermineWinner() {
		// Test Data
		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", 500, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 500, 0);

		ArrayList<Player> players = new ArrayList<>();

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		// Methods
		determineWinner(players, player1);

	}

}