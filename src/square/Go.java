/**
 * 
 */
package square;

import java.util.concurrent.TimeUnit;

import player.Player;
import run.Main;

/**
 * @author Brendan
 *
 */
public class Go extends Square {

	// Instance Vars
	private static int PASS_GO_PAY = 400;

	// Constructors

	/**
	 * @param name
	 */
	public Go(SquareNames squareName, int PASS_GO_PAY) {
		this.name = squareName;
		Go.PASS_GO_PAY = PASS_GO_PAY;
		// TODO Auto-generated constructor stub
	}
	// Methods

	/**
	 * @return the PASS_GO_PAY
	 */
	public static int getPASS_GO_PAY() {
		return PASS_GO_PAY;
	}

	/**
	 * Method to Pay Player P1
	 * 
	 * @param p1
	 * @throws InterruptedException
	 */
	public static void payday(Player p1) throws InterruptedException {
		int currentBalance = p1.getCurrentBalance();
		p1.setCurrentBalance(currentBalance + PASS_GO_PAY);
		System.out.println(
				"Great news! You have just received $" + PASS_GO_PAY + " in capital investment! Spend it wisely!");
		TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
		System.out.println("Updated Player Balance : \t$" + p1.getCurrentBalance());

	}

	/**
	 * Method to display pre-defined GO message
	 * 
	 * @throws InterruptedException
	 */
	public static void goMessage() throws InterruptedException {
		System.out.println("You've earned a holiday - Take a Break!");
		TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
	}

}