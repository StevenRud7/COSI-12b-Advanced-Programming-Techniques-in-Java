//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 22, Fall 2021
//Programming Assignment #7
//Description: The arrayintlist class for creating all the basic functionality I will need to use in a list. 

package main;

public class ArrayIntList {
	protected int[] list; //the empty list array created
	protected int size; //variable for size of array (number of elements in the array list)
	protected int capacity;
	
	
	/**
	 * The method to create the list with default cap of 10
	 */
	public ArrayIntList() {
		list = new int[10];
	}	
	/**
	 * The method to create the list with a set cap 
	 */
	public ArrayIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		list = new int[capacity];
		size = 0;
		
	}
	/**
	 * To avoid redundancy I reused the same code from the add method with a specific index as they will still perform the same thing as 
	 * i put the index to be the end of the list
	 */
	public void add(int value) { 
		add(size,value);
	}
	/**
	 * First I shift along the array list and then placed my value at the designated index
	 * 
	 */
	public void add(int index, int value) {
		for (int i = size; i > index; i--) { //shifts up till the index
            list[i] = list[i - 1];
        }
		list[index] = value; //add value
        size++; //increase size as an index was added
	}
	/**
	 * return the value at given index
	 */
	public int get(int index) {
		return list[index];
	}
	/**
	 * go through the list and when a value equals the inputed value return the index 
	 * if not there return -1
	 */
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
            if (list[i] == value) {
                return i;
            }
        }
		return -1;
	}
	/**
	 * shift the list to the left from the index position while removing the value at given index
	 */
	public void remove(int index) {
		//System.out.println(Arrays.toString(list));
		for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--; //decrease element size
        int[] templist = new int[size]; //holder for list
        for (int j =0; j<size;j++) {
        	templist[j]=list[j]; //add all values to temp holder
        }
        //list = new int[size];
        list = templist; //make list the same as the temp list
       // System.out.println(Arrays.toString(list));
	}
	/**
	 * @return the size (number of values in list)
	 */
	public int size() {
		return size;
	}
	/**
	 * first add the initial part of string to the new string variable then go through the rest of the list and add them to string variable 
	 * if the list is empty return empty string
	 */
	public String toString() {
		if (size > 0) {
            String Stringlist = "[" + list[0];
            for (int i = 1; i < size; i++) {
                Stringlist = Stringlist + ", " + list[i];
            }
            Stringlist += "]";
            return Stringlist;
        } 
		else {
            return "[]"; // return empty list when size = 0
        }
	}
	/**
	 * go through entire list and use remove method to remove each element
	 */
	public void clear() { 
		for (int i = size; i > 0 ; i--) {
			remove(i);
		}
	}
	/**
	 * utilize the indexOf method and assuming it is present ( the index is not -1) it will return true 
	 * 
	 */
	public boolean contains(int value) {
		return indexOf(value)>=0;
	}
	/**
	 * edits the list array to ensure that the added elements can be stored
	 */
	public void ensureCapacity(int capacity) {
		if (capacity > size) {
            int increasedCap = size * 2 + 1; //create the temp increased capacity
            if (capacity > increasedCap) {
            	increasedCap = capacity;
            }
            int[] list2 = new int[increasedCap]; //create the temp new list for holding
            for (int i = 0; i < size; i++) {
                list2[i] = list[i];
            }
            list = list2;
		}
	}
	/**
	 * @return true if the size variable is empty
	 */
	public boolean isEmpty() {
		return size == 0; 
	}
	/**
	 * check if the index is less than given min or greater than max and if so return the exception 
	 */
	private void checkIndex(int index, int min, int max) {
		if (index < min || index > max) {
            throw new ArrayIndexOutOfBoundsException();
        }
	}
}
