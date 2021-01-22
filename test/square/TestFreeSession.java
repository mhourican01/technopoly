package square;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFreeSession {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Testing the Constructor for FreeSession
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFreeSessionSquareNames() throws Exception {
		FreeSession fs = new FreeSession(SquareNames.FREE_SESSION);
		assertArrayEquals(SquareNames.FREE_SESSION, fs.getName());
	}

	private void assertArrayEquals(SquareNames freeSession, SquareNames name) {
		// TODO Auto-generated method stub
	}

}
