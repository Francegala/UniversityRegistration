import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PostgraduateTaught extends AbstractStudent {
	
	public static int counter;
	
	private static final Map<String, PostgraduateTaught> MAPSTUDENT = new HashMap<String, PostgraduateTaught>();


	public PostgraduateTaught(StudentName studentName, SmartCard studentSC, Calendar studentbDate, int numberOfModules, StudentID studentStudentID)
			throws IOException, MyException {
		super(studentName, studentSC, studentbDate, numberOfModules, studentStudentID);
		counter++;
		// TODO Auto-generated constructor stub
	}
	
	
	public static PostgraduateTaught getInstance(StudentName studentName, SmartCard studentSC, Calendar studentbDate, int numberOfModules, StudentID studentStudentID) throws MyException, IOException{
		
		Date dbirthDate =  studentbDate.getTime();
		int birthDateYear = studentbDate.get(Calendar.YEAR);
		int todayYear = studentbDate.getInstance().get(Calendar.YEAR);
			if(((todayYear - birthDateYear)>=17)==false){	
				throw new MyException("The student must have more than 16 years");	}
			else{
		final String k = studentName.toString() + studentbDate +  studentSC + numberOfModules;
		
		if (!MAPSTUDENT.containsKey(k))
			MAPSTUDENT.put(k, new PostgraduateTaught(studentName, studentSC, studentbDate, numberOfModules, studentStudentID));
		return MAPSTUDENT.get(k);
		}
}




	
}

	
	