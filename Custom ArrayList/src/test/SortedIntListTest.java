//Steven Rud
//stevenrud@brandeis.edu
//COSI 12b, November 22, Fall 2021
//Programming Assignment #7
//Description: The Sortedintlist test for testing and going through each method to ensure they work in basic functionality
package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.SortedIntList;



class SortedIntListTest {
	SortedIntList slist = new SortedIntList(false,3); //the list variables for testing
	SortedIntList slistu = new SortedIntList(true,4);
	SortedIntList deflist = new SortedIntList();
	
	/**
	 * test for adding values in a false unique value and ensuring they are sorted
	 * Then tested default conditions and tried adding over capacity and caught the error
	 */
	@Test
	void addtest1() {
		slist.add(2);
		slist.add(10);
		slist.add(5);
		assertEquals(5,slist.get(1));
		assertEquals(2,slist.get(0));
		assertEquals(2,slist.indexOf(10));
		deflist.add(1);
		deflist.add(2);
		deflist.add(3);
		deflist.add(4);
		deflist.add(5);
		deflist.add(6);
		deflist.add(7);
		deflist.add(8);
		deflist.add(9);
		deflist.add(5);
		assertEquals(10,deflist.size());
		assertEquals(3,deflist.get(2));
		assertEquals("S:[1, 2, 3, 4, 5, 5, 6, 7, 8, 9]",deflist.toString());
		boolean checkflag=false; //boolean for returning true if there is an error
		try {
			deflist.add(5); //try to add over the 10 capacity
		}
		catch(IndexOutOfBoundsException error) {
			checkflag=true;
		}
		assertTrue(checkflag==true);
	}
	/**
	 * test for adding values in a true unique value and ensuring they are sorted and without duplicates
	 */
	@Test
	void addtest2() {
		slistu.add(3);
		slistu.add(1);
		slistu.add(2);
		slistu.add(1);
		slistu.add(4);
		slistu.add(1);
		assertEquals(4,slistu.size());
		assertEquals(1,slistu.get(0));
		assertEquals(2,slistu.get(1));
		assertEquals(3,slistu.get(2));
		assertEquals(1,slistu.min());
		assertEquals("S:[1, 2, 3, 4]U",slistu.toString());
	}
	/**
	 * test for adding a value with a given index to ensure that the error is thrown
	 */
	@Test
	void addtest3() {
		slist.add(2);
		slist.add(10);
		slist.add(5);
		boolean checkflag=false; //boolean for returning true if there is an error
		try {
			slist.add(3,11);
		}
		catch(UnsupportedOperationException error) {
			checkflag=true;
		}
		assertTrue(checkflag==true);
	}
	/**
	 * Remove test inherited from arrayintlist adding values and testing if they were properly removed 
	 */
	@Test
	void removetest() {
		slist.add(2);
		slist.add(10);
		slist.add(5);
		assertEquals("S:[2, 5, 10]", slist.toString());
		slist.remove(1);
		assertEquals("S:[2, 10]", slist.toString());
		assertEquals(2,slist.size());
		slistu.add(3);
		slistu.add(1);
		slistu.add(2);
		slistu.add(1);
		assertEquals("S:[1, 2, 3]U",slistu.toString());
		slistu.remove(0);
		assertEquals("S:[2, 3]U",slistu.toString());
		assertEquals(2,slistu.size());
	}
	/**
	 * Clear test inherited from arrayintlist on the sorted list add values and then test they were cleared
	 */
	@Test
	void cleartest() {
		slist.add(2);
		slist.add(10);
		slist.add(5);
		assertEquals(3,slist.size());
		slist.clear();
		assertEquals(0,slist.size());
		assertEquals("S:[]",slist.toString());
		slistu.add(5);
		slistu.add(4);
		slistu.add(6);
		slistu.add(5);
		assertEquals(3,slistu.size());
		assertEquals("S:[4, 5, 6]U",slistu.toString());
		slistu.clear();
		assertEquals(0,slistu.size());
		assertEquals("S:[]U",slistu.toString());
	}
	/**
	 * Contains test inherited from arrayintlist, done by adding values to sorted list and testing if they are they 
	 * and as well testing if values are not there returns false
	 */
	@Test
	void containstest() {
		slist.add(2);
		slist.add(10);
		slist.add(5);
		assertEquals(true,slist.contains(2));
		assertEquals(true,slist.contains(5));
		assertEquals(true,slist.contains(10));
		assertEquals(false,slist.contains(255));
		slistu.add(5);
		slistu.add(4);
		slistu.add(21);
		slistu.add(5);
		assertEquals(true,slistu.contains(4));
		assertEquals(true,slistu.contains(5));
		assertEquals(true,slistu.contains(21));
		assertEquals(false,slistu.contains(50));
		assertEquals("S:[4, 5, 21]U",slistu.toString());
	}
	/**
	 * Test to make sure that the getUnique method correctly returns the unique value and that the unique value is correctly assigned
	 */
	@Test
	void uniquetest() {
		slist.add(2);
		assertEquals(false,slist.getUnique());
		assertEquals(true,slistu.getUnique());
		slist.setUnique(true);
		assertTrue(slist.getUnique());
	}
	/**
	 * test to make sure they indexOf method is correct by adding values and checking their index is correct
	 */
	@Test
	void indexOftest() {
		slistu.add(2);
		slistu.add(10);
		slistu.add(5);
		slistu.add(27);
		assertEquals(1,slistu.indexOf(5));
		assertEquals(0,slistu.indexOf(2));
		assertEquals(2,slistu.indexOf(10));
		assertEquals(3,slistu.indexOf(27));
	}
	/**
	 * add values and check that their minimum and maximum are correct
	 */
	@Test
	void minmaxtest() {
		slist.add(2);
		slist.add(10);
		slist.add(5);
		assertEquals(10,slist.max());
		assertEquals(2,slist.min());
	}
	/**
	 * Ensure capacity test inherited from arrayintlist. First make sure adding a value after the list reached capacity calls an error 
	 * then increase capacity and test that the value could be added and is correctly added
	 */
	@Test
	void ensurecaptest() {
		slist.add(2);
		slist.add(10);
		slist.add(5);
		boolean checkflag=false; //boolean for returning true if there is an error
		try {
			slist.add(54);
		}
		catch(IndexOutOfBoundsException error) {
			checkflag=true;
		}
		assertTrue(checkflag==true);
		slist.ensureCapacity(4);
		slist.add(54);
		assertEquals("S:[2, 5, 10, 54]",slist.toString());
		slistu.add(2);
		slistu.add(10);
		slistu.add(5);
		slistu.add(10);
		slistu.add(27);
		boolean checkflag2=false; //boolean for returning true if there is an error
		try {
			slistu.add(42);
		}
		catch(IndexOutOfBoundsException error) {
			checkflag2=true;
		}
		assertTrue(checkflag2==true);
		slistu.ensureCapacity(5);
		slistu.add(7);
		assertEquals("S:[2, 5, 7, 10, 27]U",slistu.toString());
	}
	/**
	 * set unique test where I added values to a false list and then set it to true and confirmed the duplicates were removed
	 * then I had a true list where I later set to false and tested if duplicates could be added
	 */
	@Test
	void setUniquetest() {
		slist.ensureCapacity(6);
		slist.add(2);
		slist.add(10);
		slist.add(5);
		slist.add(5);
		slist.add(2);
		slist.add(14);
		assertEquals(6,slist.size());
		slist.setUnique(true);
		assertEquals(4,slist.size());
		slistu.add(3);
		slistu.add(1);
		slistu.add(2);
		slistu.add(1);
		assertEquals(3,slistu.size());
		slistu.setUnique(false);
		assertEquals(3,slistu.size());
		slistu.add(3);
		assertEquals(4,slistu.size());
	}
	/**
	 * Tested a toString for both unique and not unique and made sure the "S" and U were both included
	 */
	@Test
	void toStringtest() {
		slist.ensureCapacity(6);
		slist.add(2);
		slist.add(10);
		slist.add(5);
		slist.add(5);
		slist.add(2);
		slist.add(14);
		assertEquals("S:[2, 2, 5, 5, 10, 14]",slist.toString());
		slistu.add(3);
		slistu.add(1);
		slistu.add(2);
		slistu.add(1);
		assertEquals("S:[1, 2, 3]U",slistu.toString());
	}
	/**
	 * isempty test inherited from arrayintlist. Test that a list is or isn't without any values. 
	 * First see initially empty then add values and see that it isn't empty, then remove the values and see that it is empty again
	 */
	@Test
	void isEmptytest() {
		assertEquals(true,slist.isEmpty());
		assertEquals(true,slistu.isEmpty());
		assertEquals(true,deflist.isEmpty());
		slist.add(77);
		slistu.add(31);
		assertFalse(slist.isEmpty());
		assertFalse(slistu.isEmpty());
		assertTrue(deflist.isEmpty());
		slist.remove(0);
		slistu.remove(0);
		assertTrue(slist.isEmpty());
		assertTrue(slistu.isEmpty());
		
	}

}
