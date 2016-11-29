import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Performs unit tests on the {@link Student1} class.
 *
 * @author Ian T. Nabney
 * @version 8 January 2012
 */

public class TestStudent1 {
	private Student1 s1;
	private Student1 s2;
	
	@Before
	public void setUp() {
		s1 = new Student1("Harry Potter");
		s2 = new Student1("Cedric Diggory", 3);
	}
	
	@Test 
	public void testGetHUN() {
		assertEquals(s1.getHUN(), 1);
		assertEquals(s2.getHUN(), 2);
	}
	
	@Test
	public void testGetName() {
		assertEquals(s1.getName(), "Harry Potter");
	}


}
