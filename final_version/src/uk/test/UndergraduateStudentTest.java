package uk.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.MyException;
import uk.Student;
import uk.StudentID;
import uk.StudentName;
import uk.UndergraduateStudent;


public class UndergraduateStudentTest {

	@Test
	public void testGetInstance() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		Student s1;
		StudentID sID;
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		
		s1=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		

		assertTrue(s instanceof UndergraduateStudent);
		assertEquals(s, s1);	
		}

	@Test
	public void testGetPassmark() throws MyException, IOException {
		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		
		assertEquals("Passmark for undergraduate modules is 40%", s.getPassmark());
	}

}
