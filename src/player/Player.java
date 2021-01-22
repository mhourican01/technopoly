/**
 *
 */
package player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import selectionMenu.Confirmation;
import square.Computer;
import square.FieldNames;

/**
 * @author Brendan & Cormac
 *
 */
public class Player implements Confirmation {

	// Instance Vars
	private String playerName;
	private int currentBalance;
	private int currentLocation;
	private boolean lenovoOwner = false;
	private boolean dellOwner = false;
	private boolean asusOwner = false;
	private boolean appleOwner = false;

	// Constants
	private static final int MAX_PLAYERS = 4;
	private static final int MIN_PLAYERS = 2;
	protected static final int BASE_RESOURCES = 8000;

	// public ArrayList<Computer> computersOwned = new ArrayList<>();
	public Map<Integer, Computer> computerMap = new TreeMap<>();

	// Constructors
	/**
	 * Default Constructor
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param playerName
	 * @param currentBalance
	 * @param currentLocation
	 * @param fieldsOwned
	 * @param lenovoOwner
	 * @param dellOwner
	 * @param asusOwner
	 * @param appleOwner
	 */
	public Player(String playerName, int currentBalance, int currentLocation) {
		super();
		this.playerName = playerName;
		this.currentBalance = currentBalance;
		this.currentLocation = currentLocation;
	}

	/**
	 * Getter to display BASE_RESOURCES in Main method
	 */
	public static int getPlayer_Resources() {
		return BASE_RESOURCES;
	}

