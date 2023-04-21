package uk;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentName {
	private final String firstName;
	private final String secondName;


	 private StudentName(String firstName, String secondName){
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public String getFirst() {
		return firstName;
	}

	public String getSecond() {
		return secondName;
	}

	public String getInitials() {
		String fistLetter = getFirst().substring(0, 1);
		String secondLetter = getSecond().substring(0, 1);
		String initials = fistLetter + secondLetter;
		return initials;
	}


	public static StudentName valueOf(String s) throws MyException{ 
		try {
		String[] namString = s.split(" ");
		return new StudentName(namString[0], namString[1] );
		}
		catch (Exception general) {
			throw new MyException("Name should be format \"First Name\" \" \" \"Second Name\"");
		} 
		}
		
			

	@Override
	public String toString(){
		return String.format("%s%s%s", getFirst()," ", getSecond());}
	
	

}
