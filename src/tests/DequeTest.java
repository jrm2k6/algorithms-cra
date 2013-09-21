/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assignment2.Deque;

/**
 * @author jrm2k6
 *
 */
public class DequeTest {
	public Deque<Integer> d;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d = new Deque<Integer>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSizeEmptyDequeReturnsZero() {
		assertEquals(0, d.size());
	}
	
	@Test
	public void testNotEmptyDequeReturnsValidSize() {
		d.addFirst(3);
		assertEquals(1, d.size());
	}
	
	@Test
	public void testNotEmptyDequeReturnsValidSizeWhenAddingFirst(){
		d.addFirst(3);
		d.addFirst(2);
		assertEquals(2, d.size());
	}
	
	@Test
	public void testNotEmptyDequeReturnsValidSizeWhenRemovingFirst(){
		d.addFirst(3);
		d.addFirst(2);
		d.removeFirst();
		assertEquals(1, d.size());
	}
	
	@Test
	public void testNotEmptyDequeReturnsValidSizeWhenAddingLast(){
		d.addFirst(3);
		d.addLast(2);
		assertEquals(2, d.size());
	}
	
	@Test
	public void testNotEmptyDequeReturnsValidSizeWhenRemovingLast(){
		d.addFirst(3);
		d.addFirst(2);
		d.removeLast();
		assertEquals(1, d.size());
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddFirstNullItem() {
		d.addFirst(null);
	}
	
	@Test
	public void testAddLastOnEmptyList() {
		d.addLast(3);
		assertEquals(3, (int) d.removeLast());
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddLastNullItem() {
		d.addFirst(null);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemoveFirstOnEmptyList() {
		d.removeFirst();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemoveLastOnEmptyList() {
		d.removeLast();
	}

}
