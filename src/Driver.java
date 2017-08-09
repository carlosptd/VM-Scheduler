
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * Driver for the different algorithms  
 * @author Carlos Perez 
 */
public class Driver {

	Scanner read = new Scanner(System.in);
	Fifo fifo; 
	LRU lru;
	MRU mru; 
	Optimal optimal; 
	ReadFile file; 
	/**
	 * Default constructor 
	 * @param file contains reference string that are passed to the different 
	 * classes containing the algorithm 
	 */
	public Driver(ReadFile file) {
		this.file = file; 		
	}

	/**
	 * Starts the execution
	 * @throws IOException 
	 */	
	public void run() throws IOException {
		int selection;
		menu();
		System.out.print("->"); 
		selection = Integer.parseInt(read.next()); 
		execute(selection);
	}
	/**
	 * Menu to select the algorithm 
	 */
	public void menu() {
		System.out.println("Select Algorithm:");
		System.out.println("1 FIFO");
		System.out.println("2 LRU");
		System.out.println("3 MRU");
		System.out.println("4 Optimal");
		System.out.println("5 All"); 
	}
	/**
	 * Executiong of the algorithm based on input
	 * @param selection of algorithm 
	 */
	private void execute(int selection) {
		System.out.println(" Size  #pages   ALG   Page fault %  Page Faults");
		switch (selection) {
			case 1: fifo = new Fifo(file); break; 
			case 2: lru = new LRU(file); break; 
			case 3: mru = new MRU(file); break; 
			case 4: optimal = new Optimal(file); break; 
			case 5:
				System.out.println("********* fifo **************"); 
				fifo = new Fifo(file); 
				System.out.println("********* lru ***************"); 
				lru = new LRU(file); 
				System.out.println("************ mru ************"); 
				mru = new MRU(file); 
				System.out.println("************ optimal ********"); 
				optimal = new Optimal(file); 
				break;

		}
	}

}
