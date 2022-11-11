//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 22, Fall 2021
//Programming Assignment #7
//Description: The sortedintlist class which inherits from arrayintlist, but here it is a sorted list with similar functionality
package main;
import java.util.*;


public class SortedIntList extends ArrayIntList {
	private boolean unique; //the unique value for when it is true the list has no duplicates and when it is false it does.
	
	/**
	 * The method to create the sorted list with default cap of 10 and default unique of false
	 */
	public SortedIntList() {
		list = new int[10];
		unique = false;
	}
	/**
	 * The method to create the list with default cap of 10 and defined unique
	 */
	public SortedIntList(boolean unique) {
		list = new int[10];
		this.unique=unique;
		
	}
	/**
	 * The method to create the list with inputed capacity and default unique of false
	 */
	public SortedIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		list = new int[capacity];
		unique = false;
	}
	/**
	 * The method to create the list with inputed capacity and defined unique
	 */
	public SortedIntList(boolean unique, int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		list = new int[capacity];
		//System.out.println(Arrays.toString(list));
		this.unique=unique;
	}
	/**
	 * the add method where I add in both false and true scenarios of unique
	 * if false then simply go through list and add the value in correct order
	 * if true then first check the value is not already present then do same thing 
	 */
	public void add(int value) {
		if (unique == false) {
			int location1 = 0;
			while (location1<size && value> get(location1)) {
				location1++;
			}
			super.add(location1,value); //utilize same code as from arrayintlist as the same functionality is needed
			//size++;
			//System.out.println(Arrays.toString(list));
		}
		if (unique == true) {
			if (indexOf(value)>=0) {
				return; //break out if value is already there (prevents adding duplicates
			}
			int location2 = 0;
			while (location2<size && value> get(location2)) {
				location2++;
			}
			super.add(location2,value);
			//size++;
			//System.out.println(Arrays.toString(list));
				
		}
	}
	/**
	 * if an index is given for the sortedintlist in add then just throw an exception
	 */
	public void add(int index, int value) {
		throw new UnsupportedOperationException();
	}
	/**
	 * @return the unique variable value
	 */
	public boolean getUnique() {
		return unique;
	}
	/**
	 * utilize the binarysearch to go through sorted list and return the index
	 */
	public int indexOf(int value) {
		return Arrays.binarySearch(list, value);
	}
	/**
	 * @return the last value of the list (works cause it is sorted)
	 */
	public int max() {
		if (size==0) { //throw error if empty
			throw new NoSuchElementException();
		}
		else {
			return list[size-1];
		}
	}
	/**
	 * @return the first value of the list (works cause it is sorted)
	 */
	public int min() {
		if (size==0) {
			throw new NoSuchElementException();
		}
		else {
			return list[0];
		}
	}
	/**
	 * if set to false then just change unique to false
	 * if set to true then change unique to true and go through the list and remove any duplicates and edit the size accordingly
	 */
	public void setUnique(boolean unique) {
		if (unique==false) {
			this.unique=false;
		}
		if (unique==true) {
			this.unique=true;
			//System.out.println(Arrays.toString(list));
			int[] templist = new int[size]; //hold non duplicates
			int p = 0;
			for (int i =0; i<size-1; i++) {
				if (list[i]!=list[i+1]) {
					templist[p]=list[i];
					p++;
				}
			}
	        templist[p] = list[size-1];
	        p++;
	        list = new int[p];
	       // System.out.println(p);
	        for (int i = 0;i<p; i++) {  //add values back
	            list[i] = templist[i];  
	        }
	        size=list.length; //cut off excess values by editing size to correct value
	        
		}
	}
	/**
	 * similar functionality as arrayintlist but this time add the S: and then if unique add the U as well
	 */
	public String toString() {
		if (size>0) {
			if (unique==false) {
				String Stringlist = "S:[" + list[0];
				for (int i = 1; i < size; i++) {
					Stringlist = Stringlist + ", " + list[i];
				}
				Stringlist += "]";
				return Stringlist;
			}
			if (unique == true) {
				String Stringlist = "S:[" + list[0];
				for (int i = 1; i < size; i++) {
					Stringlist = Stringlist + ", " + list[i];
				}
				Stringlist += "]U";
				return Stringlist;
			}
		}
		else { //when list empty
			if (unique==false) {
				return "S:[]";
			}
			if (unique==true) {
				return "S:[]U";
			}
		}
		return null; //to satisfy return method
	}
}
