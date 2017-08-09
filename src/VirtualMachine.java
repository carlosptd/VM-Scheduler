
import java.io.IOException;
/**
 * Started Class 
 * @author Carlos Perez
 */
public class VirtualMachine {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
	
		ReadFile read = new ReadFile(); 
		Driver driver = new Driver(read); 
		driver.run();
	}
	
}
