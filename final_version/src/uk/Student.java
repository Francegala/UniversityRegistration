package uk;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface Student {
	StudentID getStudentID();
	Modules getModule () throws MyException;
	Supervisor getSupervisor ()throws MyException;
	SmartCard getSmartcard ();
	StudentName getName();
	Calendar getDateOfBirth();
	 Date getBirthDate();
	 int getAge();
	 String getPassmark() throws MyException;
	 void setSmartCard(SmartCard smartCard);
}
