/**
 * 
 */
package square;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import square.Computer;

/**
 * @author Brendan
 *
 */
public class testComputer {

	// Test Data

	// Name | Owner
	private SquareNames validName = SquareNames.INSPIRON;
	private String validOwner = "Zapp";

	// Session Price
	private int invalidSessionLowerPrice = 99;
	private int validSessionLowerPrice = 100;
	private int validSessionMiddlePrice = 12500;
	private int validSessionHigherPrice = 100000;
	private int invalidSessionHigherPrice = 100001;
	// Computer Price
	private int invalidComputerLowerPrice = 399;
	private int validComputerLowerPrice = 400;
	private int validComputerMiddlePrice = 1250;
	private int validComputerHigherPrice = 2500;
	private int invalidComputerHigherPrice = 2501;
	// Upgrade Price
	private int invalidUpgradeLowerPrice = 99;
	private int validUpgradeLowerPrice = 100;
	private int validUpgradeMiddlePrice = 500;
	private int validUpgradeHigherPrice = 1000;
	private int invalidUpgradeHigherPrice = 1001;
	// Upgrade Level
	private int invalidUpgradeLowerLevel = -1;
	private int validUpgradeLowerLevel = 0;
	private int validUpgradeMiddleLevel = 2;
	private int validUpgradeHigherLevel = 4;
	private int invalidUpgradeHigherLevel = 5;
	// Field
	private FieldNames validFieldName = FieldNames.LENOVO;

	// Methods
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link square.Computer#Computer(java.lang.String, java.lang.String, String, int, int, int, int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testValidComputerStringStringIntIntIntIntInt() throws Exception {
		Computer s1 = new Computer(validName, validOwner, validComputerMiddlePrice, validSessionMiddlePrice,
				validUpgradeMiddlePrice, validUpgradeMiddleLevel, validFieldName);

