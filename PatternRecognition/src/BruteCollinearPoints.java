import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class BruteCollinearPoints {
	private Point[] points;
	private LineSegment[] lines;
	private List<LineSegment> linesList;
	private Point[] sortedPoints;
	
	public BruteCollinearPoints(Point[] points) {
		this.points = points;
		this.linesList = new ArrayList<LineSegment>();
		// exception handler
		for (int i = 0; i < this.points.length; i++) {
	            if (this.points[i] == null)
	                throw new java.lang.IllegalArgumentException();
	        }
		 
		 for (int i = 0; i < this.points.length; i++) {
	            for (int j = i+1; j < this.points.length;j++ ) {
	                if (this.points[i].compareTo(this.points[j]) == 0)
	                    throw new java.lang.IllegalArgumentException();          
	            }
	        }
		 sortedPoints = this.points.clone();
		 Arrays.sort(sortedPoints);
		 addLineSegment();
		 lines = new LineSegment[linesList.size()];
		 lines = linesList.toArray(lines);
		 
		 
	}
	
	// find the number of  line segments
	public int numberOfSegment() {
		return lines.length;
	}
	// line segments
	public LineSegment[] segments() {
		return lines;
	}
	
	// determine if there are four points in a line
	private boolean isCollinear(Point p1,Point p2, Point p3, Point p4) {
		return (p2.slopeTo(p1) == p3.slopeTo(p2) && p3.slopeTo(p2) == p4.slopeTo(p3));
	}
	
	// if p1,p2,p3,p4 are collinear, add this line segment
	private void addLineSegment() {
		for(int i=0; i<this.sortedPoints.length;i++) {
			 Point p1 = this.sortedPoints[i];
			 for(int j=i+1; j<this.sortedPoints.length;j++) {
				 Point p2 = this.sortedPoints[j];
				 for(int k=j+1;k<this.sortedPoints.length;k++) {
					 Point p3 = this.sortedPoints[k];
					 for(int l=k+1; l<this.sortedPoints.length;l++) {
						 Point p4 = this.sortedPoints[l];
						 if(isCollinear(p1,p2,p3,p4)) {
							 linesList.add(new LineSegment(p1,p4));
						 }
					 }
				 }
			 }
		}
	}
}