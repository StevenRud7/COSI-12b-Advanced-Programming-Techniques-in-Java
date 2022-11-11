//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 22, Fall 2021
//Programming Assignment #7
//Description: The Arrayintlist test for testing and going through each method to ensure they work in basic functionality
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.ArrayIntList;

class ArrayIntListTest {
	ArrayIntList list = new ArrayIntList(); //create list from arrayintlist constructor
	ArrayIntList list2 = new ArrayIntList(3);
	
	/**
	 * test that a general add works with default and custom capacity
	 */
	@Test
	void addtest() {
		list.add(2);
		assertEquals(2,list.get(0));
		list2.add(2);
		list2.add(4);
		list2.add(6);
		assertEquals(2,list2.get(0));
		assertEquals(6,list2.get(2));
	}
	/**
	 * test that the add at a specific index works
	 */
	@Test
	void addtest2() {
		list.add(0,5);
		list.add(1,4);
		assertEquals(5,list.get(0));
		assertEquals(4,list.get(1));
		list2.add(0,2);
		list2.add(1,4);
		list2.add(2,6);
		assertEquals(2,list2.get(0));
		assertEquals(4,list2.get(1));
		assertEquals(6,list2.get(2));
	}
	/**
	 * add two values and check if they are gotten correctly
	 */
	@Test
	void gettest() {
		list.add(0,5);
		list.add(1,4);
		assertEquals(5,list.get(0));
		assertEquals(4,list.get(1));
	}
	/**
	 * add values and check they are at the correct index with the indexOf method
	 */
	@Test
	void indexOftest() {
		list.add(0,7);
		list.add(1,3);
		list.add(2,29);
		assertEquals(2,list.indexOf(29));
		assertEquals(0,list.indexOf(7));
		assertEquals(1,list.indexOf(3));
		list2.add(0,3);
		list2.add(1,6);
		list2.add(2,9);
		assertEquals(2,list2.indexOf(9));
		assertEquals(0,list2.indexOf(3));
		assertEquals(1,list2.indexOf(6));
	}
	/**
	 * add values check size then remove a value and see if size decreased and the elements shifted
	 */
	@Test
	void removetest() {
		list.add(0,7);
		list.add(1,3);
		list.add(2,11);
		assertEquals(3,list.size());
		assertEquals(2,list.indexOf(11));
		list.remove(1);
		assertEquals(1,list.indexOf(11));
		assertEquals(2,list.size());
		list2.add(0,3);
		list2.add(1,6);
		list2.add(2,9);
		assertEquals(3,list2.size());
		list2.remove(0);
		assertEquals(2,list2.size());
		assertEquals(0,list2.indexOf(6));
	}
	/**
	 * add values and check that the size is correct
	 */
	@Test
	void sizetest() {
		list.add(0,5);
		list.add(1,3);
		list.add(2,9);
		assertEquals(3,list.size());
		list2.add(0,3);
		list2.add(1,6);
		list2.add(2,9);
		assertEquals(3,list2.size());
	}
	/**
	 * add values and check they are correctly changed into a string
	 */
	@Test
	void toStringtest() {
		list.add(0,6);
		list.add(1,2);
		list.add(2,15);
		assertEquals("[6, 2, 15]",list.toString());
		list2.add(0,4);
		list2.add(1,7);
		list2.add(2,11);
		assertEquals("[4, 7, 11]",list2.toString());
	}
	/**
	 * Add values check size and then clear to see if size went to 0 
	 */
	@Test
	void cleartest() {
		list.add(0,5);
		list.add(1,3);
		list.add(2,9);
		assertEquals(3,list.size());
		list.clear();
		assertEquals(0,list.size());
		list2.add(0,4);
		list2.add(1,7);
		list2.add(2,11);
		assertEquals(3,list2.size());
		list2.clear();
		assertEquals(0,list2.size());
	}
	/**
	 * test the contains method by adding values and checking that if a value is present true is returned and if not present
	 * then false is returned
	 */
	@Test
	void containstest() {
		list.add(0,5);
		list.add(1,3);
		list.add(2,9);
		assertEquals(true,list.contains(9));
		assertEquals(false,list.contains(24));
		list2.add(0,4);
		list2.add(1,7);
		list2.add(2,11);
		assertEquals(true,list2.contains(4));
		assertEquals(false,list2.contains(3));
	}
	/**
	 * increase the capacity to 15 then add 15 elements and see if they added and their size is 15
	 * then with the custom capacity increase it to 4 and see if the element was added
	 */
	@Test
	void ensureCapacitytest() {
		list.ensureCapacity(15);
		for (int i =0; i<15;i++) {
			list.add(i);
		}
		assertEquals(15,list.size());
		list2.ensureCapacity(4);
		list2.add(0,4);
		list2.add(1,7);
		list2.add(2,11);
		list2.add(3,31);
		assertEquals(4,list2.size());
		assertEquals("[4, 7, 11, 31]",list2.toString());
	}
	/**
	 * check if the list is empty when nothing was added
	 */
	@Test
	void emptytest() {
		assertEquals(true,list.isEmpty());
		assertEquals(true,list2.isEmpty());
	}
	/**
	 * add values and make sure they are correctly added then try adding one out of bounds and use try catch so ensure that an error is called 
	 * when that happens
	 */
	@Test
	void checkIndextest() {
		list.add(0,5);
		list.add(1,3);
		list.add(2,9);
		assertEquals(5,list.get(0));
		assertEquals(3,list.get(1));
		assertEquals(9,list.get(2));
		boolean checkflag=false; //boolean for returning true if there is an error
		try {
			list.add(15,11);
		}
		catch(ArrayIndexOutOfBoundsException error) {
			checkflag=true;
		}
		assertTrue(checkflag==true); //just repeat same thing for custom capacity list
		list2.add(0,6);
		list2.add(1,4);
		list2.add(2,12);
		assertEquals(6,list2.get(0));
		assertEquals(4,list2.get(1));
		assertEquals(12,list2.get(2));
		boolean checkflag2=false; //boolean for returning true if there is an error
		try {
			list2.add(5,11);
		}
		catch(ArrayIndexOutOfBoundsException error) {
			checkflag2=true;
		}
		assertTrue(checkflag2==true);
	}
	

}