	// Methods
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the currentBalance
	 */
	public int getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;

	}

	/**
	 * @return the currentLocation
	 */
	public int getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(int currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * returns whether player owns Lenovo field
	 * 
	 * @return
	 */
	public boolean isLenovoOwner() {
		return lenovoOwner;
	}

	/**
	 * Sets Lenovo boolean to true if player owns whole field
	 * 
	 * @param computerList
	 * @param p
	 */
	public void setLenovoOwner(ArrayList<Computer> computerList, Player p) {
		ArrayList<Computer> lenovoComputers = new ArrayList<>();
		for (Computer computer : computerList) {
			try {
				if (computer.getField().equals(FieldNames.LENOVO) && computer.getOwner().equals(p.getPlayerName())) {
					lenovoComputers.add(computer);
				}
			} catch (Exception e) {

			}

		}
		if ((lenovoComputers.size()) == FieldNames.LENOVO.getValue()) {
			this.lenovoOwner = true;
			System.out.println("You own the majority share in " + FieldNames.LENOVO + "!");
		} else {
			System.out.println("You have rights to sell " + lenovoComputers.size() + " of the "
					+ FieldNames.LENOVO.getValue() + " " + FieldNames.LENOVO + " models!");
		}
	}

	/**
	 * returns whether player owns Dell field
	 * 
	 * @return
	 */
	public boolean isDellOwner() {
		return dellOwner;
	}

	/**
	 * Sets Dell boolean to true if player owns whole field
	 * 
	 * @param computerList
	 * @param p
	 */
	public void setDellOwner(ArrayList<Computer> computerList, Player p) {
		
		ArrayList<Computer> dellComputers = new ArrayList<>();
		
		for (Computer computer : computerList) {
			try {
				if (computer.getField().equals(FieldNames.DELL) && computer.getOwner().equals(p.getPlayerName())) {
					dellComputers.add(computer);
				}
			} catch (Exception e) {
				
			}
		}
		if ((dellComputers.size()) == FieldNames.DELL.getValue()) {
			this.dellOwner = true;
			System.out.println("You own the majority share in " + FieldNames.DELL + "!");
		} else {
			System.out.println("You have rights to sell " + dellComputers.size() + " of the "
					+ FieldNames.DELL.getValue() + " " + FieldNames.DELL + " models!");
		}

	}

	/**
	 * returns whether player owns Asus field
	 * 
	 * @return
	 */
	public boolean isAsusOwner() {
		return asusOwner;
	}

	/**
	 * Sets Asus boolean to true if player owns whole field
	 * 
	 * @param computerList
	 * @param p
	 */
	public void setAsusOwner(ArrayList<Computer> computerList, Player p) {
		
		ArrayList<Computer> asusComputers = new ArrayList<>();

		for (Computer computer : computerList) {
			try {
				if (computer.getField().equals(FieldNames.ASUS) && computer.getOwner().equals(p.getPlayerName())) {
					asusComputers.add(computer);
				}
			} catch (Exception e) {

			}
		}
		if ((asusComputers.size()) == FieldNames.ASUS.getValue()) {
			this.asusOwner = true;
			System.out.println("You own the majority share in " + FieldNames.ASUS + "!");
		} else {
			System.out.println("You have rights to sell " + asusComputers.size() + " of the "
					+ FieldNames.ASUS.getValue() + " " + FieldNames.ASUS + " models!");
		}
	}

	/**
	 * returns whether player owns Apple field
	 * 
	 * @return
	 */
	public boolean isAppleOwner() {
		return appleOwner;
	}

	/**
	 * Sets Apple boolean to true if player owns whole field
	 * 
	 * @param computerList
	 * @param p
	 */
	public void setAppleOwner(ArrayList<Computer> computerList, Player p) {
		
		ArrayList<Computer> appleComputers = new ArrayList<>();
		
		for (Computer computer : computerList) {
			try {
				if (computer.getField().equals(FieldNames.APPLE) && computer.getOwner().equals(p.getPlayerName())) {
					appleComputers.add(computer);
				}
			} catch (Exception e) {

			}

		}
		if ((appleComputers.size()) == FieldNames.APPLE.getValue()) {
			this.appleOwner = true;
			System.out.println("You own the majority share in " + FieldNames.APPLE + "!");
		} else {
			System.out.println("You have rights to sell " + appleComputers.size() + " of the "
					+ FieldNames.APPLE.getValue() + " " + FieldNames.APPLE + " models!");
		}

	}

	/**
	 * Generates the player array at the start of the game, using values from
	 * enterNames
	 * 
	 * @param playerArray
	 * @param names
	 * @return
	 */
	public static ArrayList<Player> generatePlayerArray(ArrayList<Player> playerArray, ArrayList<String> names) {
		
		for (int loop = 0; loop < names.size(); loop++) {
			playerArray.add(new Player(names.get(loop), BASE_RESOURCES, 0));
		}
		return playerArray;

	}

	/**
	 * Sets player numbers and stores names into an arrayList to pass onto
	 * generatePlayerArray
	 * 
	 * @param scanner
	 * @param playerArray
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Player> enterNames(Scanner scanner, ArrayList<Player> playerArray) throws Exception {

		List<String> names = new ArrayList<>();
		boolean exitEnterNames = false;
		// iterates until players confirm names are correct.
		do {
			names.clear();
			// checks that number of players is correctly input as an int.
			try {
				System.out.println("How many players wish to play?");

				int noOfPlayers = scanner.nextInt();

				// checks that number of players is within constants set. Can be changed by
				// modifying those constants to allow more or less players.
				if (noOfPlayers >= MIN_PLAYERS && noOfPlayers <= MAX_PLAYERS) {
					String[] playerNames = new String[noOfPlayers];
					scanner.nextLine();
					int playerNumber = 0;
					boolean errorName = false;
					for (int loop = 0; loop < playerNames.length; loop++) {

						playerNumber++;
						do {
							System.out.printf("Please enter name of player %d :\n", playerNumber);

							String playerName = scanner.next();
							// Prevents players from using the same name.
							if (names.contains(playerName)) {
								System.out.println("Player name already in use, please select another.");
								errorName = true;
								scanner.nextLine();
							} else if (playerName.length() < 21 && playerName.length() > 1) {
								names.add(playerName);
								errorName = false;
							} else {
								System.out.println(
										"Name length invalid, your name must be more than 1 and less than 21 characters to play. ");
								errorName = true;
								scanner.nextLine();
							}
						} while (errorName);
						scanner.nextLine();

					}

					playerArray = generatePlayerArray(playerArray, (ArrayList<String>) names);

					System.out.println("Your names are:");
					Iterator<Player> playerConfirmer = playerArray.iterator();
					while (playerConfirmer.hasNext()) {
						System.out.println(playerConfirmer.next().getPlayerName());
					}
					// confirms the players are happy with the selected names.
					if (Confirmation.confirm(scanner)) {
						exitEnterNames = true;
						return playerArray;
					} else {
						playerArray.clear();
					}
				} else {
					System.out.println("Invalid player number, please try again.");

				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again.");
				scanner.nextLine();
			}
		} while (!exitEnterNames);
		return playerArray;
	}
}