
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads address from the input file and converts them to a 
 * reference string, which is placed into a three different lists 
 * @author Carlos Perez 
 */
public class ReadFile {
	ArrayList<Integer> referenceString512 = new ArrayList<>(); 
	ArrayList<Integer> referenceString1024 = new ArrayList<>(); 
	ArrayList<Integer> referenceString2048 = new ArrayList<>(); 

	/**
	 * Default Constructor
	 * @throws IOException 
	 */
	public ReadFile() throws IOException {
		readfile();
	}

	/**
	 * Reads input file and converts address into reference strings  
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	public void readfile() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new java.io.FileReader("inputfileforpart2.dat"));
		int address,referenceString;
		try {
			String line = br.readLine(); 
			
			while (line != null) {
				address = Integer.parseInt(line); 
				referenceString = address/512;
				referenceString512.add(referenceString); 
				referenceString = address/1024; 
				referenceString1024.add(referenceString); 
				referenceString = address/2048;
				referenceString2048.add(referenceString); 
				line = br.readLine();
			}
		} finally {
			br.close();
		}
	}

	/**
	 * Prints Reference string for a size 512
	 */
	public void print512(){
		for (Integer integer : referenceString512) {
			System.out.println(integer);
		}
	}
	/**
	 * Prints reference string for a size 1024
	 */
	public void print1024(){
		for (Integer integer : referenceString1024) {
			System.out.println(integer); 
		}
	}
	/**
	 * Prints reference string for a size 2048
	 */
	public void print2048(){
		for (Integer integer : referenceString2048) {
			System.out.println(integer); 
		}
	}

}
