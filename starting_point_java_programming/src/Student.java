import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface Student {
	StudentID getStudentID();
	Module getModule ();
	Supervisor supervisorName ();
	SmartCard getSmartcard ();
	StudentName getName();
	Calendar getDateOfBirth();
	 Date getBirthDate();
	//boolean checkAge(int birthDateYear);  date of birth calendar or date
	//String passmark(); // insidemark? 40%
}
