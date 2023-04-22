package uk;


import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public final class StudentID {
	private String letter;
	private int number;
	private static final Map<String, StudentID> STUDENTIDMAP = new HashMap<String, StudentID>();
	private static final char[] letters= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static int counterLetter=0;
	private static int counterNumber=0;
	
	private StudentID(String letter, int number) {
		this.letter = letter;
		this.number = number;
	}

	public static StudentID getInstance() throws MyException {

		String letter = String.valueOf(letters[counterLetter]);
		int number = counterNumber;
		
		final String k = letter + number;
		
		counterNumber++;
		if(counterNumber==9999){counterLetter++;
		counterNumber=0;}
		if(counterLetter==26){		
			throw new MyException("You have reached the StudentID limit");
}
		
		if (!STUDENTIDMAP.containsKey(k))
			STUDENTIDMAP.put(k, new StudentID(letter, number));
		return STUDENTIDMAP.get(k);
	}
	
	

	public String getLetter() {
		return letter;
	}

	public int getNumber() {
		return number;	
		}
	
	
	

	@Override
	public String toString(){
		return String.format("%s%04d",getLetter(), getNumber());
 
	}
	
	
	
	
}
