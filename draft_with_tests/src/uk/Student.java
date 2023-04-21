package uk;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface Student {
	StudentID getStudentID();
	Module getModule ();
	Supervisor getSupervisor ()throws MyException;
	SmartCard getSmartcard ();
	StudentName getName();
	Calendar getDateOfBirth();
	 Date getBirthDate();
	 int getAge();
	 String getPassmark();
	 void setSmartCard(SmartCard smartCard);
}
