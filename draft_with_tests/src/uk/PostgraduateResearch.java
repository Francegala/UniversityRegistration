package uk;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PostgraduateResearch implements Student{

	public static int counter;
	private final StudentID pgrStudentID;
	private final StudentName pgrName;
	private SmartCard pgrSC;
	private final Date dbirthDate;
	private final Calendar pgrbirthDate;
	private final Supervisor pgrSupervisor;
	private static final Map<String, PostgraduateResearch> MAPRESEARCH = new HashMap<String, PostgraduateResearch>();
	private static final List amend = new ArrayList();


	private PostgraduateResearch( StudentName pgrName, Calendar pgrbirthDate, Date dbirthDate, StudentID pgrStudentID, int supervisorNumber) throws FileNotFoundException {

		Supervisor pgrSupervisor = new Supervisor(supervisorNumber);
		this.pgrName = pgrName;
		this.pgrStudentID = pgrStudentID;
		this.pgrbirthDate = pgrbirthDate;
		this.dbirthDate= dbirthDate;
		this.pgrSupervisor = pgrSupervisor;

		if(!amend.contains(pgrStudentID)){	
			counter++;
			amend.add(pgrStudentID);
		}
	}

	public static PostgraduateResearch getInstance( StudentName pgrName, Calendar pgrbirthDate, StudentID pgrStudentID, int supervisorNumber) throws FileNotFoundException, MyException  {

		Date dbirthDate =  pgrbirthDate.getTime();
		int birthDateYear = pgrbirthDate.get(Calendar.YEAR);
		int todayYear = pgrbirthDate.getInstance().get(Calendar.YEAR);
		if(((todayYear - birthDateYear)>=20)==false)	
		{		throw new MyException("The student must have more than 19 years");	}
		else{
			final String k = pgrName.toString() + pgrbirthDate +  supervisorNumber + pgrStudentID;

			if (!MAPRESEARCH.containsKey(k))
				MAPRESEARCH.put(k, new PostgraduateResearch(pgrName, pgrbirthDate, dbirthDate, pgrStudentID, supervisorNumber));
			return MAPRESEARCH.get(k);}


	}



	
	public StudentID getStudentID() {
		return pgrStudentID;
	}




	public Supervisor getSupervisor() {
		return pgrSupervisor;
	}


	public Date getBirthDate() {
		return (Date)dbirthDate.clone();
	}


	
	public SmartCard getSmartcard() {
		return pgrSC;
	}

	
	public StudentName getName() {
			StudentName sN = null;
			try {
				sN = StudentName.valueOf(pgrName.getFirst() + " " +  pgrName.getSecond());
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return sN;
	}	
	



	
	public Module getModule() {
		try {
			throw new MyException("Postgraduate research student doesn't have modules");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public Calendar getDateOfBirth() {
		return (Calendar) pgrbirthDate.clone();
	}

	
	public int getAge() {
		Date dbirthDate =  pgrbirthDate.getTime();
		int birthDateYear = pgrbirthDate.get(Calendar.YEAR);
		int todayYear = pgrbirthDate.getInstance().get(Calendar.YEAR);

		return (todayYear - birthDateYear);
	}

	
	public String getPassmark() {
		getModule();
		return null;
	}

	
	public void setSmartCard(SmartCard smartCard) {
		this.pgrSC = smartCard;

	}



	@Override
	public String toString(){
		return String.format("%s%n%n%n%s%n%n%n%s%n%n%n%s%n", pgrStudentID, pgrName,  pgrSC, pgrSupervisor);}








}

