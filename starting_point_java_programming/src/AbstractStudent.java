import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public abstract class AbstractStudent implements Student {
	
	
	private final StudentID studentStudentID;
	private final StudentName studentName;
	private final SmartCard studentSC;
	private final Calendar studentbDate;
	private final Module module;

		
	public AbstractStudent(StudentName studentName, SmartCard studentSC, Calendar studentbDate, int numberOfModules, StudentID studentStudentID) throws IOException, MyException  {
			
		Module module = new Module (numberOfModules);
		this.module=module;
		
		this.module.getCredits(this.getClass());
		
		this.studentName = studentName;
		this.studentStudentID = studentStudentID;
		this.studentSC = studentSC;
		this.studentbDate = studentbDate;
		
	}
		

	
	@Override
	public Supervisor supervisorName() {
		try {
			throw new MyException("Only Postgraduate research have supervisors");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public StudentID getStudentID() {
		// TODO Auto-generated method stub
		return studentStudentID;
	}

	@Override
	public Module getModule() {
		// TODO Auto-generated method stub
		return module;
	}

	@Override
	public SmartCard getSmartcard() {
		// TODO Auto-generated method stub
		return studentSC;
	}

	@Override
	public StudentName getName() {
		// TODO Auto-generated method stub
		return studentName;
	}
	
	@Override
	public String toString(){
		return String.format("%s%n%n%n%s%n%n%n%s%n%n%n%s", studentStudentID, studentName,  studentSC, module);}

	
	@Override
	public Calendar getDateOfBirth() {
		// TODO Auto-generated method stub
		return this.studentbDate;
	}

	@Override
	public Date getBirthDate() {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
	


		


