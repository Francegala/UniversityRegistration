package uk;
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

	public UndergraduateStudent(StudentName studentName, Calendar studentbDate, Date dbirthDate, int numberOfModules, String stage, StudentID studentStudentID) throws IOException, MyException {
		super(studentName, studentbDate, dbirthDate, numberOfModules,stage, studentStudentID);
		if(!amend.contains(studentStudentID)){	
			counter++;
			amend.add(studentStudentID);
		}
		// TODO Auto-generated constructor stub
	}

	public static UndergraduateStudent getInstance(StudentName studentName, Calendar studentbDate, int numberOfModules,String stage, StudentID studentStudentID) throws MyException, IOException{


		if(stage.toLowerCase() == "postgraduate"){		
			throw new MyException("Undergraduate students can be only stage 1, 2 ,3");	
		}



		Date dbirthDate =  studentbDate.getTime();
		int birthDateYear = studentbDate.get(Calendar.YEAR);
		int todayYear = studentbDate.getInstance().get(Calendar.YEAR);
		if(((todayYear - birthDateYear)>=17)==false){	
			throw new MyException("The student must be more than 16 years old");	}
		else{
			final String k = studentName.toString() + studentbDate +   numberOfModules + stage + studentStudentID;

			if (!MAPSTUDENT.containsKey(k))
				MAPSTUDENT.put(k, new UndergraduateStudent(studentName, studentbDate, dbirthDate, numberOfModules, stage, studentStudentID));
			return MAPSTUDENT.get(k);
		}
	}

	@Override
	public String getPassmark() {
		return "Passmark for undergraduate modules is 40%";
	}





}
