
public class StudentName {
	private final String firstName;
	private final String secondName;

	
	StudentName(String firstName, String secondName){
		this.firstName = firstName;
		this.secondName = secondName;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	@Override
	public String toString(){
		return String.format("%s%s%s", getFirst()," ", getSecond());}
}
