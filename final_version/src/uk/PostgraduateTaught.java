package uk;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgraduateTaught extends AbstractStudent {

	public static int counter;

	private static final Map<String, PostgraduateTaught> MAPSTUDENT = new HashMap<String, PostgraduateTaught>();
	private static final List amend = new ArrayList();


	private PostgraduateTaught(StudentName studentName, Calendar studentbDate, Date dbirthDate, int numberOfModules,String stage, StudentID studentStudentID)
			throws IOException, MyException {
		super(studentName, studentbDate, dbirthDate, numberOfModules,stage, studentStudentID);
		if(!amend.contains(studentStudentID)){	
			counter++;
			amend.add(studentStudentID);
		}
		// TODO Auto-generated constructor stub
	}


	public static PostgraduateTaught getInstance(StudentName studentName, Calendar studentbDate, int numberOfModules, String stage, StudentID studentStudentID) throws MyException, IOException{


		if(stage.toLowerCase() != "postgraduate"){		
			throw new MyException("Postgraduate students can be only stage \"postgraduate\"");	
		}



		Date dbirthDate =  studentbDate.getTime();
		int birthDateYear = studentbDate.get(Calendar.YEAR);
		int todayYear = studentbDate.getInstance().get(Calendar.YEAR);
		if(((todayYear - birthDateYear)>=20)==false){	
			throw new MyException("The student must have more than 19 years");	}
		else{
			final String k = studentName.toString() + studentbDate +  numberOfModules + stage + studentStudentID;

			if (!MAPSTUDENT.containsKey(k))
				MAPSTUDENT.put(k, new PostgraduateTaught(studentName, studentbDate,dbirthDate, numberOfModules, stage, studentStudentID));
			return MAPSTUDENT.get(k);
		}
	}

	@Override
	public String getPassmark() {
		return "Passmark for postgraduate modules is 50%";
	}



}


