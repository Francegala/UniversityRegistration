import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementSystem {
	public static final  Map<StudentID, Student> StudentMap = new HashMap<StudentID, Student>();

	
	public static int noOfStudents(UndergraduateStudent student){
		return UndergraduateStudent.counter;
		}
	
	
	public static int noOfStudents(PostgraduateTaught student){
		return PostgraduateTaught.counter;
		}
	
	
	public static int noOfStudents(PostgraduateResearch student){
		return PostgraduateResearch.counter;
		}
	
	
	
	public static void registerStudent(Student s){
	  
		StudentMap.put(s.getStudentID(), s);
		  	
	}
	 


	 public static void amendStudent(StudentID sID, int newModule) throws MyException, IOException{
		 
		
		StudentMap.put(sID, UndergraduateStudent.getInstance(StudentMap.get(sID).getName(), StudentMap.get(sID).getSmartcard(), StudentMap.get(sID).getDateOfBirth(), newModule, sID));
		}
	 
	 
	
 public static void amendStudent(StudentID sID, Supervisor newSupervisor) throws MyException, IOException{
		 
		
		 		// StudentMap.put(sID, UndergraduateStudent.getInstance(studentName, SmartCard.getInstance(studentName, StudentMap.get(sID).getDateOfBirth()),  StudentMap.get(sID).getDateOfBirth(), StudentMap.get(sID).getModule().getCredits(),sID));
		
	 }
	 
	
	 
	
	public static void terminateStudent(StudentID sID){
		
		StudentMap.remove(sID);

	}

	
}
