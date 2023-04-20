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

		// Scanner per creare Studenti
		/*
		 * Scanner s1 = new Scanner(System.in); // ask for an input
		 * 
		 * for(int i=0; i<1; i++){
		 * System.out.println("Please write the name of the new student");
		 * String name = s1.nextLine(); System.out.
		 * println("Undergraduate - Postgraduate Taught - Postgraduate Research"
		 * ); String level = s1.nextLine();
		 * 
		 * 
		 * registerStudent(name, level);
		 * 
		 * } System.out.println(NoOfStudents("Undergraduate"));
		 * System.out.println(NoOfStudents("Postgraduate Taught"));
		 * System.out.println(NoOfStudents("Postgraduate Research"));
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * public static int NoOfStudents(String level){ if
		 * (level.toLowerCase().equals("undergraduate")){ return
		 * UndergraduateStudent.counter; } if
		 * (level.toLowerCase().equals("postgraduate taught")){ return
		 * PostgraduateTaught.counter;
		 * 
		 * }
		 * 
		 * return PostgraduateResearch.counter;
		 * 
		 * }
		 */

	/*	List<Student> studentList = new ArrayList<Student>();
		StudentName name;
		Calendar birthDate;
		SmartCard sc;
		Student studentName;
		List modulesList;

		name = new StudentName("Francesco", "Galassi");
		birthDate = new GregorianCalendar(1990, 1, 31);
		sc = SmartCard.getInstance(name, birthDate);
		
		
		studentName = PostgraduateResearch.getInstance(name, sc, birthDate);
		*/
	

	
		
	//	studentList.add(studentName);
	//	List <Student> studentList = new ArrayList <Student>();
		StudentName name;
		Calendar birthDate;
	    SmartCard sc;
		Student s;
		StudentID sID;
		
		//6 9
		 	name = new StudentName("FirstName", "LastName");
			birthDate = new GregorianCalendar(1998,7,31);
			sc = SmartCard.getInstance(name, birthDate);
			sID =StudentID.generateID();
			s=UndergraduateStudent.getInstance(name, sc, birthDate, 6,sID);
			
			ManagementSystem.registerStudent(s);
			 //System.out.println(ManagementSystem.StudentMap.values());
			 System.out.println(s.getDateOfBirth());

			/*ManagementSystem.amendStudent(sID, 6);;
			 System.out.println(ManagementSystem.StudentMap.values());*/

						
	/*				
	name = new StudentName("FirstName", "SecondName");
			birthDate = new GregorianCalendar(1998,7,31);
			sc = SmartCard.getInstance(name, birthDate);
			sID =StudentID.generateID();
			s=UndergraduateStudent.getInstance(name, sc, birthDate, 6,sID);
			ManagementSystem.registerStudent(s);
						*/
			
			name = new StudentName("TestName", "TestSecondName");
			birthDate = new GregorianCalendar(1997,1,15);
	        sc = SmartCard.getInstance(name, birthDate);
			sID =StudentID.generateID();
			s=PostgraduateResearch.getInstance(name, sc, birthDate,sID,2);
			ManagementSystem.registerStudent(s);
			 System.out.println(s.getBirthDate());

			/*
			name = new StudentName("NewTestName", "NewTestSecondName");
			birthDate = new GregorianCalendar(1995,7,31);
			sc = SmartCard.getInstance(name, birthDate);
			sID =StudentID.generateID();
			s=PostgraduateTaught.getInstance(name, sc, birthDate, 9,sID);
			ManagementSystem.registerStudent(s);
			/*
			 
			 
		
			/* System.out.println(ManagementSystem.studentList.get(1));
			 System.out.println('\n');
				System.out.println('\n');
				 System.out.println(ManagementSystem.studentList.get(2));
				 System.out.println('\n');
					System.out.println('\n');
					 System.out.println(ManagementSystem.studentList.get(3));*/
			
					 
					 
UndergraduateStudent ustudent = null;
/*
PostgraduateTaught ptstudent = null;
System.out.println(ManagementSystem.noOfStudents(ptstudent));
		 
PostgraduateResearch prstudent = null;
System.out.println(ManagementSystem.noOfStudents(prstudent));
					*/

		System.out.println('\n');
		System.out.println('\n');
		/*
			
		StudentID delete1 = StudentID.getInstance("a",2);
		StudentID delete2 = StudentID.getInstance("a",1);
		ManagementSystem.terminateStudent(delete1);
		ManagementSystem.terminateStudent(delete2);
		System.out.println('\n');
		System.out.println('\n');
		 System.out.println(ManagementSystem.StudentMap.values());
		*/

		/*
		 * System.out.println(ManagementSystem.noOfStudents(ustudent));*/

	}

	public static void registerStudent(String sName, String studentLevel) {

		/*
		 * List <AbstractStudent> studentList = new ArrayList
		 * <AbstractStudent>();
		 * 
		 * if (studentLevel.toLowerCase().equals("undergraduate")){ StudentID
		 * id; id = StudentID.generateID(); AbstractStudent studentName = new
		 * UndergraduateStudent(sName, "Undergraduate", 40, id);
		 * studentList.add(studentName); } if
		 * (studentLevel.toLowerCase().equals("postgraduate taught")){
		 * AbstractStudent studentName = new PostgraduateTaught(sName,
		 * "Postgraduate Taught", 180, 50); studentList.add(studentName); } if
		 * (studentLevel.toLowerCase().equals("postgraduate research")){
		 * AbstractStudent studentName = new PostgraduateResearch(sName,
		 * "Postgraduate Research", 180, 50); studentList.add(studentName); }
		 */
		// register a new student onto the system and allocates a student ID

	}

}