package uk.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.ManagementSystem;
import uk.MyException;
import uk.Student;
import uk.StudentID;
import uk.StudentName;
import uk.UndergraduateStudent;

public class StudentIDTest {

	@Test
	public void testGetLetter() throws MyException {
		StudentID sID = StudentID.getInstance();
		assertEquals("a", sID.getLetter());
		
	}

	@Test
	public void testGetNumber() throws MyException {
		StudentID sID = StudentID.getInstance();
		assertEquals(2, sID.getNumber());
	}

	@Test
	public void testGetInstance() throws MyException {
		StudentID sID = StudentID.getInstance();
		assertTrue(sID instanceof StudentID);
	}

	
	@Test
	public void testToString() throws MyException {
		StudentID sID = StudentID.getInstance();
		assertEquals(sID.toString(),"a0000");
		}
	
/*	@Test(expected= MyException.class)
	public void testBoundaries() throws MyException, IOException {
		for(int i=0; i<=259975; i++){
		StudentID sID = StudentID.getInstance();
		}
		
		}
		*/

}
