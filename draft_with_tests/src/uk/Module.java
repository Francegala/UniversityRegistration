package uk;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module {
	//moduleS 
	private final List moduleName = new ArrayList<String>();
	private final List moduleCode = new ArrayList<String>();
	private final List<Integer> moduleCredits = new ArrayList<>();
	private final List arrayofModules;


	public Module(int a, String stage ) throws IOException, MyException {



		this.arrayofModules = readModuleFile(valueOf(stage));


		int i=0;
		while(a>0){

			this.moduleName.add(arrayofModules.get(i));
			this.moduleCode.add(arrayofModules.get(i+1));
			int nm = Integer.valueOf((String) arrayofModules.get(i+2));
			this.moduleCredits.add((nm));
			a = a - 1; 
			i+=3;

		}
	}




	public static int valueOf(String s) throws MyException{ 



		switch (s.toLowerCase()) {
		case "one":return 1;
		case "two":return 2;
		case "three":return 3;
		case "postgraduate":return 4;
		default: throw new MyException("Error in selecting the stage, it should be stage \"one\", \"two\",\"three\" or \"postgraduate\" ");	

		}


	}






	public static List readModuleFile(int stage) throws IOException {
		List arrayofstring = new ArrayList();

		String[] moduleArray;
		FileReader from = null;

		if (stage == 1){
			from = new FileReader("Modules.txt");
		}
		if (stage == 2){
			from = new FileReader("Modules2.txt");
		}
		if (stage == 3){
			from = new FileReader("Modules3.txt");
		}
		if (stage == 4){
			from = new FileReader("Modulespost.txt");
		}



		Scanner source = new Scanner(from);

		while (source.hasNextLine()) {
			moduleArray = source.nextLine().split("\\, ");

			from.close();

			for (int i = 0; i < moduleArray.length; i++) {
				arrayofstring.add(moduleArray[i]);
			}
		}

		return arrayofstring;
	}


	public void getCredits(Class c) throws MyException{		
		int actualCredits = 0;
		for (int i = 0; i < moduleCredits.size(); i++) {
			actualCredits = actualCredits + moduleCredits.get(i);
		}

		if(c == UndergraduateStudent.class){		
			if (actualCredits !=120)throw new MyException("The student should take the right number of credits e.g. Undergraduate = 120");	
		}


		if(c == PostgraduateTaught.class){		
			if (actualCredits !=180)throw new MyException("The student should take the right number of credits e.g. Postgraduate Taught = 180");	
		}


	}


	public int getNumModules(){
		return this.moduleName.size();

	}

	@Override	
	public String toString(){

		String first="Modules:" + '\n';
		String second="";

		for (int c = 0; c < moduleName.size(); c++){
			second = first + moduleName.get(c) +" "+ moduleCode.get(c) +" " + moduleCredits.get(c) + '\n';
			first = second;}


		return second;

	}
}
