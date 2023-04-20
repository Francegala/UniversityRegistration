import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;

public final class SmartCard {
	
	
	private final StudentName name; 
	private final Date birthDate;
	private final SmartCardNumber scNumber;
	private final Date issueDate;
	
	private static final Map<String, SmartCard> NAMES = new HashMap<String, SmartCard>();

	
	private SmartCard(StudentName name, Date birthDate, SmartCardNumber scNumber, Date issueDate) {
		this.name = name;
		this.birthDate = birthDate;
		this.scNumber = scNumber;
		this.issueDate = issueDate;
	}

	public static SmartCard getInstance(StudentName name, Calendar birthDate) {
		
		Date issueDate = new Date();
		Date dbirthDate =  birthDate.getTime();
		
		SmartCardNumber scNumber = SmartCardNumber.getInstance(name, issueDate);
		
		final String k = name.toString() + dbirthDate + scNumber + issueDate ;
		
		if (!NAMES.containsKey(k))
			NAMES.put(k, new SmartCard(name, dbirthDate, scNumber, issueDate));
		return NAMES.get(k);
	}
	
	
	@Override
	public String toString(){
		return String.format("%s%n%s%n%s%n%s%n%s", name.getFirst(), name.getSecond(), getbirthDate(), getscNumber(), getissueDate() );}
	
	
	public StudentName getsName() {
		return new StudentName (name.getFirst(), name.getSecond());
	}

	public SmartCardNumber getscNumber() {
		return scNumber;
	}

	public Date getbirthDate() {
		return (Date) birthDate.clone();
	}

	public Date getissueDate() {
		return  (Date) issueDate.clone();
	}

	
}

