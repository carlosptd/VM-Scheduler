
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 *
 * @author Carlos Perez
 */
public class MRU {

	ReadFile file; 
	int [] frame4 = new int[4]; 
	int [] frame8 = new int [8]; 
	int [] frame12 = new int [12]; 	
	/**
	 * Default Constructor
	 * @param file containing reference strings 
	 */
	public MRU(ReadFile file) {
		this.file = file;
		run512(); 
		run1024(); 
		run2048(); 
	}

	/**
	 * Runs a 512 size reference string using the the most recent algorithm 
	 * it checks if the reference string is in the existing array and it is 
	 * not it replaces the last element in the array. 
	 */
	private void run512(){
		int last4 = 0,last8 = 0,last12 = 0;  
		int pageFaults4 =0, pageFaults8 = 0,pageFaults12 = 0; 
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true; 

		Arrays.fill(frame4, -1);
		Arrays.fill(frame8,-1);
		Arrays.fill(frame12, -1); 
		

		Iterator<Integer> array512 = file.referenceString512.iterator(); 
		while(array512.hasNext()){
			int inputFrame = array512.next(); 
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
				if(size(frame4)<4){
					frame4[last4] = inputFrame; 
					last4++; 
					pageFaults4++; 
				}else{
					frame4[3] = inputFrame; 
					pageFaults4++; 
				}
							
			}
			if(pagefault8){
				if(size(frame8)<8){
					frame8[last8] = inputFrame; 
					last8++; 
					pageFaults8++; 
				}else{
					frame8[7] = inputFrame; 
					pageFaults8++; 
				}
							
			}
			if(pagefault12){
				if(size(frame12)<12){
					frame12[last12] = inputFrame; 
					last12++; 
					pageFaults12++; 
				}else{
					frame12[11] = inputFrame; 
					pageFaults12++; 
				}
							
			}

			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 

		}

		int total = file.referenceString512.size(); 
		System.out.printf("  512	4	MRU	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  512	8	MRU	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  512	12	MRU	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 


		Arrays.fill(frame4, -1);
		Arrays.fill(frame8,-1);
		Arrays.fill(frame12, -1); 
		
	}

	/**
	 * Runs a 1024 size reference string using the the most recent algorithm 
	 * it checks if the reference string is in the existing array and it is 
	 * not it replaces the last element in the array. 
	 */
	private void run1024(){
		int last4 = 0,last8 = 0,last12 = 0;  
		int pageFaults4 =0, pageFaults8 = 0,pageFaults12 = 0; 
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true; 
		Iterator<Integer> array1024 = file.referenceString1024.iterator(); 
		while(array1024.hasNext()){
			int inputFrame = array1024.next(); 
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
				if(size(frame4)<4){
					frame4[last4] = inputFrame; 
					last4++; 
					pageFaults4++; 
				}else{
					frame4[3] = inputFrame; 
					pageFaults4++; 
				}
							
			}
			if(pagefault8){
				if(size(frame8)<8){
					frame8[last8] = inputFrame; 
					last8++; 
					pageFaults8++; 
				}else{
					frame8[7] = inputFrame; 
					pageFaults8++; 
				}
							
			}
			if(pagefault12){
				if(size(frame12)<12){
					frame12[last12] = inputFrame; 
					last12++; 
					pageFaults12++; 
				}else{
					frame12[11] = inputFrame; 
					pageFaults12++; 
				}
							
			}

			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 

		}
		int total = file.referenceString1024.size(); 
		System.out.printf("  1024	4	MRU	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  1024	8	MRU	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  1024	12	MRU	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 

	
		Arrays.fill(frame4, -1);
		Arrays.fill(frame8,-1);
		Arrays.fill(frame12, -1); 
		

	}

	/**
	 * Runs a 2048 size reference string using the the most recent algorithm 
	 * it checks if the reference string is in the existing array and it is 
	 * not it replaces the last element in the array. 
	 */
	private void run2048(){
		int last4 = 0,last8 = 0,last12 = 0;  
		int pageFaults4 =0, pageFaults8 = 0,pageFaults12 = 0; 
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true; 
		Iterator<Integer> array2048 = file.referenceString2048.iterator(); 
		while(array2048.hasNext()){
			int inputFrame = array2048.next(); 
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
				if(size(frame4)<4){
					frame4[last4] = inputFrame; 
					last4++; 
					pageFaults4++; 
				}else{
					frame4[3] = inputFrame; 
					pageFaults4++; 
				}
							
			}
			if(pagefault8){
				if(size(frame8)<8){
					frame8[last8] = inputFrame; 
					last8++; 
					pageFaults8++; 
				}else{
					frame8[7] = inputFrame; 
					pageFaults8++; 
				}
							
			}
			if(pagefault12){
				if(size(frame12)<12){
					frame12[last12] = inputFrame; 
					last12++; 
					pageFaults12++; 
				}else{
					frame12[11] = inputFrame; 
					pageFaults12++; 
				}
							
			}
			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 

		}
		
		int total = file.referenceString2048.size(); 
		System.out.printf("  2048	4	MRU	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  2048	8	MRU	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  2048	12	MRU	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 


	}

	/**
	 * Calculates the size of an array by counting the elements
	 * @param array
	 * @return number of elements in array 
	 */
	private int size(int [] array){
		int size = 0; 
		for (int i : array) {
			if(i != -1)size++; 	
		}
		return size; 
	}
}
