package uk;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class University {

	public static void main(String[] args) throws IOException, MyException {

		StudentName name;
		Calendar birthDate;
		Student s;
		StudentID sID;


		//Let's create three undergraduate 
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,8,5);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"one",sID);
		ManagementSystem.registerStudent(s);

		/* //try to change stage mispelling the word "three"
		ManagementSystem.amendStudent(s.getStudentID(), "threee");
		 */

		// amend this student changing the stage from 2 to 3
		name=StudentName.valueOf("Isabel Hodgson");
		birthDate = new GregorianCalendar(1997,7,10);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"two",sID);
		ManagementSystem.registerStudent(s);
		System.out.println(ManagementSystem.StudentMap.get(sID).getModule());
		ManagementSystem.amendStudent(s.getStudentID(), "three");
		System.out.println(ManagementSystem.StudentMap.get(sID).getModule());


		//terminate that student
		name=StudentName.valueOf("Charlotte Stewart");
		birthDate = new GregorianCalendar(1995,3,21);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,12,"three",sID);
		ManagementSystem.registerStudent(s);
		ManagementSystem.terminateStudent(sID);

		//let's count how many undergraduates are registered, check if they are two instead of three
		UndergraduateStudent ustudent = null;
		System.out.println(ManagementSystem.noOfStudents(ustudent));

		//register another student	with same data of a previous one but with different stage
		name=StudentName.valueOf("Francesco Galassi");
		birthDate = new GregorianCalendar(1998,7,31);
		sID =StudentID.getInstance();
		s=UndergraduateStudent.getInstance(name, birthDate,6,"two",sID);
		ManagementSystem.registerStudent(s);

		// print his name
		System.out.println(ManagementSystem.StudentMap.get(sID).getName());
		// print his age
		System.out.println(ManagementSystem.StudentMap.get(sID).getAge());
		// print the passmark percentage 
		System.out.println(ManagementSystem.StudentMap.get(sID).getPassmark());
		// print his Date of birth
		System.out.println(ManagementSystem.StudentMap.get(sID).getBirthDate());
		// print his modules
		System.out.println(ManagementSystem.StudentMap.get(sID).getModule());
		// print his smart card
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard());
		// print his student ID
		System.out.println(ManagementSystem.StudentMap.get(sID).getStudentID());
		// print how many modules he is doing
		System.out.println(ManagementSystem.StudentMap.get(sID).getModule().getNumModules());

		/* // print his supervisor but since he is an undergraduate it throws an error
		System.out.println(ManagementSystem.StudentMap.get(sID).getSupervisor());
		 */


		// print all the students registered
		System.out.println(ManagementSystem.StudentMap.values());


		/* //let's create a student ID random and try to terminate a student that does not exist
		sID =StudentID.generateID();
		ManagementSystem.terminateStudent(sID);
		 */


		/* //now let's create a student at stage one but trying to put less credits than required 
		name=StudentName.valueOf("Charlotte Stewart");
		birthDate = new GregorianCalendar(1998,7,31);
		sID =StudentID.generateID();
		s=UndergraduateStudent.getInstance(name, birthDate,5,"one",sID);
		ManagementSystem.registerStudent(s);
		 */		

		/* //now let's create an undergraduate student who is too young to be registered
		name=StudentName.valueOf("Charlotte Stewart");
		birthDate = new GregorianCalendar(2008,7,31);
		sID =StudentID.generateID();
		s=UndergraduateStudent.getInstance(name, birthDate,5,"one",sID);
		ManagementSystem.registerStudent(s);
		 */

		//let's create some postgraduate taught students (two with the same initials to test the smart card)
		name=StudentName.valueOf("Joe Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		ManagementSystem.registerStudent(s);

		/* //try to amend the supervisor of this student but it throws an error since it is postgraduate taught
		ManagementSystem.amendStudent(s.getStudentID(), 2);
		 */

		//try to create a postgraduate taught underage and a postgraduate taught with less credits
		/*name=StudentName.valueOf("William King");
		birthDate = new GregorianCalendar(2001,4,14);
		sID =StudentID.generateID();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		ManagementSystem.registerStudent(s);
		 */

		/*name=StudentName.valueOf("Anna Clark");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.generateID();
		s=PostgraduateTaught.getInstance(name, birthDate, 5,"postgraduate",sID);
		ManagementSystem.registerStudent(s);
		 */

		name=StudentName.valueOf("Jacob Jordan");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.getInstance();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		ManagementSystem.registerStudent(s);

		//now let's create a postgraduate research student
		name=StudentName.valueOf("Jade Clarke");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s);
		System.out.println(ManagementSystem.StudentMap.get(sID).getSupervisor());

		//try to change the supervisor of this student
		ManagementSystem.amendStudent(s.getStudentID(), 2);
		System.out.println(ManagementSystem.StudentMap.get(sID).getSupervisor());


		//let's generate two students with the same name, date of birth and data and check that they are not registered as the same student because the student ID and the smart card have a number that identifies different students
		name=StudentName.valueOf("Elise Dean");
		birthDate = new GregorianCalendar(1990,3,14);
		sID =StudentID.getInstance();
		Student s1;
		s1=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s1);

		name=StudentName.valueOf("Elise Dean");
		birthDate = new GregorianCalendar(1990,3,14);
		sID =StudentID.getInstance();
		Student s2;
		s2=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s2);

		//to have the quality true I should put the same student ID and they must not be registered in the system in order to not allocate them a smart card
		System.out.println(s1==s2);

		/* //try to change postgraduate taught stage and postgraduate research stage
		ManagementSystem.amendStudent(s.getStudentID(), "one");

		name=StudentName.valueOf("Katie Weston");
		birthDate = new GregorianCalendar(1992,6,10);
		sID =StudentID.generateID();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"postgraduate",sID);
		ManagementSystem.registerStudent(s);

		ManagementSystem.amendStudent(s.getStudentID(), "one");
		 */

		/* // try to print postgraduate research modules
		name=StudentName.valueOf("Connor Giles");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.generateID();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,5);
		ManagementSystem.registerStudent(s);
		System.out.println(ManagementSystem.StudentMap.get(sID).getModule());
		 */


		/* //try to register a postgraduate taught but with the modules of a stage one student
		name=StudentName.valueOf("Ben Holmes");
		birthDate = new GregorianCalendar(1991,4,14);
		sID =StudentID.generateID();
		s=PostgraduateTaught.getInstance(name, birthDate, 8,"one",sID);
		ManagementSystem.registerStudent(s);
		 */

		// print all the data of a postgraduate research student
		name=StudentName.valueOf("Eva Short");
		birthDate = new GregorianCalendar(1994,1,15);
		sID =StudentID.getInstance();
		s=PostgraduateResearch.getInstance(name, birthDate,sID,1);
		ManagementSystem.registerStudent(s);
		System.out.println(ManagementSystem.StudentMap.get(sID).getAge());
		/*// these two methods trow errors
		System.out.println(ManagementSystem.StudentMap.get(sID).getPassmark());
		System.out.println(ManagementSystem.StudentMap.get(sID).getModule());
		 */
		System.out.println(ManagementSystem.StudentMap.get(sID).getBirthDate());
		System.out.println(ManagementSystem.StudentMap.get(sID).getName());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard());
		System.out.println(ManagementSystem.StudentMap.get(sID).getStudentID());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSupervisor());


		//let's print data from Smart Card
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard().getBirthDate());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard().getIssueDate());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard().getScNumber());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard().getName());

		// print data from Smart Card Number
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard().getScNumber().getInitials());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard().getScNumber().getSerialNumber());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSmartcard().getScNumber().getYear());

		//print data from student ID
		System.out.println(ManagementSystem.StudentMap.get(sID).getStudentID().getLetter());
		System.out.println(ManagementSystem.StudentMap.get(sID).getStudentID().getNumber());

		//print data from Name
		System.out.println(ManagementSystem.StudentMap.get(sID).getName().getFirst());
		System.out.println(ManagementSystem.StudentMap.get(sID).getName().getSecond());
		System.out.println(ManagementSystem.StudentMap.get(sID).getName().getInitials());
		
		//print data from supervisor
		System.out.println(ManagementSystem.StudentMap.get(sID).getSupervisor().getFirst());
		System.out.println(ManagementSystem.StudentMap.get(sID).getSupervisor().getSecond());

				
		
		//print the actual number of students
		System.out.println(ManagementSystem.noOfStudents(ustudent));

		PostgraduateTaught ptstudent = null;
		System.out.println(ManagementSystem.noOfStudents(ptstudent));

		PostgraduateResearch prstudent = null;
		System.out.println(ManagementSystem.noOfStudents(prstudent));


		//print all the registered students
		System.out.println(ManagementSystem.StudentMap.values());


	}
}
