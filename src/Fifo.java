
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;



/**
 * Performs Fifo algorithm by adding one to the index and performing the modulus 
 * operation 
 * @author Carlos Perez 
 */
public class Fifo {
	
	ReadFile file; 
	int [] frame4 = new int[4]; 
	int [] frame8 = new int [8]; 
	int [] frame12 = new int [12]; 	
	/**
	 * Default Constructor 
	 * @param file containing the reference strings 
	 */
	public Fifo(ReadFile file) {
		this.file = file;
		run512(); 
		run1024();
		run2048(); 
	}
	/**
	 * Run 512 page size fifo algorithm, by performing the modulus operation
	 * for the index of the array. 
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
					
				
			
			//System.out.println("-----------------"); 
			if(pagefault4){
				frame4[last4] = inputFrame; 
				last4++; 
				last4 = (last4+4)%4;  
				pageFaults4++; 
			}
			if(pagefault8){
				frame8[last8] = inputFrame; 
				last8++; 
				last8 = (last8+8)%8;  
				pageFaults8++; 
			}
			if(pagefault12){
				frame12[last12] = inputFrame; 
				last12++; 
				last12 = (last12+12)%12;  
				pageFaults12++; 
			}
			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 
			//System.out.println("input:"+inputFrame); 

		}
		
		int total = file.referenceString512.size(); 
		System.out.printf("  512	4	Fifo	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  512	8	Fifo	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  512	12	Fifo	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 


		Arrays.fill(frame4, -1);
		Arrays.fill(frame8,-1);
		Arrays.fill(frame12, -1); 
	

	}
	/**
	 * Run 1024 page size fifo algorithm, by performing the modulus operation
	 * for the index of the array. 
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
					
				
			
			//System.out.println("-----------------"); 
			if(pagefault4){
				frame4[last4] = inputFrame; 
				last4++; 
				last4 = (last4+4)%4;  
				pageFaults4++; 
			}
			if(pagefault8){
				frame8[last8] = inputFrame; 
				last8++; 
				last8 = (last8+8)%8;  
				pageFaults8++; 
			}
			if(pagefault12){
				frame12[last12] = inputFrame; 
				last12++; 
				last12 = (last12+12)%12;  
				pageFaults12++; 
			}
			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 
			//System.out.println("input:"+inputFrame); 

		}
		int total = file.referenceString1024.size(); 
		System.out.printf("  1024	4	Fifo	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  1024	8	Fifo	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  1024	12	Fifo	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 


		Arrays.fill(frame4, -1);
		Arrays.fill(frame8,-1);
		Arrays.fill(frame12, -1); 
	

	}
	/**
	 * Run 2048 page size fifo algorithm, by performing the modulus operation
	 * for the index of the array. 
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
					
				
			
			//System.out.println("-----------------"); 
			if(pagefault4){
				frame4[last4] = inputFrame; 
				last4++; 
				last4 = (last4+4)%4;  
				pageFaults4++; 
			}
			if(pagefault8){
				frame8[last8] = inputFrame; 
				last8++; 
				last8 = (last8+8)%8;  
				pageFaults8++; 
			}
			if(pagefault12){
				frame12[last12] = inputFrame; 
				last12++; 
				last12 = (last12+12)%12;  
				pageFaults12++; 
			}
			pagefault4 = true; 	
			pagefault8 = true; 
			pagefault12 = true; 
			//System.out.println("input:"+inputFrame); 

		}

		int total = file.referenceString2048.size(); 
		System.out.printf("  2048	4	Fifo	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  2048	8	Fifo	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  2048	12	Fifo	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 

	

	}


}
