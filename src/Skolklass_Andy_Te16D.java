import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Skolklass_Andy_Te16D {
	
	ArrayList<String> FirstName = new ArrayList<String>(); // ArrayList för förnamn
	ArrayList<String> LastName = new ArrayList<String>(); // ArrayList för efternamn
	
	public Skolklass_Andy_Te16D(File F) throws FileNotFoundException{
		
		Scanner fileReader = new Scanner(F);
         		
		while(fileReader.hasNextLine()){
	    String name = fileReader.nextLine();
	    FirstName.add(name);
	    
	    int spaceIndex = name.indexOf(" ");
	    String LastNames = name.substring(spaceIndex+1);
	    String FirstNames = name.substring(0, spaceIndex);
	    name = LastNames + " " + FirstNames; // Det kommer börja efternamn först sedan mellanrum, Förnamn
	    
	    LastName.add(name);
	    
		}
		fileReader.close();
	}
	public void printFirstNameOrder(){ // Kod för att skriva ut med Sorteringen efter förnamn
		Collections.sort(FirstName);  
		 for(String namn : FirstName){ 
			System.out.println(namn);
		}
	}
	public void printLastNameOrder(){ // Kod för att skriva ut med sorteringen efter efternamn
		Collections.sort(LastName);
		for(String namn : LastName){
			System.out.println(namn);
		}
	}
	public void randomGroups(int groupSize) {
		Collections.shuffle(LastName);
	}
	

}
