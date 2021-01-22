package player;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import player.Player;
import square.Computer;

public class TestPlayer {

	// Test Data

	// ComputerList

	// Name
	private String validName1 = "validName1";
	private String validName2 = "validName2";
	private String validName3 = "validName3";

	// Current Balance
	private int validCurrentBalanceMid = 100;

	// Current Location
	private int validCurrentLocation = 10;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Constructor with arguments test
	 */
	@Test
	public void testPlayerStringIntInt() {
		Player player = new Player(validName1, validCurrentBalanceMid, validCurrentLocation);
		assertEquals(validName1, player.getPlayerName());
		assertEquals(validCurrentBalanceMid, player.getCurrentBalance());
		assertEquals(validCurrentLocation, player.getCurrentLocation());
	}

	/**
	 * Testing the Get Player Resource Method
	 */
	@Test
	public void testGetPlayer_Resources() {
		assertEquals(Player.BASE_RESOURCES, Player.getPlayer_Resources());
	}

	/**
	 * Testing the Getter & Setter for Player Name
	 */
	@Test
	public void testGetSetPlayerName() {
		Player player = new Player();
		player.setPlayerName(validName2);
		assertEquals(validName2, player.getPlayerName());
	}

	/**
	 * Testing the Getter & Setter for Current Balance
	 */
	@Test
	public void testGetSetCurrentBalance() {
		Player player = new Player();
		player.setCurrentBalance(validCurrentBalanceMid);
		assertEquals(validCurrentBalanceMid, player.getCurrentBalance());
	}

	/**
	 * Testing the Getter & Setter for Current Location
	 */
	@Test
	public void testGetSetCurrentLocation() {
		Player player = new Player();
		player.setCurrentLocation(validCurrentLocation);
		assertEquals(validCurrentLocation, player.getCurrentLocation());
	}

	/**
	 * Testing the default setting for LENOVO
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFalseIsSetLenovoOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setLenovoOwner(computerList, player);
		assertEquals(false, player.isLenovoOwner());
	}

	/**
	 * Test for returning a True value in LENOVO
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTrueIsSetLenovoOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setPlayerName(validName3);
		Iterator<Computer> setter = computerList.iterator();
		while (setter.hasNext()) {
			setter.next().setOwner(player.getPlayerName());
		}
		player.setLenovoOwner(computerList, player);
		assertEquals(true, player.isLenovoOwner());
	}

	/**
	 * Testing the default setting for DELL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFalseIsSetDellOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setDellOwner(computerList, player);
		assertEquals(false, player.isDellOwner());
	}

	/**
	 * Test for returning a True value in DELL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTrueIsSetClassicOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setPlayerName(validName3);
		Iterator<Computer> setter = computerList.iterator();
		while (setter.hasNext()) {
			setter.next().setOwner(player.getPlayerName());
		}
		player.setDellOwner(computerList, player);
		assertEquals(true, player.isDellOwner());
	}

	/**
	 * Testing the default setting for ASUS
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFalseIsSetRetroOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setAsusOwner(computerList, player);
		assertEquals(false, player.isAsusOwner());
	}

	/**
	 * Test for returning a True value in ASUS
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTrueIsSetRetroOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setPlayerName(validName3);
		Iterator<Computer> setter = computerList.iterator();
		while (setter.hasNext()) {
			setter.next().setOwner(player.getPlayerName());
		}
		player.setAsusOwner(computerList, player);
		assertEquals(true, player.isAsusOwner());
	}

	/**
	 * Testing the default setting for APPLE
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFalseIsSetEliteOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setAppleOwner(computerList, player);
		assertEquals(false, player.isAppleOwner());
	}

	/**
	 * Test for returning a True value in APPLE
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTrueIsSetEliteOwner() throws Exception {
		ArrayList<Computer> computerList = Computer.generateComputerArray(10);
		Player player = new Player();
		player.setPlayerName(validName3);
		Iterator<Computer> setter = computerList.iterator();
		while (setter.hasNext()) {
			setter.next().setOwner(player.getPlayerName());
		}
		player.setAppleOwner(computerList, player);
		assertEquals(true, player.isAppleOwner());
	}

	/**
	 * Tested with 1-4 and 0 & 5 players All successfully passed.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testEnterNamesContainingGeneratePlayerArray() throws Exception {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Player> players = new ArrayList<>();
		System.out.println("Please Enter 4 Names!");
		Player.enterNames(scanner, players);
		scanner.close();
		assertEquals(4, players.size());
	}

}
