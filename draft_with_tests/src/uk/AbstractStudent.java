package uk;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public abstract class AbstractStudent implements Student {

	private final StudentID studentStudentID;
	private final StudentName studentName;
	private SmartCard studentSC;
	private final Calendar studentbDate;
	private final Module module;
	private final Date dbirthDate;

	public AbstractStudent(StudentName studentName, Calendar studentbDate, Date dbirthDate, int numberOfModules,
			String stage, StudentID studentStudentID) throws IOException, MyException {

		Module module = new Module(numberOfModules, stage);
		this.module = module;

		this.module.getCredits(this.getClass());

		this.dbirthDate = dbirthDate;

		this.studentName = studentName;
		this.studentStudentID = studentStudentID;
		this.studentbDate = studentbDate;

	}

	public Supervisor getSupervisor() throws MyException {
		
			throw new MyException("Only Postgraduate research students should have supervisors");
	
	}

	public StudentID getStudentID() {
		// TODO Auto-generated method stub
		return studentStudentID;
	}

	public Module getModule() {
		// TODO Auto-generated method stub
		return module;
	}

	public SmartCard getSmartcard() {
		// TODO Auto-generated method stub
		return studentSC;
	}

	public StudentName getName() {
		StudentName sN = null;
		try {
			sN = StudentName.valueOf(studentName.getFirst() + " " +  studentName.getSecond());
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sN;
	}

	public Calendar getDateOfBirth() {
		// TODO Auto-generated method stub
		return (Calendar) studentbDate.clone();

	}

	
	public Date getBirthDate() {
		// TODO Auto-generated method stub
		return (Date) dbirthDate.clone();
	}

	public int getAge() {
		Date dbirthDate = studentbDate.getTime();
		int birthDateYear = studentbDate.get(Calendar.YEAR);
		int todayYear = studentbDate.getInstance().get(Calendar.YEAR);

		return (todayYear - birthDateYear);
	}

	
	public void setSmartCard(SmartCard smartCard) {
		this.studentSC = smartCard;
	}

	@Override
	public String toString() {
		return String.format("%s%n%n%n%s%n%n%n%s%n%n%n%s%n", studentStudentID, studentName, studentSC, module);
	}

}
