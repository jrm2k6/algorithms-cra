package assignment3;

import java.util.Comparator;

import edu.princeton.cs.introcs.StdDraw;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {

		@Override
		public int compare(Point o1, Point o2) {
			double firstSlope = slopeTo(o1);
			double secondSlope = slopeTo(o2);
			
			if (firstSlope < secondSlope) {
				return -1;
			} else if (firstSlope > secondSlope){
				return 1;
			} else return 0;
		}
	};

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        int comparison = this.compareTo(that);
        if (comparison == 0) return Double.NEGATIVE_INFINITY;
        else if (this.x == that.x) return Double.POSITIVE_INFINITY;
        else if (this.y == that.y) {
        	double a = 1.0;
        	return (a - a) /  a; 
        } else {
        	double xs = that.x - this.x;
        	double ys = that.y - this.y;
        	
        	return ys / xs;
        }
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
    	if (this.y < that.y){
    		return -1;
    	} else if (this.y == that.y){
    		if (this.x < that.x) {
    			return -1;
    		}
    		else if (this.x == that.x) {
    			return 0;
    		}
    	}
    	return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}