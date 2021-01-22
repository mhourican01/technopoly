/**
 *
 */
package run;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import player.Player;
import selectionMenu.Confirmation;
import square.CompValues;
import square.Computer;
import square.FieldNames;
import square.Square;

/**
 * @author User
 *
 */
public class ComputerManager implements Confirmation {

	/**
	 * subtracts square price from player balance
	 *
	 * @param p
	 * @param computerList
	 * @param ps
	 * @throws Exception
	 */
	public static void buyComputer(Scanner scanner, Player p, Computer c, ArrayList<Player> players,
			ArrayList<Computer> computerList) throws Exception {
		System.out.println(c.getField() + " " + c.getName() + " is an unowned model! It costs $" + c.getComputerPrice()
				+ " to buy the distribution rights. Do you want to buy these?");
		// if player has enough money to buy:
		if (p.getCurrentBalance() - c.getComputerPrice() > 0) {
			System.out.println(
					"Your purchase will leave you with $" + (p.getCurrentBalance() - c.getComputerPrice()) + ".");
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);

			// Confirm the purchase
			if (Confirmation.confirm(scanner)) {
				p.setCurrentBalance(p.getCurrentBalance() - c.getComputerPrice());
				c.setOwner(p.getPlayerName());
				System.out.println(p.getPlayerName() + ", you now own the " + c.getField() + " " + c.getName()
						+ " computer line!");
				TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
				p.computerMap.put(c.getName().getValue(), c);

				// Checks if player now has full field and changes the boolean if they do.
				switch (c.getField()) {
				case LENOVO:
					p.setLenovoOwner(computerList, p);
					break;
				case DELL:
					p.setDellOwner(computerList, p);
					break;
				case ASUS:
					p.setAsusOwner(computerList, p);
					break;
				case APPLE:
					p.setAppleOwner(computerList, p);
					break;
				}

			}
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			// display warning if they do not
		} else {
			System.out.println("This purchase will bankrupt you! You only have $" + p.getCurrentBalance() + "!");
			TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
			// confirm the purchase
			if (Confirmation.confirm(scanner)) {
				p.setCurrentBalance(p.getCurrentBalance() - c.getComputerPrice());
				c.setOwner(p.getPlayerName());
				EndGame.gameEnder(scanner, p, players);
			} else {

			}
		}
	}

	/**
	 * Method allows players to upgrade their squares, and changes the upgrade
	 * levels. Displays cost and current level. Timer based method will show
	 * incremental upgrading of the property for visual feedback of upgrade. Returns
	 * FieldName value to tell upgradeDisplayer which field was most recently
	 * updated.
	 * 
	 * @param scanner
	 * @param p
	 * @param c
	 * @param players
	 * @throws Exception
	 */
	public FieldNames buyUpgrade(Scanner scanner, Player p, Computer c, ArrayList<Player> players,
			ArrayList<Computer> computerList) throws Exception {
		FieldNames upgraded;
		// checks if system is below the threshold for basic upgrades
		if (c.getUpgradeLevel() < CompValues.UPLEVELMAX.getValue()) {
			// Check player has enough currency to buy upgrade
			if (p.getCurrentBalance() - c.getUpgradePrice() > 0) {
				if (c.getUpgradeLevel() < 3) {
					System.out.println("To upgrade the " + c.getField() + " " + c.getName() + "'s RAM will cost $"
							+ c.getUpgradePrice() + ".");
					TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
					// otherwise present advanced upgrade option
				} else {
					System.out.println("RAM is at maximum capacity. You can now upgrade the motherboard.");
					TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
					System.out.println("To upgrade the " + c.getField() + " " + c.getName()
							+ "'s Motherboard will cost $" + c.getUpgradePrice() + ".");
					TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);

				}
				// display remaining resources after purchase.
				System.out.println(
						"This purchase will leave you with $" + (p.getCurrentBalance() - c.getUpgradePrice()) + ".");
				// Confirm purchase
				if (Confirmation.confirm(scanner)) {
					p.setCurrentBalance(p.getCurrentBalance() - c.getUpgradePrice());
					c.setUpgradeLevel(c.getUpgradeLevel() + 1);
					// Upgrade system when at basic level.
					if (c.getUpgradeLevel() <= 3) {
						System.out.println(c.getField() + " " + c.getName() + "'s RAM is set to level "
								+ c.getUpgradeLevel() + ".");
						c.setSessionPrice(c.getSessionPrice() + c.getUpgradePrice());
						System.out.print("Ram upgrading 1 ");
						// Progressive upgrade bar.
						for (int timer = 0; timer <= 10; timer++) {
							System.out.print(">");
							TimeUnit.MILLISECONDS.sleep(Main.LOADERTIME);
						}
						System.out.println(" 100%!");
						System.out.println("RAM upgraded. This computer now costs $" + c.getSessionPrice() + ".");
						TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
						// Upgrade system for advanced upgrade
					} else {
						System.out.println(c.getField() + " " + c.getName()
								+ "'s Motherboard is being upgraded to level " + c.getUpgradeLevel() + ".");
						c.setSessionPrice(c.getSessionPrice() + c.getUpgradePrice());
						System.out.print("MotherBoard being replaced 1 ");
						// Progressive upgrade bar.
						for (int timer = 0; timer <= 10; timer++) {
							System.out.print(">");
							TimeUnit.MILLISECONDS.sleep(Main.LOADERTIME);
						}
						System.out.println(" 100%!");
						System.out
								.println("Motherboard upgraded. This computer now costs $" + c.getSessionPrice() + ".");
						TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);

					}
				}
				// if not display warning before purchase.
			} else {
				System.out.println("This purchase will bankrupt you! You only have $" + p.getCurrentBalance() + "!");
				TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);

				if (Confirmation.confirm(scanner)) {
					p.setCurrentBalance(p.getCurrentBalance() - c.getUpgradePrice());
					c.setOwner(p.getPlayerName());
					EndGame.gameEnder(scanner, p, players);
				}
			}
		}
		upgraded = c.getField();
		return upgraded;
	}

	/**
	 * Displays the upgrade options to the current player, triggered in the
	 * postSelection Menu if player owns at least one complete field.
	 * 
	 * @param scanner
	 * @param gameboard
	 * @param computerList
	 * @param p
	 * @param players
	 * @throws Exception
	 */
	public void upgradeDisplayer(Scanner scanner, ArrayList<Square> gameboard, ArrayList<Computer> computerList,
			Player p, ArrayList<Player> players) throws Exception {
		boolean compUpgraderValid = false;
		int upgradeSelection = 0;
		// Iterates until player has made a valid selection.
		do {
			// Ensures player inputs an int for choice selection
			try {
				// loopFinal
				int menuNumber = 1;
				// ArrayList stores the computers the player owns which can be upgraded.
				ArrayList<Computer> computersToUpgrade = new ArrayList<>();
				// Add computers to the array
				for (Computer c : p.computerMap.values()) {
					if (c.getUpgradeLevel() < 4) {
						if (p.isLenovoOwner()) {
							if (c.getField().equals(FieldNames.LENOVO)) {
								computersToUpgrade.add(c);
							}
						}
						if (p.isDellOwner()) {
							if (c.getField().equals(FieldNames.DELL)) {
								computersToUpgrade.add(c);
							}
						}
						if (p.isAsusOwner()) {
							if (c.getField().equals(FieldNames.ASUS)) {
								computersToUpgrade.add(c);
							}
						}
						if (p.isAppleOwner()) {
							if (c.getField().equals(FieldNames.APPLE)) {
								computersToUpgrade.add(c);
							}
						}
					}
				}

				// Display Options
				if (!computersToUpgrade.isEmpty()) {
					System.out.println("Which Computers would you like to upgrade?");
					for (Computer c : computersToUpgrade) {
						if (p.isLenovoOwner()) {
							if (c.getField().equals(FieldNames.LENOVO)) {
								System.out.println(
										menuNumber + ": " + c.getName() + " Upgrade Level: " + c.getUpgradeLevel());
								menuNumber++;
							}
						}
						if (p.isDellOwner()) {
							if (c.getField().equals(FieldNames.DELL)) {
								System.out.println(
										menuNumber + ": " + c.getName() + " Upgrade Level: " + c.getUpgradeLevel());
								menuNumber++;
							}
						}
						if (p.isAsusOwner()) {
							if (c.getField().equals(FieldNames.ASUS)) {
								System.out.println(
										menuNumber + ": " + c.getName() + " Upgrade Level: " + c.getUpgradeLevel());
								menuNumber++;
							}
						}
						if (p.isAppleOwner()) {
							if (c.getField().equals(FieldNames.APPLE)) {
								System.out.println(
										menuNumber + ": " + c.getName() + " Upgrade Level: " + c.getUpgradeLevel());
								menuNumber++;
							}
						}
					}
				} else {
					System.out.println(
							"All your computers are fully upgraded! All you have to do now is roll dice until your foes are driven to bankruptcy. ");
				}

				System.out.println((menuNumber) + ": Back");

				// Choose selection
				upgradeSelection = scanner.nextInt();

				// upgraded will determine which field was most recently upgraded, in order to
				// tell the system which message to output once the field is fully upgraded.
				FieldNames upgraded;
				// Can upgraded a property
				if (upgradeSelection > 0 && upgradeSelection < menuNumber) {
					upgraded = buyUpgrade(scanner, p, computersToUpgrade.get(upgradeSelection - 1), players,
							computerList);

					// Display completed field if all computers from the field have been upgraded
					int antiquesCounter, classicCounter, retroCounter, eliteCounter;
					antiquesCounter = 0;
					classicCounter = 0;
					retroCounter = 0;
					eliteCounter = 0;
					int[] counters = { antiquesCounter, classicCounter, retroCounter, eliteCounter };

					List<FieldNames> fields = new ArrayList<>();
					fields.add(FieldNames.LENOVO);
					fields.add(FieldNames.DELL);
					fields.add(FieldNames.ASUS);
					fields.add(FieldNames.APPLE);

					// Increase value of each field's counter when upgrade level is maxed to compare
					// against field size
					for (Computer c : computerList) {

						if (c.getUpgradeLevel() == 4 && c.getOwner().equals(p.getPlayerName())
								&& upgraded.equals(c.getField())) {
							for (int loop = 0; loop < fields.size(); loop++) {

								if (fields.get(loop).equals(c.getField())) {
									counters[loop]++;
								}
							}
						}

					}
					// If counter value == field size, display upgrade message
					for (int fieldLoop = 0; fieldLoop < fields.size(); fieldLoop++) {
						if (counters[fieldLoop] == fields.get(fieldLoop).getValue()) {
							System.out.println("You have fully upgraded the " + fields.get(fieldLoop)
									+ " models! Congratulations!!");

						}
					}

					// exit out of menu after upgrade
					compUpgraderValid = true;

					// invalid selection for upgraded
				} else if (upgradeSelection < 1 || upgradeSelection > menuNumber) {
					System.out.println("Invalid Selection, please try again");

					// selected back option
				} else {
					compUpgraderValid = true;
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again");
				scanner.nextLine();
				upgradeSelection = 0;

			}

		} while (!compUpgraderValid);

	}

	/**
	 * deduct rent from player on owned square and pay landlord
	 * 
	 * @throws Exception
	 */
	public static void paySessionPrice(Scanner scanner, Player player, ArrayList<Player> playerList,
			ArrayList<Computer> computerList, ArrayList<Square> gameboard) throws Exception {

		for (Computer computer : computerList) {
			if (gameboard.indexOf(computer) == player.getCurrentLocation()) {
				for (Player owner : playerList) {
					// determine who owns the square and transfer currency from player to owner
					if (owner.getPlayerName() == computer.getOwner()) {
						player.setCurrentBalance(player.getCurrentBalance() - computer.getSessionPrice());
						System.out.println("$" + computer.getSessionPrice() + " deducted from " + player.getPlayerName()
								+ ". " + player.getPlayerName() + "'s new balance is $" + player.getCurrentBalance()
								+ ".");
						TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
						owner.setCurrentBalance(owner.getCurrentBalance() + computer.getSessionPrice());
						System.out.println("$" + computer.getSessionPrice() + " paid to " + owner.getPlayerName() + ". "
								+ owner.getPlayerName() + "'s new balance is $" + owner.getCurrentBalance() + ".");
						TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
						// trigger endGame if player reaches <1 balance.
						if (player.getCurrentBalance() < 1) {
							EndGame.gameEnder(scanner, player, playerList);
						}
					}
				}
			}
		}
	}

}