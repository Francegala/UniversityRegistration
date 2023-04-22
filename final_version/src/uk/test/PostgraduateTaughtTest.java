package uk.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.MyException;
import uk.PostgraduateTaught;
import uk.Student;
import uk.StudentID;
import uk.StudentName;

public class PostgraduateTaughtTest {

	@Test
	public void testGetInstance() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		Student s1;

		
		name=StudentName.valueOf("Joe Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		s1=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);

		
		assertTrue(s instanceof PostgraduateTaught);
		assertEquals(s, s1);
	}

	@Test
	public void testGetPassmark() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		
		name=StudentName.valueOf("Joe Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);

		
		assertEquals("Passmark for postgraduate modules is 50%", s.getPassmark());
}

}
