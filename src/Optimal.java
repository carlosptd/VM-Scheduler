
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * Performs the optimal algorithm for a virtual memory
 * @author Carlos Perez
 */
public class Optimal {

	ReadFile file; 
	int [] frame4 = new int[4]; 
	int [] frame8 = new int [8]; 
	int [] frame12 = new int [12]; 	
	int [] indexes = new int[3]; 
		
	/**
	 * Default constructor 
	 * @param file containg the reference strings 
	 */
	public Optimal(ReadFile file) {
		this.file = file;
		run512(); 
		run1024();
		run2048(); 
	}
	/**
	 * Runs a 512 size reference string by checking if the reference string 
	 * exist in the current memory
	 * If it does not exist then perform the algorithm and add one to the 
	 * number of page faults
	 */
	private void run512(){
		reset(); 
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true; 
		int pageFaults4 =0,pageFaults8 = 0,pageFaults12 = 0; 
		ArrayList<Integer> array = file.referenceString512; 
		array.add(-1); 

		for (int x = 0; x < array.size()-1; x++) {
			int inputFrame = array.get(x); 
		 	for (int i = 0; i < frame4.length; i++) 
				if(frame4[i] == inputFrame)
					pagefault4 = false; 

			for (int j = 0; j <frame8.length; j++) 
				if(frame8[j] == inputFrame)
					pagefault8 = false; 	
			
			for (int i = 0; i < frame12.length; i++) 
				if(frame12[i] == inputFrame)
					pagefault12 = false; 
	
			if(pagefault4){
				countPageFaults(frame4,array,x,inputFrame,0); 
				pageFaults4++; 
			}

			if(pagefault8){
				countPageFaults(frame8,array,x,inputFrame,1); 
				pageFaults8++; 
			}

			if(pagefault12){
				countPageFaults(frame12,array,x,inputFrame,2); 
				pageFaults12++; 
			}

			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 
		}
		System.out.printf("  512	4	Optimal	%.2f%%		%d\n",
			((float)pageFaults4/(array.size()-1))*100,pageFaults4); 
		System.out.printf("  512	8	Optimal	%.2f%%		%d\n",
			((float)pageFaults8/(array.size()-1))*100,pageFaults8); 
		System.out.printf("  512	12	Optimal	%.2f%%		%d\n",
			((float)pageFaults12/(array.size()-1))*100,pageFaults12); 


	}
	/**
	 * Runs a 2048 size reference string by checking if the reference string 
	 * exist in the current memory
	 * If it does not exist then perform the algorithm and add one to the 
	 * number of page faults
	 */
	private void run2048(){
		reset(); 
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true; 
		int pageFaults4 =0,pageFaults8 = 0,pageFaults12 = 0; 
		ArrayList<Integer> array = file.referenceString2048; 
		array.add(-1); 
		
		for (int x = 0; x < array.size()-1; x++) {
			int inputFrame = array.get(x); 
		 	for (int i = 0; i < frame4.length; i++) 
				if(frame4[i] == inputFrame)
					pagefault4 = false; 

			for (int j = 0; j <frame8.length; j++) 
				if(frame8[j] == inputFrame)
					pagefault8 = false; 	
			
			for (int i = 0; i < frame12.length; i++) 
				if(frame12[i] == inputFrame)
					pagefault12 = false; 
	
			if(pagefault4){
				countPageFaults(frame4,array,x,inputFrame,0); 
				pageFaults4++; 
			}

			if(pagefault8){
				countPageFaults(frame8,array,x,inputFrame,1); 
				pageFaults8++; 
			}

			if(pagefault12){
				countPageFaults(frame12,array,x,inputFrame,2); 
				pageFaults12++; 
			}

			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 
		}
		System.out.printf("  2048	4	Optimal	%.2f%%		%d\n",
			((float)pageFaults4/(array.size()-1))*100,pageFaults4); 
		System.out.printf("  2048	8	Optimal	%.2f%%		%d\n",
			((float)pageFaults8/(array.size()-1))*100,pageFaults8); 
		System.out.printf("  2048	12	Optimal	%.2f%%		%d\n",
			((float)pageFaults12/(array.size()-1))*100,pageFaults12); 




	}
	/**
	 * Runs a 1024 size reference string by checking if the reference string 
	 * exist in the current memory
	 * If it does not exist then perform the algorithm and add one to the 
	 * number of pagefaults
	 */
	private void run1024(){
		reset(); 
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true; 
		int pageFaults4 =0,pageFaults8 = 0,pageFaults12 = 0; 
		ArrayList<Integer> array = file.referenceString1024; 
		array.add(-1); 
		
		for (int x = 0; x < array.size()-1; x++) {
			int inputFrame = array.get(x); 
		 	for (int i = 0; i < frame4.length; i++) 
				if(frame4[i] == inputFrame)
					pagefault4 = false; 

			for (int j = 0; j <frame8.length; j++) 
				if(frame8[j] == inputFrame)
					pagefault8 = false; 	
			
			for (int i = 0; i < frame12.length; i++) 
				if(frame12[i] == inputFrame)
					pagefault12 = false; 
	
			if(pagefault4){
				countPageFaults(frame4,array,x,inputFrame,0); 
				pageFaults4++; 
			}

			if(pagefault8){
				countPageFaults(frame8,array,x,inputFrame,1); 
				pageFaults8++; 
			}

			if(pagefault12){
				countPageFaults(frame12,array,x,inputFrame,2); 
				pageFaults12++; 
			}

			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 
		}
		System.out.printf("  1024	4	Optimal	%.2f%%		%d\n",
			((float)pageFaults4/(array.size()-1))*100,pageFaults4); 
		System.out.printf("  1024	8	Optimal	%.2f%%		%d\n",
			((float)pageFaults8/(array.size()-1))*100,pageFaults8); 
		System.out.printf("  1024	12	Optimal	%.2f%%		%d\n",
			((float)pageFaults12/(array.size()-1))*100,pageFaults12); 



	}
	/**
	 * Performs optimal algorithm by comparing the existing process to future
	 * process. 
	 * @param frame the array containing the existing elements
	 * @param array the array containing the future elements
	 * @param x the index of the current elemnt
	 * @param inputFrame the frame that needs to be added
	 * @param frameindex  the index of the current element
	 */
	private void countPageFaults(int [] frame,ArrayList<Integer> array,int x, int inputFrame,int frameindex){

		int max = Integer.MIN_VALUE; 
		int index = -1; 
		int counter = 0;  
		if(size(frame) == frame.length){
			for (int y = 0; y <frame.length; y++) {
				for (int j = x+1; j < array.size(); j++) {
					if(frame[y] == array.get(j)||array.get(j) == -1 ){
						if(counter > max){
							max = counter;
							index = y; 
						}
						break;
					}else
						counter++; 

				} 
					counter = 0; 
			}

			frame[index] = inputFrame; 
		}else{
			frame[indexes[frameindex]] = inputFrame; 
			indexes[frameindex]++; 
		}
	
	}
	/**
	 * Empties the arrays and fills them with a negative value
	 */
	private void reset(){
		Arrays.fill(frame4, -1);
		Arrays.fill(frame8, -1);
		Arrays.fill(frame12, -1);
		//pageFaults4 = 0;
		//pageFaults8 = 0;
		//pageFaults12 = 0;
		Arrays.fill(indexes, 0);
	}
	/**
	 * Calculates the size of an array by counting the elements
	 * @param array
	 * @return number of elements in array 
	 */
	private int size(int[] array) {
		int size = 0;
		for (int i : array) {
			if (i != -1) {
				size++;
			}
		}
		return size;
	}


}
