package assignment3;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

public class Brute {
	public static void main(String[] args) {
		StdDraw.setXscale(0, 32768);
		StdDraw.setYscale(0, 32768);
		StdDraw.show(0);

		// read in the input
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
		
        for (int p = 0; p < N; p++) {
            for (int q = 0; q < N; q++) {
                for (int r = 0; r < N; r++) {
                    if (points[p].compareTo(points[q]) < 0 && points[q].compareTo(points[r]) < 0) {
                        double firstSlope = points[p].slopeTo(points[q]);
                        double secondSlope = points[p].slopeTo(points[r]);
                        // if two slopes are different, no need to compare with another point
                        if (Double.compare(firstSlope, secondSlope) == 0) {
                            for (int s = 0; s < N; s++) {
                                if (points[r].compareTo(points[s]) < 0) {
                                    double thirdSlope = points[p].slopeTo(points[s]);
                                    if (Double.compare(secondSlope, thirdSlope) == 0) {
                                        points[p].drawTo(points[s]);
                                        StdOut.println(points[p].toString() 
                                                + " -> " + points[q].toString()
                                                + " -> " + points[r].toString()
                                                + " -> " + points[s].toString());
                                    }
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        StdDraw.show(0);
    }
}
