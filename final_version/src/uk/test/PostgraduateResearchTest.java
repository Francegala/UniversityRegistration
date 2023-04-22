package uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.ManagementSystem;
import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.MyException;
import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.PostgraduateResearch;
import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.SmartCard;
import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.Student;
import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.StudentID;
import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.StudentName;
import uk.ac.ncl.cs.csc1022.coursework.francescogalassi.student170492959.Supervisor;

public class PostgraduateResearchTest {

	@Test
	public void testGetInstance() throws FileNotFoundException, MyException {

		StudentName name;
		Calendar birthDate;
		Student s1;
		Student s2;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s1=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		s2=PostgraduateResearch.getInstance(name, birthDate,sID,1);

		assertTrue(s1 instanceof PostgraduateResearch);
		assertEquals(s1, s2);


	}

	@Test
	public void testGetStudentID() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);

		assertTrue(s.getStudentID() instanceof StudentID);
		assertEquals(sID, s.getStudentID());

	}

	@Test
	public void testGetSupervisor() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);

		assertTrue(s.getSupervisor() instanceof Supervisor);
	}

	@Test
	public void testGetBirthDate() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);

		Date dbirthDate =  birthDate.getTime();

		assertTrue(s.getBirthDate() instanceof Date);
		assertEquals(dbirthDate, s.getBirthDate());
	}
	@Test
	public void testGetSmartcard() throws MyException, FileNotFoundException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s);

		SmartCard testSCard = s.getSmartcard();
		assertEquals(testSCard, s.getSmartcard());

		assertTrue(s.getSmartcard() instanceof SmartCard);
	}

	@Test
	public void testGetName() throws FileNotFoundException, MyException {

		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);

		assertEquals(name.toString(), s.getName().toString());

		assertTrue(s.getName() instanceof 	StudentName);	
		
	}


	@Test(expected= MyException.class)
	public void testGetModule() throws FileNotFoundException, MyException {


		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);

		s.getModule();


	}



	@Test
	public void testGetDateOfBirth() throws FileNotFoundException, MyException {
		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);	
		
		assertEquals(birthDate, s.getDateOfBirth());
		
		assertTrue(s.getDateOfBirth() instanceof 	Calendar);	}

	@Test
	public void testGetAge() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);	
		
		int birthDateYear = birthDate.get(Calendar.YEAR);
		int todayYear = birthDate.getInstance().get(Calendar.YEAR);
		
		assertEquals((todayYear - birthDateYear), s.getAge());
	
	}

	@Test(expected= MyException.class)	public void testGetPassmark() throws FileNotFoundException, MyException {

		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);	
		s.getPassmark();

	}

	@Test
	public void testSetSmartCard() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);	
		
		SmartCard sc = new SmartCard(s.getName(), s.getDateOfBirth());
		s.setSmartCard(sc);
		
		assertEquals(sc, s.getSmartcard());

	}

	@Test
	public void testToString() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);	
		ManagementSystem.registerStudent(s);

		
		String test = String.format("%s%n%n%n%s%n%n%n%s%n%n%n%s%n", sID, name,  s.getSmartcard(), s.getSupervisor());

		assertEquals(s.toString(),test);
	
	}

}
