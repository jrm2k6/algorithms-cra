package assignment3;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class Fast {
	private class SlopePair {
		int index = 0;
		double slope = 0;
	}
	
	private static void exch(SlopePair[] pairs, int i, int j) {
		SlopePair temp = pairs[i];
		pairs[i] = pairs[j];
		pairs[j] = temp;
	}
	
	private static boolean less(SlopePair p1, SlopePair p2) {
		return p1.slope < p2.slope;
	}
	
	// Quicksort implementation for the pairs.
	 private static int partition(SlopePair[] a, int lo, int hi) {
	        int i = lo, j = hi+1;
	        while (true) {
	            while (less(a[++i], a[lo])) {
	                if (i == hi) break;
	            }
	            while (less(a[lo], a[--j])) {
	                if (j == lo) break;
	            }
	            if (i >= j) break;
	            
	            exch(a, i, j);
	        }
	        exch(a, lo, j);
	        return j;
	    }

	    private static void sort(SlopePair[] a, int N) {
	        StdRandom.shuffle(a);
	        sort(a, 0, N - 1);
	    }

	    private static void sort(SlopePair[] a, int lo, int hi) {
	        if (hi <= lo) {
	            return;
	        }
	        int j = partition(a, lo, hi);
	        sort(a, lo, j-1);
	        sort(a, j+1, hi);
	    }
	    
	    public static void main(String[] args) {
	    Fast fast = new Fast();

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);

        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
            p.draw();
        }
        
        SlopePair[] slopes = new SlopePair[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//            	http://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
                slopes[j] = fast.new SlopePair();
                slopes[j].index = j;
                slopes[j].slope = points[i].slopeTo(points[j]);

            }
            sort(slopes, N);
            
            int lo = 1; int hi = 1;
            while (hi < N-1) {
                while (slopes[lo].slope == slopes[hi].slope) {
                    if (hi < N-1) hi++;
                    if (hi == N-1) break;
                }
                if (hi - lo >= 3) {
                    StdOut.print(points[i].toString());
                    for (int t = lo; t < hi; t++) {
                        StdOut.print(" -> " + points[slopes[t].index]);
                    }
                    StdOut.println();
                    points[i].drawTo(points[slopes[hi - 1].index]);
                }
                lo = hi;
            }
        }
        StdDraw.show(0);
    }
}
