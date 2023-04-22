package uk.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.AbstractStudent;
import uk.MyException;
import uk.PostgraduateResearch;
import uk.SmartCard;
import uk.SmartCardNumber;
import uk.Student;
import uk.StudentID;
import uk.StudentName;
import uk.UndergraduateStudent;

public class SmartCardTest {

	@Test
	public void testSmartCard() throws MyException {
		StudentName name;
		Calendar birthDate;
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		
		SmartCard testSmartCard = new SmartCard(name, birthDate);
		
		assertTrue(testSmartCard instanceof SmartCard);

		
	}

	@Test
	public void testGetName() throws  MyException {
		StudentName name;
		Calendar birthDate;
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		
		SmartCard testSmartCard = new SmartCard(name, birthDate);

		assertEquals(name.toString(), testSmartCard.getName().toString());

		assertTrue(testSmartCard.getName() instanceof 	StudentName);	
		
	}

	@Test
	public void testGetScNumber() throws MyException {
		StudentName name;
		Calendar birthDate;
		
		name=StudentName.valueOf("Jeanna Carla");
		birthDate = new GregorianCalendar(1998,8,5);
		
		SmartCard testSmartCard = new SmartCard(name, birthDate);


		assertTrue(testSmartCard.getScNumber() instanceof 	SmartCardNumber);	
		assertEquals("JC-2018-0", testSmartCard.getScNumber().toString());	}
	

	@Test
	public void testGetBirthDate() throws MyException {
		StudentName name;
		Calendar birthDate;
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		
		SmartCard testSmartCard = new SmartCard(name, birthDate);

		Date dbirthDate =  birthDate.getTime();

		assertTrue(testSmartCard.getBirthDate() instanceof Date);
		assertEquals(dbirthDate, testSmartCard.getBirthDate());	
		
	}

	@Test
	public void testGetIssueDate() throws MyException {
		StudentName name;
		Calendar birthDate;
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		
		SmartCard testSmartCard = new SmartCard(name, birthDate);

		Date issueDate = new Date();

		assertTrue(testSmartCard.getIssueDate() instanceof Date);
		assertEquals(issueDate, testSmartCard.getIssueDate());	
		
	}

	@Test
	public void testToString() throws MyException {
		StudentName name;
		Calendar birthDate;
		

		
		name=StudentName.valueOf("Jeanna Smith");
		birthDate = new GregorianCalendar(1998,8,5);
		
		Date dbirthDate =  birthDate.getTime();

		
		SmartCard testSmartCard = new SmartCard(name, birthDate);
		
		
		String test = String.format("%s%n%s%n%s%n%s%n%s", name.getFirst(), name.getSecond(), dbirthDate, testSmartCard.getScNumber(), testSmartCard.getIssueDate() );

		assertEquals(testSmartCard.toString(),test);
		
	}

}
