/**
 *
 */
package square;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;
import java.util.List;

import player.Player;
import run.Main;

/**
 * Class holds information about computer squares and arraylist for these.
 * 
 * @author Brendan
 *
 */
public class Computer extends Square {
	// Computer Array
	public static ArrayList<Square> gameboard = new ArrayList<Square>();
	// Creating an Array of Square Names
	public static List<SquareNames> squareNames = Arrays.asList(SquareNames.values());

	// Instance Variables

	private String owner;
	private int computerPrice;
	private int sessionPrice;
	private int upgradePrice;
	private int upgradeLevel = 0;
	private FieldNames field;

	// Constructors
	/**
	 * Default Constructors
	 */
	public Computer() {
	}

	/**
	 * Constructor with Arguments
	 * 
	 * @param name
	 * @param owner
	 * @param computerPrice
	 * @param sessionPrice
	 * @param upgradePrice
	 * @param upgradeLevel
	 * @param field
	 * @throws Exception
	 */
	public Computer(SquareNames name, String owner, int computerPrice, int sessionPrice, int upgradePrice,
			int upgradeLevel, FieldNames field) throws Exception {
		super(name);
		this.setComputerPrice(computerPrice);
		this.setSessionPrice(sessionPrice);
		this.setUpgradePrice(upgradePrice);
		this.setUpgradeLevel(upgradeLevel);
		this.setField(field);
		this.setOwner(owner);

	}
	// Methods

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param Player the owner to set
	 */
	public void setOwner(String Player) {
		this.owner = Player;
	}

	/**
	 * @return the computerPrice
	 */
	public int getComputerPrice() {
		return computerPrice;
	}

	/**
	 * @param computerPrice the computerPrice to set
	 * @throws Exception
	 */
	public void setComputerPrice(int computerPrice) throws Exception {
		if (computerPrice >= CompValues.COMPPRICEMIN.getValue()
				&& computerPrice <= CompValues.COMPPRICEMAX.getValue()) {
			this.computerPrice = computerPrice;
		} else {
			throw new Exception("Computer Price Assignment Error");
		}

	}

	/**
	 * @return the SessionPrice
	 */
	public int getSessionPrice() {
		return sessionPrice;
	}

	/**
	 * @param sessionPrice the sessionPrice to set
	 */
	public void setSessionPrice(int sessionPrice) throws Exception {
		if (sessionPrice >= CompValues.SESSPRICEMIN.getValue() && sessionPrice <= CompValues.SESSPRICEMAX.getValue()) {
			this.sessionPrice = sessionPrice;
		} else {
			throw new Exception("Session Price Assignment Error");
		}
	}

	/**
	 * @return the upgradePrice
	 */
	public int getUpgradePrice() {
		return upgradePrice;
	}

	/**
	 * @param upgradePrice the upgradePrice to set
	 */
	public void setUpgradePrice(int upgradePrice) throws Exception {
		if (upgradePrice >= CompValues.UPPRICEMIN.getValue() && upgradePrice <= CompValues.UPPRICEMAX.getValue()) {
			this.upgradePrice = upgradePrice;
		} else {
			throw new Exception();
		}
	}

	/**
	 * @return the upgradeLevel
	 */
	public int getUpgradeLevel() {
		return upgradeLevel;
	}

	/**
	 * @param upgradeLevel the upgradeLevel to set
	 */
	public void setUpgradeLevel(int upgradeLevel) throws Exception {
		if (upgradeLevel >= CompValues.UPLEVELMIN.getValue() && upgradeLevel <= CompValues.UPLEVELMAX.getValue()) {
			this.upgradeLevel = upgradeLevel;
		} else {
			throw new Exception("Upgrade Assignment Error");
		}
	}

	/**
	 * @return the field
	 */
	public FieldNames getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 * @throws Exception
	 */
	public void setField(FieldNames field) throws Exception {
		this.field = field;

	}

	/**
	 * Method to display the attributes of a Square including reference to its
	 * current occupants.
	 */
	@Override
	public void displaySquare(ArrayList<Player> players) throws Exception {

		super.displaySquare(players);
		if (getOwner() != null) {
			System.out.println("Computer Owner : \t\t\t" + getOwner());
		} else {
			System.out.println("Computer Owner : \t\t\t" + "Unowned");
		}
		System.out.println("Computer Price : \t\t\t" + getComputerPrice());
		System.out.println("Computer Session Price : \t\t" + getSessionPrice());
		System.out.println("Computer Upgrade Price : \t\t" + getUpgradePrice());
		System.out.println("Computer Current Upgrade Level : \t" + getUpgradeLevel());
		System.out.println("Computer Type: \t\t\t\t" + getField());

	}

