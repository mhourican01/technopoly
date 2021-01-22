package square;

public enum CompValues {

	// Values for Computer ArrayList Generation.
	// Computer Price
	COMPPRICEMIN(400), COMPPRICEMAX(2500),
	// Session Price
	SESSPRICEMIN(100), SESSPRICEINIT(500),
	// Upgrade Price
	UPPRICEMIN(100), UPPRICEMAX(1000),
	// Upgrade Level
	UPLEVELMIN(0), UPLEVELMAX(4),
	// Field Limits
	FIELD1LIMIT(2), FIELD2LIMIT(3), FIELD3LIMIT(3), FIELD4LIMIT(2),
	// Values used to maintain game play
	SESSPRICEMAX(100000);

	private final int value;

	/**
	 * Constructor for ENUM CompValues - int value
	 * 
	 * @param value
	 */
	private CompValues(int value) {
		this.value = value;
	}

	/**
	 * @return value
	 */
	public int getValue() {
		return value;
	}
}