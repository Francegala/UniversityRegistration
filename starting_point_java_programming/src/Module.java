import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module {
	private final List moduleName = new ArrayList<String>();
	private final List moduleCode = new ArrayList<String>();
	private final List<Integer> moduleCredits = new ArrayList<>();
	private final List arrayofModules;
	
	
	public Module(int a) throws IOException {
		
		this.arrayofModules = readModuleFile();
		int i=0;
			while(a>0){
			
		this.moduleName.add(arrayofModules.get(i));
		this.moduleCode.add(arrayofModules.get(i+1));
		int nm = Integer.parseInt((String) arrayofModules.get(i+2));
		this.moduleCredits.add((nm));
		a = a - 1; 
		i+=3;

	}
	}
	
	public static List readModuleFile() throws IOException {
		List arrayofstring = new ArrayList();

		String[] moduleArray;
		
		FileReader from = new FileReader("Modules.txt");
		Scanner source = new Scanner(from);

		while (source.hasNextLine()) {
			moduleArray = source.nextLine().split("\\, ");

			from.close();

			for (int i = 0; i < moduleArray.length; i++) {
				arrayofstring.add(moduleArray[i]);
			}
		}
		/*for (int i=0;i<arrayofstring.size();i++)
		System.out.println( arrayofstring.get(i));
*/
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
