
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Performs the least recent used algorithm by adding past items to a list and 
 * comparing the for future elements
 * @author Carlos Perez
 */
public class LRU {

	ReadFile file;
	int[] frame4 = new int[4];
	int[] frame8 = new int[8];
	int[] frame12 = new int[12];
	int pageFaults4 = 0, pageFaults8 = 0, pageFaults12 = 0;
	//int last4 = 0, last8 = 0, last12 = 0;
	int [] lasts = new int [3]; 
	ArrayList<Recent> recentpast = new ArrayList<>();
	ArrayList<Recent> recentpast8 = new ArrayList<>();
	ArrayList<Recent> recentpast12 = new ArrayList<>();
	/**
	 * Default Constructor
	 * @param file containing the reference strings 
	 */	
	public LRU(ReadFile file) {
		this.file = file;
		run512();
		run1024();
		run2048(); 
	}
	/**
	 * Runs a 512 size reference string by checking if the reference string 
	 * exist in the current memory
	 * If it does not exist then perform the algorithm and add one to the 
	 * number of pagefaults
	 */
	private void run512() {
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true;
		reset(); 
		Iterator<Integer> array512 = file.referenceString512.iterator();
		while (array512.hasNext()) {
			int inputFrame = array512.next();
			for (int i = 0; i < frame4.length; i++) {
				if (frame4[i] == inputFrame) {
					pagefault4 = false;
					recentpast.add(new Recent(inputFrame, i));
				}
			}

			for (int j = 0; j < frame8.length; j++) {
				if (frame8[j] == inputFrame) {
					pagefault8 = false;
					recentpast8.add(new Recent(inputFrame, j));
				}
			}

			for (int i = 0; i < frame12.length; i++) {
				if (frame12[i] == inputFrame) {
					pagefault12 = false;
					recentpast12.add(new Recent(inputFrame, i));
				}
			}
			/**********************************************************************/
			if(pagefault4){
				countPageFaults(frame4,4,recentpast,inputFrame,0);
				pageFaults4++;
			}
			if(pagefault8){
				countPageFaults(frame8,8,recentpast8,inputFrame,1); 
				pageFaults8++; 
			}
			if(pagefault12){
				countPageFaults(frame12,12,recentpast12,inputFrame,2); 
				pageFaults12++; 
			}
			//last++; 
			pagefault4 = true;
			pagefault8 = true; 
			pagefault12 = true; 
			//System.out.println("input:"+inputFrame); 

		}
		
		int total = file.referenceString512.size(); 
		System.out.printf("  512	4	LRU	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  512	8	LRU	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  512	12	LRU	2%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 


	}
	/**
	 * Runs a 1024 size reference string by checking if the reference string 
	 * exist in the current memory
	 * If it does not exist then perform the algorithm and add one to the 
	 * number of pagefaults
	 */
	private void run1024() {
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true;
		reset(); 
		Iterator<Integer> array1024 = file.referenceString1024.iterator();
		while (array1024.hasNext()) {
			int inputFrame = array1024.next();
			for (int i = 0; i < frame4.length; i++) {
				if (frame4[i] == inputFrame) {
					pagefault4 = false;
					recentpast.add(new Recent(inputFrame, i));
				}
			}

			for (int j = 0; j < frame8.length; j++) {
				if (frame8[j] == inputFrame) {
					pagefault8 = false;
					recentpast8.add(new Recent(inputFrame, j));
				}
			}

			for (int i = 0; i < frame12.length; i++) {
				if (frame12[i] == inputFrame) {
					pagefault12 = false;
					recentpast12.add(new Recent(inputFrame, i));
				}
				
			}
			/**********************************************************************/
			if(pagefault4){
				countPageFaults(frame4,4,recentpast,inputFrame,0);
				pageFaults4++;
			}
			if(pagefault8){
				countPageFaults(frame8,8,recentpast8,inputFrame,1); 
				pageFaults8++; 
			}
			if(pagefault12){
				countPageFaults(frame12,12,recentpast12,inputFrame,2); 
				pageFaults12++; 
			}
			pagefault4 = true;
			pagefault8 = true; 
			pagefault12 = true; 
			//System.out.println("input:"+inputFrame); 

		}
		int total = file.referenceString1024.size(); 
		System.out.printf("  1024	4	LRU	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  1024	8	LRU	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  1024	12	LRU	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 


	}

	/**
	 * Runs a 2048 size reference string by checking if the reference string 
	 * exist in the current memory
	 * If it does not exist then perform the algorithm and add one to the 
	 * number of pagefaults
	 */
	private void run2048(){
		boolean pagefault4 = true, pagefault8 = true, pagefault12 = true;
		reset(); 
		Iterator<Integer> array2048 = file.referenceString2048.iterator();
		while (array2048.hasNext()) {
			int inputFrame = array2048.next();
			for (int i = 0; i < frame4.length; i++) {
				if (frame4[i] == inputFrame) {
					pagefault4 = false;
					recentpast.add(new Recent(inputFrame, i));
				}
			}

			for (int j = 0; j < frame8.length; j++) {
				if (frame8[j] == inputFrame) {
					pagefault8 = false;
					recentpast8.add(new Recent(inputFrame, j));
				}
			}

			for (int i = 0; i < frame12.length; i++) {
				if (frame12[i] == inputFrame) {
					pagefault12 = false;
					recentpast12.add(new Recent(inputFrame, i));
				}
			}
			/**********************************************************************/
			if(pagefault4){
				countPageFaults(frame4,4,recentpast,inputFrame,0);
				pageFaults4++;
			}
			if(pagefault8){
				countPageFaults(frame8,8,recentpast8,inputFrame,1); 
				pageFaults8++; 
			}
			if(pagefault12){
				countPageFaults(frame12,12,recentpast12,inputFrame,2); 
				pageFaults12++; 
			}
			pagefault4 = true;
			pagefault8 = true; 
			pagefault12 = true; 
			//System.out.println("input:"+inputFrame); 

		}
		
		int total = file.referenceString2048.size(); 
		System.out.printf("  2048	4	LRU	%.2f%%		%d\n",
			((float)pageFaults4/(total))*100,pageFaults4); 
		System.out.printf("  2048	8	LRU	%.2f%%		%d\n",
			((float)pageFaults8/(total))*100,pageFaults8); 
		System.out.printf("  2048	12	LRU	%.2f%%		%d\n",
			((float)pageFaults12/(total))*100,pageFaults12); 


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
	/**
	 * Performs least recent used algorithm by adding past elements to a list 
	 * and compare them with new incoming elements 
	 * @param frame array with existing elements
	 * @param noframes number of size of array
	 * @param past list containing past elements
	 * @param inputFrame element to be added to the array 
	 * @param arrayindex index of array 
	 */	
	private void countPageFaults(int [] frame,int noframes,ArrayList<Recent> past,
		int inputFrame,int arrayindex){
		int size = past.size();
		int found = 0;
		int index = 0; 
		boolean duplicate = false;
		ArrayList<Recent> counting = new ArrayList<>();

		if (size(frame) == noframes) {
			Recent replace = null;
			while (found != noframes-1) {
				counting.add(past.get(size - 1));
				if (counting.size() >= 2) {
					Recent lastone = counting.get(counting.size() - 1);
					for (int i = 0; i < counting.size() - 1; i++) {
						if (lastone.getValue() == counting.get(i).getValue()) {
							duplicate = true;
						}
					}
					if (!duplicate) {
						found++;
						replace = lastone;
					}
					duplicate = false;
				}

				size--;

			}
			index = replace.getIndex();
			frame[index] = inputFrame;
			past.add(new Recent(inputFrame, index));
			counting.clear();

		} else {
			frame[lasts[arrayindex]] = inputFrame;
			past.add(new Recent(inputFrame, lasts[arrayindex]));
			lasts[arrayindex]++; 	
		}
	}
	/**
	 * Flushes arrays for a new size replacement
	 */
	private void reset(){
		Arrays.fill(frame4, -1);
		Arrays.fill(frame8, -1);
		Arrays.fill(frame12, -1);
		pageFaults4 = 0;
		pageFaults8 = 0;
		pageFaults12 = 0;
		recentpast.clear();
		recentpast12.clear();
		recentpast8.clear();
		Arrays.fill(lasts, 0);
	}
	
}
