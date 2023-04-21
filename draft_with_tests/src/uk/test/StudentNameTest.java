package uk.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import uk.MyException;
import uk.StudentName;

public class StudentNameTest {

	@Test
	public void testGetFirst() throws MyException {
		StudentName studentNameTest;
		studentNameTest = StudentName.valueOf("Fistnametest SecondnameTest");
		assertEquals(studentNameTest.getFirst(), "Fistnametest");
	}

	@Test
	public void testGetSecond() throws MyException {
		StudentName studentNameTest;
		studentNameTest = StudentName.valueOf("Fistnametest SecondnameTest");
		assertEquals(studentNameTest.getSecond(), "SecondnameTest");	
		}

	@Test
	public void testGetInitials() throws MyException {
		StudentName studentNameTest;
		studentNameTest = StudentName.valueOf("Fistnametest SecondnameTest");
		assertEquals(studentNameTest.getInitials(), "FS");	
	}

	// In this method I'm testing all the extreme cases because all the boundary cases are handled at the beginning from the value of method
	// Normal cases are tested in all the other classes
	@Test(expected= MyException.class)
	public void testValueOf() throws MyException {
		StudentName studentNameTest;
		studentNameTest = StudentName.valueOf(" ");
	}

	@Test
	public void testToString() throws MyException {
		StudentName studentNameTest;
		studentNameTest = StudentName.valueOf("Fistnametest SecondnameTest");
		assertEquals(studentNameTest.getSecond(), "SecondnameTest");	

	}

}
