package tests;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import assignment3.Point;

public class PointTest {
	public Point p1;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Point(3, 5);
	}
	
	@Test
	public void testCompareToEqualPoint() {
		Point p2 = new Point(3, 5);
		Assert.assertEquals(0, p1.compareTo(p2));
	}
	
	@Test
	public void testComparePoint() {
		Point p2 = new Point(3, 4);
		Assert.assertEquals(1, p1.compareTo(p2));
	}
	
	@Test
	public void testComparePointLower() {
		Point p2 = new Point(3, 6);
		Assert.assertEquals(-1, p1.compareTo(p2));
	}
	
	@Test
	public void testCompareToSameYPointLower() {
		Point p2 = new Point(3, 6);
		Assert.assertEquals(-1, p1.compareTo(p2));
	}
	
	@Test
	public void testCompareToSameYPointBigger() {
		Point p2 = new Point(3, 4);
		Assert.assertEquals(1, p1.compareTo(p2));
	}
	
	@Test
	public void testSlopeToItself() {
		Assert.assertEquals(Double.NEGATIVE_INFINITY, p1.slopeTo(p1));
	}
	
	@Test
	public void testSlopeHorizontalLine() {
		Point p2 = new Point(2, 5);
		Assert.assertEquals(+0.0, p1.slopeTo(p2));
	}
	
	@Test
	public void testSlopeVerticalLine() {
		Point p2 = new Point(3, 8);
		Assert.assertEquals(Double.POSITIVE_INFINITY, p1.slopeTo(p2));
	}
	
	@Test
	public void testSlopeNegativeSlope() {
		Point p2 = new Point(4, 12);
		Assert.assertEquals(7.0, p1.slopeTo(p2));
	}
	
	@Test
	public void testSlopePositiveSlope() {
		Point p2 = new Point(-1, -2);
		Assert.assertEquals(1.75, p1.slopeTo(p2));
	}
	
	
	
	
}
