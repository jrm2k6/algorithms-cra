package tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assignment2.RandomizedQueue;

public class RandomizedQueueTest {

	public RandomizedQueue<Integer> d;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d = new RandomizedQueue<Integer>();
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
	
	@Test(expected=NullPointerException.class)
	public void testEnqueueNullItem() {
		d.enqueue(null);
	}
	
	@Test
	public void testEnqueueItems() {
		d.enqueue(3);
		d.enqueue(2);
		assertEquals(d.size(), 2);
	}
	
	@Test
	public void testDequeueItems() {
		d.enqueue(3);
		d.enqueue(2);
		d.enqueue(4);
		d.dequeue();
		assertEquals(d.size(), 2);
	}
	
	@Test
	public void testSampleItem() {
		d.enqueue(3);
		d.enqueue(2);
		d.enqueue(4);
		d.sample();
		assertEquals(d.size(), 3);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testDequeueItemEmptyQueue() {
		d.dequeue();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testSampleItemEmptyQueue() {
		d.sample();
	}
	

}
