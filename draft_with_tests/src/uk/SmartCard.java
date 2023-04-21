package uk;
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


	public SmartCard(StudentName name, Calendar birthDate) {

		Date issueDate = new Date();
		Date dbirthDate =  birthDate.getTime();

		SmartCardNumber scNumber = SmartCardNumber.getInstance(name, issueDate);

		this.name = name;
		this.birthDate = dbirthDate;
		this.scNumber = scNumber;
		this.issueDate = issueDate;
	}



	public StudentName getName()  throws MyException {
			StudentName sN;
			sN= StudentName.valueOf(name.getFirst() + " " +  name.getSecond());
			return sN;
		}

	public SmartCardNumber getScNumber() {
		return scNumber;
	}

	public Date getBirthDate() {
		return (Date) birthDate.clone();
	}

	public Date getIssueDate() {
		return  (Date) issueDate.clone();
	}

	@Override
	public String toString(){
		return String.format("%s%n%s%n%s%n%s%n%s", name.getFirst(), name.getSecond(), getBirthDate(), getScNumber(), getIssueDate() );}

}