		assertEquals(validName, s1.getName());
		assertEquals(validOwner, s1.getOwner());
		assertEquals(validComputerMiddlePrice, s1.getComputerPrice());
		assertEquals(validSessionMiddlePrice, s1.getSessionPrice());
		assertEquals(validUpgradeMiddlePrice, s1.getUpgradePrice());
		assertEquals(validUpgradeMiddleLevel, s1.getUpgradeLevel());
		assertEquals(validFieldName, s1.getField());

	}

	/**
	 * Test method for {@link square.Computer#getComputerPrice()}. Test method for
	 * {@link square.Computer#setComputerPrice(int)}.
	 * 
	 * @throws Exception Testing Valid Input
	 */
	@Test
	public void testGetSetValidComputerPrice() throws Exception {
		Computer s1 = new Computer();
		s1.setComputerPrice(validComputerLowerPrice);
		assertEquals(validComputerLowerPrice, s1.getComputerPrice());
		s1.setComputerPrice(validComputerMiddlePrice);
		assertEquals(validComputerMiddlePrice, s1.getComputerPrice());
		s1.setComputerPrice(validComputerHigherPrice);
		assertEquals(validComputerHigherPrice, s1.getComputerPrice());
	}

	/**
	 * Test method for {@link square.Computer#getComputerPrice()}. Test method for
	 * {@link square.Computer#setComputerPrice(int)}.
	 * 
	 * @throws Exception Testing Lower Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidComputerLowerPrice() throws Exception {
		Computer s1 = new Computer();
		s1.setComputerPrice(invalidComputerLowerPrice);
	}

	/**
	 * Test method for {@link square.Computer#getComputerPrice()}. Test method for
	 * {@link square.Computer#setComputerPrice(int)}.
	 * 
	 * @throws Exception Testing Higher Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidComputerHigherPrice() throws Exception {
		Computer s1 = new Computer();
		s1.setComputerPrice(invalidComputerHigherPrice);
	}

	/**
	 * Test method for {@link square.Computer#getSessionPrice()}. Test method for
	 * {@link square.Computer#setSessionPrice(int)}.
	 * 
	 * @throws Exception Testing Valid Input
	 */
	@Test
	public void testGetSetValidSessionPrice() throws Exception {
		Computer s1 = new Computer();
		s1.setSessionPrice(validSessionLowerPrice);
		assertEquals(validSessionLowerPrice, s1.getSessionPrice());
		s1.setSessionPrice(validSessionMiddlePrice);
		assertEquals(validSessionMiddlePrice, s1.getSessionPrice());
		s1.setSessionPrice(validSessionHigherPrice);
		assertEquals(validSessionHigherPrice, s1.getSessionPrice());
	}

	/**
	 * Test method for {@link square.Computer#getRent()}. Test method for
	 * {@link square.Computer#setRent(int)}.
	 * 
	 * @throws Exception Testing Lower Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidLowerSessionPrice() throws Exception {
		Computer s1 = new Computer();
		s1.setSessionPrice(invalidSessionLowerPrice);
	}

	/**
	 * Test method for {@link square.Computer#getRent()}. Test method for
	 * {@link square.Computer#setRent(int)}.
	 * 
	 * @throws Exception Testing Higher Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidHigherSessionPrice() throws Exception {
		Computer s1 = new Computer();
		s1.setSessionPrice(invalidSessionHigherPrice);
	}

	/**
	 * Test method for {@link square.Computer#getUpgradePrice()}. Test method for
	 * {@link square.Computer#setUpgradePrice(int)}.
	 * 
	 * @throws Exception Test for Valid Input
	 */
	@Test
	public void testGetSetValidUpgradePrice() throws Exception {
		Computer s1 = new Computer();
		s1.setUpgradePrice(validUpgradeLowerPrice);
		assertEquals(validUpgradeLowerPrice, s1.getUpgradePrice());
		s1.setUpgradePrice(validUpgradeMiddlePrice);
		assertEquals(validUpgradeMiddlePrice, s1.getUpgradePrice());
		s1.setUpgradePrice(validUpgradeHigherPrice);
		assertEquals(validUpgradeHigherPrice, s1.getUpgradePrice());
	}

	/**
	 * Test method for {@link square.Computer#getUpgradePrice()}. Test method for
	 * {@link square.Computer#setUpgradePrice(int)}.
	 * 
	 * @throws Exception Testing Lower Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidLowerUpgradePrice() throws Exception {
		Computer s1 = new Computer();
		s1.setUpgradePrice(invalidUpgradeLowerPrice);
	}

	/**
	 * Test method for {@link square.Computer#getUpgradePrice()}. Test method for
	 * {@link square.Computer#setUpgradePrice(int)}.
	 * 
	 * @throws Exception Testing Higher Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidHigherUpgradePrice() throws Exception {
		Computer s1 = new Computer();
		s1.setUpgradePrice(invalidUpgradeHigherPrice);
	}

	/**
	 * Test method for {@link square.Computer#getUpgradeLevel()}. Test method for
	 * {@link square.Computer#setUpgradeLevel(int)}.
	 * 
	 * @throws Exception Test for Valid Input
	 */
	@Test
	public void testGetSetValidUpgradeLevel() throws Exception {
		Computer s1 = new Computer();
		s1.setUpgradeLevel(validUpgradeLowerLevel);
		assertEquals(validUpgradeLowerLevel, s1.getUpgradeLevel());
		s1.setUpgradeLevel(validUpgradeMiddleLevel);
		assertEquals(validUpgradeMiddleLevel, s1.getUpgradeLevel());
		s1.setUpgradeLevel(validUpgradeHigherLevel);
		assertEquals(validUpgradeHigherLevel, s1.getUpgradeLevel());
	}

	/**
	 * Test method for {@link square.Computer#getUpgradeLevel()}. Test method for
	 * {@link square.Computer#setUpgradeLevel(int)}.
	 * 
	 * @throws Exception Testing Lower Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidLowerUpgradeLevel() throws Exception {
		Computer s1 = new Computer();
		s1.setUpgradeLevel(invalidUpgradeLowerLevel);
	}

	/**
	 * Test method for {@link square.Computer#getUpgradeLevel()}. Test method for
	 * {@link square.Computer#setUpgradeLevel(int)}.
	 * 
	 * @throws Exception Testing Higher Boundary
	 */
	@Test(expected = Exception.class)
	public void testGetSetInvalidHigherUpgradeLevel() throws Exception {
		Computer s1 = new Computer();
		s1.setUpgradeLevel(invalidUpgradeHigherLevel);
	}

}
