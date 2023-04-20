

import java.util.HashMap;
import java.util.Map;

public final class StudentID {
	private final String letter;
	private final int number;
	private static final Map<String, StudentID> NAMES = new HashMap<String, StudentID>();
	private static final char[] letters= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static int fra=0;
	private static int azs=0;
	
	private StudentID(String letter, int number) {
		this.letter = letter;
		this.number = number;
	}

	public static StudentID getInstance(String letter, int number) {

		final String k = letter + number;
		if (!NAMES.containsKey(k))
			NAMES.put(k, new StudentID(letter, number));
		return NAMES.get(k);
	}
	
	

	public String getLetter() {
		return letter;
	}

	public String getNumber() {
		return String.format("%04d", number);	}
	
	
	
	public static StudentID generateID() {
		StudentID aaa;
		aaa= getInstance(String.valueOf(letters[fra]),azs);
		azs++;
		if(azs==9999){fra++;
		azs=0;}
		if(fra==26){fra=0;}
		return aaa;
	}
	


	@Override
	public String toString(){
		return String.format("%s%s%s","StudentID: ", getLetter(), getNumber());
 
	}
}
