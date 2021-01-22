package cormacCoolClassesTest;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import run.PlayerLocationUpdater;
import square.Computer;

import square.Square;
import player.Player;

public class UpdatePlayerLocationTest {

	/**
	 * Test Data
	 */
	int currentPlayer;

	@Before
	public void setUp() {
	}

	/**
	 * Testing the functionality of player location updater
	 */
	@Test
	public void testPlayerLocationUpdater() {

		ArrayList<Square> gameboard = new ArrayList<>();
		ArrayList<Computer> computerList = new ArrayList<>();

		Player player1 = new Player("Cormac", 1, 0);
		Player player2 = new Player("Jona", 5, 0);
		Player player3 = new Player("Michael", 500, 0);
		Player player4 = new Player("Brendan", 600, 0);

		ArrayList<Player> players = new ArrayList<>();

		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);

		try {
			computerList = Computer.generateComputerArray(10);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			gameboard = Computer.generateGameBoard(computerList, 10);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Scanner scanner = null;
		try {
			PlayerLocationUpdater.updatePlayerLocation(scanner, player1, gameboard, computerList, players);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
