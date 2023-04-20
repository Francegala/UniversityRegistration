import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UndergraduateStudent extends AbstractStudent {
	
	public static int counter;
	
	private static final Map<String, UndergraduateStudent> MAPSTUDENT = new HashMap<String, UndergraduateStudent>();
	private static final List amend = new ArrayList();
	
	public UndergraduateStudent(StudentName studentName, SmartCard studentSC, Calendar studentbDate,int numberOfModules, StudentID studentStudentID) throws IOException, MyException {
		super(studentName, studentSC, studentbDate, numberOfModules, studentStudentID);
		if(!amend.contains(studentStudentID)){	
			counter++;
		amend.add(studentStudentID);
		}
		// TODO Auto-generated constructor stub
	}

	public static UndergraduateStudent getInstance(StudentName studentName, SmartCard studentSC, Calendar studentbDate, int numberOfModules, StudentID studentStudentID) throws MyException, IOException{
		
		Date dbirthDate =  studentbDate.getTime();
		int birthDateYear = studentbDate.get(Calendar.YEAR);
		int todayYear = studentbDate.getInstance().get(Calendar.YEAR);
			if(((todayYear - birthDateYear)>=17)==false){	
				throw new MyException("The student must have more than 16 years");	}
			else{
		final String k = studentName.toString() + studentbDate +  studentSC + numberOfModules;
		
		if (!MAPSTUDENT.containsKey(k))
			MAPSTUDENT.put(k, new UndergraduateStudent(studentName, studentSC, studentbDate, numberOfModules, studentStudentID));
		return MAPSTUDENT.get(k);
		}
}

	
	
	
	
}
