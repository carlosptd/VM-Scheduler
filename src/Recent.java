/**
 * Encapsulating class used track the index of a seached item 
 * @author Carlos Perez
 */
public class Recent {
	
	private int value; 
	private int index; 

	public Recent(int value, int index) {
		this.value = value;
		this.index = index;
	}
	/**
	 * @return the recent
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the recent to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	
		
}
