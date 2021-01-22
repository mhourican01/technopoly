/**
 * 
 */
package square;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import player.Player;
import square.Go;

/**
 * @author Brendan
 *
 */
public class TestGo {

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
	 * Testing the displaySquare Method
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPlayerBalanceUpdate() throws Exception {
		Player p1 = new Player("John", 0, 1);
		Go.payday(p1);
		assertEquals(Go.getPASS_GO_PAY(), p1.getCurrentBalance());

	}

}
