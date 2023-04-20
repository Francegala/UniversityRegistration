import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class PostgraduateResearch implements Student{
		
		public static int counter;
		private final StudentID pgrStudentID;
		private final StudentName pgrName;
		private final SmartCard pgrSC;
		private final Date dbirthDate;
		private final Calendar pgrbirthDate;
		private final Supervisor pgrSupervisor;
		private static final Map<String, PostgraduateResearch> MAPRESEARCH = new HashMap<String, PostgraduateResearch>();

		
		private PostgraduateResearch( StudentName pgrName, SmartCard pgrSC, Calendar pgrbirthDate, Date dbirthDate, StudentID pgrStudentID, int supervisorNumber) throws FileNotFoundException {
		
			Supervisor pgrSupervisor = new Supervisor(supervisorNumber);
			this.pgrName = pgrName;
			this.pgrStudentID = pgrStudentID;
			this.pgrSC = pgrSC;
			this.pgrbirthDate = pgrbirthDate;
			this.dbirthDate= dbirthDate;
			this.pgrSupervisor = pgrSupervisor;
			counter++;
		}

		public static PostgraduateResearch getInstance( StudentName pgrName, SmartCard pgrSC, Calendar pgrbirthDate, StudentID pgrStudentID, int supervisorNumber) throws FileNotFoundException, MyException  {
			
			Date dbirthDate =  pgrbirthDate.getTime();
			int birthDateYear = pgrbirthDate.get(Calendar.YEAR);
			int todayYear = pgrbirthDate.getInstance().get(Calendar.YEAR);
			if(((todayYear - birthDateYear)>=20)==false)	
			//if(checkAge(todayYear))
			{		throw new MyException("The student must have more than 19 years");	}
				else{
			final String k = pgrName.toString() + pgrbirthDate +  pgrSC ;
			
			if (!MAPRESEARCH.containsKey(k))
				MAPRESEARCH.put(k, new PostgraduateResearch(pgrName, pgrSC, pgrbirthDate, dbirthDate, pgrStudentID, supervisorNumber));
			return MAPRESEARCH.get(k);}
				
				
		}

	

		@Override
		public StudentID getStudentID() {
			return pgrStudentID;
		}

		

		
		public Supervisor supervisorName() {
			return pgrSupervisor;
		}
		
			
		public Date getBirthDate() {
			return (Date)dbirthDate.clone();
		}
		

		@Override
		public SmartCard getSmartcard() {
			return pgrSC;
		}

		@Override
		public StudentName getName() {
			return new StudentName( pgrName.getFirst(), pgrName.getSecond());
		}

	
		@Override
		public String toString(){
			return String.format("%s%n%n%n%s%n%n%n%s%n%n%n%s", pgrStudentID, pgrName,  pgrSC, pgrSupervisor);}

		
		
		@Override
		public Module getModule() {
			try {
				throw new MyException("Postgraduate research doesn't have modules");
			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public Calendar getDateOfBirth() {
			return (Calendar) pgrbirthDate.clone();
		}
		

		
		/*@Override
		public static boolean checkAge(int birthDateYear) {
			  
			int todayYear = pgrbirthDate.getInstance().get(Calendar.YEAR);
			return ((todayYear - birthDateYear)>=20);
				
		}*/
		


	/*	@Override
		public String passmark() {
			return null;
		}*/
		
		
		/*@Override
		public int NoOfStudent() {
			return counter;
		}*/
		
		
	}
	
