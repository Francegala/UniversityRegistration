package uk.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.MyException;
import uk.SmartCardNumber;
import uk.StudentName;


public class SmartCardNumberTest {

	@Test
	public void testGetInstance() throws MyException {
		StudentName name;
		name=StudentName.valueOf("Jade Clarke");
		Date issueDate = new Date();

		
		SmartCardNumber testSmartCardNumber = SmartCardNumber.getInstance(name, issueDate);
		SmartCardNumber testSmartCardNumber1 = SmartCardNumber.getInstance(name, issueDate);

		assertTrue(testSmartCardNumber instanceof SmartCardNumber);
		assertNotEquals(testSmartCardNumber, testSmartCardNumber1);
		
	}

	@Test
	public void testGetInitials() throws MyException {
		StudentName name;
		name=StudentName.valueOf("Jade Clarke");
		Date issueDate = new Date();

		
		SmartCardNumber testSmartCardNumber = SmartCardNumber.getInstance(name, issueDate);
		
		assertEquals("JC", testSmartCardNumber.getInitials());

	}

	@Test
	public void testGetYear() throws MyException {
		StudentName name;
		name=StudentName.valueOf("Jade Clarke");
		Date issueDate = new Date();

		
		SmartCardNumber testSmartCardNumber = SmartCardNumber.getInstance(name, issueDate);
		
		assertEquals(2018, testSmartCardNumber.getYear());	}

	@Test
	public void testGetSerialNumber() throws MyException {
		StudentName name;
		name=StudentName.valueOf("Yasmin Bell");
		Date issueDate = new Date();

		
		SmartCardNumber testSmartCardNumber = SmartCardNumber.getInstance(name, issueDate);
		assertEquals(0, testSmartCardNumber.getSerialNumber());
		
	
	}

	@Test
	public void testToString() throws MyException {
		StudentName name;
		name=StudentName.valueOf("Isabel Rogers");
		Date issueDate = new Date();

		
		SmartCardNumber testSmartCardNumber = SmartCardNumber.getInstance(name, issueDate);
		
		
		String test = String.format("%s%s%d%s%d", "IR", "-", 2018, "-", 0);
		
		assertEquals(testSmartCardNumber.toString(),test);
	}

}