	/**
	 * Method to Generate a copy of the gameboard from a pre-existing
	 * ArrayList<Computer>.
	 * 
	 * @param computerList
	 * @param numberOfSquares
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Square> generateGameBoard(ArrayList<Computer> computerList, int numberOfSquares)
			throws Exception {

		int index2 = 0;
		ArrayList<Square> gameboard = new ArrayList<Square>();
		List<SquareNames> list = Arrays.asList(SquareNames.values());

		// Iterators setting the ascending price of squares.
		for (int index = 0; index < numberOfSquares + 2; index++) {
			if (index == 0) {
				gameboard.add(new Go(list.get(index), Go.getPASS_GO_PAY()));
				gameboard.get(index).setName(SquareNames.GO);
			} else if (index == ((numberOfSquares / 2) + 1)) {
				gameboard.add(new FreeSession(list.get(index)));
				gameboard.get(index).setName(SquareNames.FREE_SESSION);
			} else {
				gameboard.add(computerList.get(index2++));
			}

		}

		return gameboard;
	}

	/**
	 * Method to generate an Array of Computers
	 * 
	 * @param numberOfSquares
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Computer> generateComputerArray(int numberOfSquares) throws Exception {
		// Local Vars
		ArrayList<Computer> computerList = new ArrayList<>();
		int field1 = 0;
		int field2 = 0;
		int field3 = 0;
		int field4 = 0;

		int compPriceTemp = CompValues.COMPPRICEMIN.getValue();
		int compPriceMod = ((CompValues.COMPPRICEMAX.getValue() - CompValues.COMPPRICEMIN.getValue())
				/ (numberOfSquares - 1));

		int sessPriceTemp = CompValues.SESSPRICEMIN.getValue();
		int sessPriceMod = ((CompValues.SESSPRICEINIT.getValue() - CompValues.SESSPRICEMIN.getValue())
				/ (numberOfSquares - 1));

		int upPriceTemp = CompValues.UPPRICEMIN.getValue();
		int upPriceMod = ((CompValues.UPPRICEMAX.getValue() - CompValues.UPPRICEMIN.getValue())
				/ (numberOfSquares - 1));

		List<SquareNames> list = Arrays.asList(SquareNames.values());
		// Iterators setting the ascending price of squares.
		for (int index = 0; index < numberOfSquares; index++) {
			FieldNames fieldName = null;
			if (field1 < CompValues.FIELD1LIMIT.getValue()) {
				fieldName = FieldNames.LENOVO;
				field1++;
			} else if (field2 < CompValues.FIELD2LIMIT.getValue()) {
				fieldName = FieldNames.DELL;
				field2++;
			} else if (field3 < CompValues.FIELD3LIMIT.getValue()) {
				fieldName = FieldNames.ASUS;
				field3++;
			} else if (field4 < CompValues.FIELD4LIMIT.getValue()) {
				fieldName = FieldNames.APPLE;
				field4++;
			}

			if (index != 0 || index != ((numberOfSquares / 2) - 1)) {
				computerList.add(new Computer(list.get(index), null, compPriceTemp, sessPriceTemp, upPriceTemp,
						CompValues.UPLEVELMIN.getValue(), fieldName));
				compPriceTemp += compPriceMod;
				sessPriceTemp += sessPriceMod;
				upPriceTemp += upPriceMod;
			} else {
				computerList.add(index, null);
			}

		}
		return computerList;
	}

	/**
	 * Method to display the an ArrayList<Square>
	 * 
	 * @param computerList
	 * @param players
	 * @throws Exception
	 */
	public static void displayBoard(ArrayList<Computer> computerList, ArrayList<Player> players) throws Exception {

		ArrayList<Square> gameboard = Computer.castToGameboard(computerList);
		Iterator<Square> displayBoard = gameboard.iterator();
		while (displayBoard.hasNext()) {
			displayBoard.next().displaySquare(players);
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.println();
		}
	}

	/**
	 * Method to Cast Computers to an ArrayList<Square>
	 * 
	 * @param computerList
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<Square> castToGameboard(ArrayList<Computer> computerList) throws Exception {
		ArrayList<Square> gameboard = new ArrayList<>();

		gameboard = generateGameBoard(computerList, Main.NO_OF_COMPUTERS);

		return gameboard;
	}

}