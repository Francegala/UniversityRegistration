package uk.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.ManagementSystem;
import uk.Module;
import uk.MyException;
import uk.PostgraduateTaught;
import uk.SmartCard;
import uk.Student;
import uk.StudentID;
import uk.StudentName;
import uk.UndergraduateStudent;

public class AbstractStudentTest {

	//testing the factory
	@Test
	public void testAbstractStudent() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s1;
		Student s2;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s1=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		s2=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		assertTrue(s1==s2);
				}

	//how can I test an exception because it throw the exception, it does not test it
	//it shows the error and return fail
	@Test(expected= MyException.class)
	public void testGetSupervisor() throws MyException, IOException{
		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		
		s.getSupervisor();
		
			
	}	

	@Test
	public void testGetStudentID() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		
		assertEquals(s.getStudentID(), sID);
	}

	@Test
	public void testGetModule() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		Module module;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		
		module = new Module(6,"one");
		assertEquals(s.getModule().toString(),module.toString());
		assertTrue(s.getModule() instanceof Module);

		
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"two",sID);
		
		module = new Module(6,"two");
		assertEquals(s.getModule().toString(),module.toString());
		assertTrue(s.getModule() instanceof Module);

		
		
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,12,"three",sID);
		
		module = new Module(12,"three");
		assertEquals(s.getModule().toString(),module.toString());
		assertTrue(s.getModule() instanceof Module);

		
		name=StudentName.valueOf("Joe Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);

		module = new Module(8,"postgraduate");
		assertEquals(s.getModule().toString(),module.toString());
		assertTrue(s.getModule() instanceof Module);

	}

	@Test
	public void testGetSmartcard() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		ManagementSystem.registerStudent(s);

		SmartCard testSCard = s.getSmartcard();
		assertEquals(testSCard, s.getSmartcard());
		
		assertTrue(s.getSmartcard() instanceof SmartCard);
	}

	@Test
	public void testGetName() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		
		assertEquals(name.toString(), s.getName().toString());
		
		assertTrue(s.getName() instanceof 	StudentName);
	}

	@Test
	public void testGetDateOfBirth() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		
		assertEquals(birthDate, s.getDateOfBirth());
		
		assertTrue(s.getDateOfBirth() instanceof 	Calendar);
	}

	@Test
	public void testGetBirthDate() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		Date dbirthDate =  birthDate.getTime();
		
		assertEquals(dbirthDate, s.getBirthDate());
		
		assertTrue(s.getBirthDate() instanceof 	Date);	}

	@Test
	public void testGetAge() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		int birthDateYear = birthDate.get(Calendar.YEAR);
		int todayYear = birthDate.getInstance().get(Calendar.YEAR);
		
		assertEquals((todayYear - birthDateYear), s.getAge());
	}
		

	@Test
	public void testSetSmartCard() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		SmartCard sc = new SmartCard(s.getName(), s.getDateOfBirth());
		s.setSmartCard(sc);
		
		assertEquals(sc, s.getSmartcard());

		
	}

	@Test
	public void testToString() throws MyException, IOException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		ManagementSystem.registerStudent(s);

		String test = String.format("%s%n%n%n%s%n%n%n%s%n%n%n%s%n",sID,name,s.getSmartcard(),s.getModule());

		assertEquals(s.toString(),test);
	}

}
