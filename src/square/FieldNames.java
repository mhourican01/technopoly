/**
 * 
 */
package square;

/**
 * @author Brendan
 *
 */
public enum FieldNames {

	// List of Field Names (Computer Companies)
	LENOVO(2), DELL(3), ASUS(3), APPLE(2);

	private final int value;

	/**
	 * Constructor for ENUM FieldNames - int value
	 * 
	 * @param value
	 */
	private FieldNames(int value) {
		this.value = value;
	}

	/**
	 * @return int value
	 */
	public int getValue() {
		return value;
	}
}
