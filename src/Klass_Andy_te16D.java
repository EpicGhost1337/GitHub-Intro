import java.io.File;
import java.io.FileNotFoundException;

public class Klass_Andy_te16D {
	
	public static void main(String[] args) throws FileNotFoundException {
		
 Skolklass_Andy_Te16D TE16D = new Skolklass_Andy_Te16D(new File("namn.txt"));
		
		TE16D.printFirstNameOrder();
		TE16D.printLastNameOrder();
		System.out.println("");
	}
	

}
