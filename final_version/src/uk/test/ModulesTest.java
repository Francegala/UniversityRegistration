package uk.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.ManagementSystem;
import uk.Modules;
import uk.MyException;
import uk.PostgraduateResearch;
import uk.PostgraduateTaught;
import uk.Student;
import uk.StudentID;
import uk.StudentName;
import uk.UndergraduateStudent;

public class ModulesTest {

	@Test
	public void testModule() throws IOException, MyException {

		Modules testModules = new Modules(6, "one");
		
		assertTrue(testModules instanceof Modules);

	}
	
/*//let's make ValueOf public
	@Test
	public void testValueOf() throws MyException {
		assertEquals(1,(Modules.valueOf("one")));
		assertEquals(2,(Modules.valueOf("two")));
		assertEquals(3,(Modules.valueOf("three")));
		assertEquals(4,(Modules.valueOf("postgraduate")));

	}
	
	@Test(expected= MyException.class)
	public void testValueOfError() throws MyException {
		int probableError = Modules.valueOf("Error");

	}
*/
	
	@Test(expected= MyException.class)
	public void testGetCreditsUndergraduate() throws MyException, IOException{
		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;

		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,4,"one",sID);
		ManagementSystem.registerStudent(s);
		
		s.getModule().getCredits(s.getClass());
		
	}

	
	@Test(expected= MyException.class)
	public void testGetCreditsPostgraduate() throws MyException, IOException {
		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		
		name=StudentName.valueOf("Joe Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 4,"postgraduate",sID);
		ManagementSystem.registerStudent(s);
		
		
		s.getModule().getCredits(s.getClass());

	}
	
	
	@Test
	public void testGetNumModules() throws IOException, MyException {
		
		Modules testModules;
		testModules = new Modules(12, "three");
		assertEquals(12, testModules.getNumModules());
	
		testModules = new Modules(6, "one");
		assertEquals(6, testModules.getNumModules());

		testModules = new Modules(4, "two");
		assertEquals(4, testModules.getNumModules());
	}
	

	@Test
	public void testToString() throws IOException, MyException {
		
		Modules testModules = new Modules(1, "one");
		assertEquals("Modules:" + '\n' + "CSC1021 Programming I 20" + '\n', testModules.toString());
		
	}

}
