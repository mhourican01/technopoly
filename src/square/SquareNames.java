/**
 * 
 */
package square;

/**
 * Sets the names of the squares for the arraylist. Ordered this way to stop GO
 * and FREE_SESSION from being placed in Computer ArrayList
 * 
 * @author Brendan
 *
 */
public enum SquareNames {
	// LENOVO
	THINKPAD(1), YOGA(2),
	// DELL
	INSPIRON(3), VOSTRO(4), XPS(5),
	// ASUS
	CHROMEBOOK(7), ZENBOOK(8), ROG(9),
	// APPLE
	MACBOOK_AIR(10), MACBOOK_PRO(11),
	// Board squares
	GO(0), FREE_SESSION(6);
	// Preventing the values of the Enums being altered.

	private final int value;

	/**
	 * Constructor
	 * 
	 * @param value
	 */
	private SquareNames(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

}
