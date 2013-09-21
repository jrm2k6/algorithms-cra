package tests;

import java.util.EmptyStackException;

import job_interview_questions.MaximumStack;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class MaximumStackTest {
	
	private MaximumStack s;
	@Before
	public void setUp() throws Exception {
		s = new MaximumStack();
	}
	
	@Test
	public void testPop() {
		s.push(3);
		s.push(6);
		Assert.assertEquals(6, s.pop());
	}
	
	@Test
	public void testMaximum() {
		s.push(3);
		s.push(6);
		s.push(4);
		Assert.assertEquals(6, s.getMaximumInStack());
	}
	
	@Test
	public void testMaximumUniqueElement() {
		s.push(3);
		Assert.assertEquals(3, s.getMaximumInStack());
	}
	
	@Test(expected=EmptyStackException.class)
	public void testPopEmpty() {
		s.pop();
		Assert.assertEquals(3, s.getMaximumInStack());
	}
}
