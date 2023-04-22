package uk.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import uk.ManagementSystem;
import uk.MyException;
import uk.PostgraduateResearch;
import uk.PostgraduateTaught;
import uk.Student;
import uk.StudentID;
import uk.StudentName;
import uk.UndergraduateStudent;

public class ManagementSystemTest {

	@Test
	public void testNoOfStudentsUndergraduateStudent() throws MyException, IOException {
		
		UndergraduateStudent ustudent = null;
		int firstCount = ManagementSystem.noOfStudents(ustudent);
		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		ManagementSystem.registerStudent(s);
		
	
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		ManagementSystem.registerStudent(s);
		
	
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		ManagementSystem.registerStudent(s);
		
		assertNotEquals(firstCount, ManagementSystem.noOfStudents(ustudent));

		
	}

	@Test
	public void testNoOfStudentsPostgraduateTaught() throws MyException, IOException {
		
		PostgraduateTaught ptstudent = null;
		int firstCount = ManagementSystem.noOfStudents(ptstudent);
		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		
		name=StudentName.valueOf("Jacob Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		ManagementSystem.registerStudent(s);
		
		name=StudentName.valueOf("Jacob Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		ManagementSystem.registerStudent(s);
		
		name=StudentName.valueOf("Jacob Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		ManagementSystem.registerStudent(s);
		
		assertNotEquals(firstCount, ManagementSystem.noOfStudents(ptstudent));

			}

	@Test
	public void testNoOfStudentsPostgraduateResearch() throws FileNotFoundException, MyException {
		
		PostgraduateResearch prstudent = null;
		int firstCount = ManagementSystem.noOfStudents(prstudent);

		
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		
		name=StudentName.valueOf("Elise Dean");
		birthDate = new GregorianCalendar(1990,3,14);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s);
		
		name=StudentName.valueOf("Elise Dean");
		birthDate = new GregorianCalendar(1990,3,14);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s);
		
		name=StudentName.valueOf("Elise Dean");
		birthDate = new GregorianCalendar(1990,3,14);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s);
		
		assertNotEquals(firstCount, ManagementSystem.noOfStudents(prstudent));
		
	}

	@Test
	public void testRegisterStudent() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		
		name=StudentName.valueOf("Elise Dean");
		birthDate = new GregorianCalendar(1990,3,14);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
	
		int sizeMapBeforeRegistering = ManagementSystem.StudentMap.size();
		assertNull(s.getSmartcard());

		
		ManagementSystem.registerStudent(s);
		
		assertEquals((sizeMapBeforeRegistering +1), ManagementSystem.StudentMap.size());	
		
		assertNotNull(s.getSmartcard());
		assertTrue(ManagementSystem.StudentMap.containsKey(sID));


	}

	@Test
	public void testAmendStudentStudentIDString() throws MyException, IOException {
	
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		ManagementSystem.registerStudent(s);
		
		String oldModules = ManagementSystem.StudentMap.get(sID).getModule().toString();
		ManagementSystem.amendStudent(s.getStudentID(), "three");

		String newModules = ManagementSystem.StudentMap.get(sID).getModule().toString();


		assertNotEquals(oldModules, newModules);

	}

	@Test
	public void testAmendStudentStudentIDInt() throws MyException, IOException {

		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s);

		String oldSupervisor = ManagementSystem.StudentMap.get(sID).getSupervisor().toString();

		ManagementSystem.amendStudent(s.getStudentID(), 2);
		
		String newSupervisor = ManagementSystem.StudentMap.get(sID).getSupervisor().toString();
			

		assertNotEquals(newSupervisor, oldSupervisor);

	}

	@Test
	public void testTerminateStudent() throws FileNotFoundException, MyException {
		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;
		
		name=StudentName.valueOf("Elise Dean");
		birthDate = new GregorianCalendar(1990,3,14);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
			ManagementSystem.registerStudent(s);

		int sizeMapBeforeRegistering = ManagementSystem.StudentMap.size();

		ManagementSystem.terminateStudent(sID);
		
		assertEquals((sizeMapBeforeRegistering -1), ManagementSystem.StudentMap.size());	
		
		assertFalse(ManagementSystem.StudentMap.containsKey(sID));
		}

}
