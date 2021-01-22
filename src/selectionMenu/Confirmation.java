package selectionMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides confirmation system for major decisions during game Returns a
 * boolean to the method call.
 * 
 * @author 40020788
 *
 */
public abstract interface Confirmation {

	public static boolean confirm(Scanner scanner) {
		int choice;
		boolean valid = false;
		boolean confirmation = false;
		// Do while continues until correct choice is made
		do {
			// try catch will prevent non-int values being input.
			try {

				System.out.println("Confirm?");
				System.out.println("1. Yes");
				System.out.println("2. No");
				choice = scanner.nextInt();

				if (choice == 1) {
					valid = true;
					confirmation = true;
					scanner.nextLine();
				} else if (choice == 2) {
					valid = true;
					scanner.nextLine();

					// catches any choices outside boundaries
				} else {
					System.out.println("Invalid Selection.");
					scanner.nextLine();

				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please try again.");
				scanner.nextLine();
			}

		} while (!valid);
		return confirmation;
	}
}