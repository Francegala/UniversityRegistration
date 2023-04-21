package uk;
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
		SmartCard sc;
		sc = new SmartCard(s.getName(), s.getDateOfBirth());
		s.setSmartCard(sc);
		StudentMap.put(s.getStudentID(), s);

	}



	public static void amendStudent(StudentID sID, String newStage) throws MyException, IOException{

		if(StudentMap.get(sID).getClass()== UndergraduateStudent.class){	



			if(newStage.toLowerCase()=="three"){
				SmartCard copy =StudentMap.get(sID).getSmartcard();
				StudentMap.put(sID, UndergraduateStudent.getInstance(StudentMap.get(sID).getName(), StudentMap.get(sID).getDateOfBirth(), 12, newStage , sID));
				StudentMap.get(sID).setSmartCard(copy);

			}
			else{		
				SmartCard copy =StudentMap.get(sID).getSmartcard();
				StudentMap.put(sID, UndergraduateStudent.getInstance(StudentMap.get(sID).getName(), StudentMap.get(sID).getDateOfBirth(),6, newStage , sID));
				StudentMap.get(sID).setSmartCard(copy);

			}




		}
		else{


			throw new MyException("You can change only Undergraduate stage");


		}
	}




	public static void amendStudent(StudentID sID, int newSupervisor) throws MyException, IOException{

		if(StudentMap.get(sID).getClass()== UndergraduateStudent.class || StudentMap.get(sID).getClass()== PostgraduateTaught.class){	
			throw new MyException("you cannot amend a supervisor of an Undergraduate,or postgraduate taught, Only Postgraduate research have supervisors");
		}
		else{

			SmartCard copy =StudentMap.get(sID).getSmartcard();
			StudentMap.put(sID, PostgraduateResearch.getInstance( StudentMap.get(sID).getName(), StudentMap.get(sID).getDateOfBirth(), sID, newSupervisor));
			StudentMap.get(sID).setSmartCard(copy);

		}	
	}




	public static void terminateStudent(StudentID sID) throws MyException{

		if(!StudentMap.containsKey(sID)){throw new MyException("The student you're trying to terminate does not exist");
		}
		else{
			if(StudentMap.get(sID).getClass()== UndergraduateStudent.class){UndergraduateStudent.counter-=1;}
			if(StudentMap.get(sID).getClass()== PostgraduateTaught.class){PostgraduateTaught.counter-=1;}
			if(StudentMap.get(sID).getClass()== PostgraduateResearch.class){PostgraduateResearch.counter-=1;}
			StudentMap.remove(sID);
		}


	}


}

