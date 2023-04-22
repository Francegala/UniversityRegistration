package uk.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import uk.Supervisor;

public class SupervisorTest {

	@Test
	public void testSupervisor() throws FileNotFoundException {
		Supervisor testSupervisor = new Supervisor(1);
		Supervisor testSuperviso1 = new Supervisor(1);
		Supervisor testSupervisor2 = new Supervisor(2);

		assertTrue(testSupervisor instanceof Supervisor);
		assertEquals(testSupervisor.toString(), testSuperviso1.toString());
		assertNotEquals(testSupervisor, testSupervisor2);

	}

	@Test
	public void testGetFirst() throws FileNotFoundException {
		Supervisor testSupervisor = new Supervisor(1);
		assertEquals("Matt", testSupervisor.getFirst());

	}

	@Test
	public void testGetSecond() throws FileNotFoundException {
		Supervisor testSupervisor = new Supervisor(1);
		assertEquals("Smith", testSupervisor.getSecond());
	}

	@Test
	public void testToString() throws FileNotFoundException {
			
		Supervisor testSupervisor = new Supervisor(1);

		String test = String.format("%s%s%s%s","Supervisor Name: ", "Matt"," ","Smith");
	
		assertEquals(testSupervisor.toString(),test);	}

}
