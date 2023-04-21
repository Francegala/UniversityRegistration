package uk;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Supervisor {

	private final String firstName;
	private final String secondName;


	public Supervisor(int which) throws FileNotFoundException{
		FileReader from = new FileReader("Supervisor.txt");
		Scanner source = new Scanner (from);

		for(int i=0;i<which;i++){
			String jump = source.nextLine();
		}

		source.useDelimiter(", |\n");
		this.firstName = source.next();
		this.secondName = source.next();

	}


	public String getFirst() {
		return firstName;
	}

	public String getSecond() {
		return secondName;
	}


	@Override
	public String toString(){

		return String.format("%s%s%s%s","Supervisor Name: ", getFirst()," ",getSecond());}
}


