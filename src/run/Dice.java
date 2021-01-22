package run;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dice {

	/**
	 * Returns a random number between 1 and 4 for the first die
	 * 
	 * @return
	 */
	public static int diceOne() {
		int diceFace = 4;

		Random rand = new Random();

		int dice1;

		dice1 = rand.nextInt(diceFace) + 1;

		return dice1;
	}

	/**
	 * Returns a random number between 1 and 4 for the second die
	 * 
	 * @return
	 */
	public static int diceTwo() {
		int diceFace = 4;

		Random rand = new Random();

		int dice2;

		dice2 = rand.nextInt(diceFace) + 1;

		return dice2;
	}

	/**
	 * Displays the individual dice, and shows the total roll.
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public static int rollDice() throws InterruptedException {
		int dice1, dice2;
		dice1 = diceOne();
		dice2 = diceTwo();
		System.out.println("You rolled " + dice1 + " and " + dice2 + ".");
		int totalRoll = dice1 + dice2;
		System.out.println("Your total roll is " + totalRoll + "!");
		TimeUnit.MILLISECONDS.sleep(Main.TEXTPAUSE);
		return totalRoll;
	}
}
