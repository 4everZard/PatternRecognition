import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
 

public class FastCollinearPoints {
	private Point[] points;
	private LineSegment[] lines;
	private List<LineSegment> linesList;
	private Point[] sortedPoints;
	private int length;
	
	
	public FastCollinearPoints(Point[] points) {
		this.points = points;
		length = points.length;
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
		lines = new LineSegment[linesList.size()];
	    lines = linesList.toArray(lines);		
	}
	
	  public int numberOfSegments() {
	        return lines.length;
	  }
	  
	  public LineSegment[] segments() {
	        return lines;
	  }
	  
	  private void addLineSegment() {
		  int j,k;
		  for(int i=0; i<length; i++) {
			  Point[] aux = sortedPoints.clone();
			  Arrays.sort(aux,sortedPoints[i].SLOPE_ORDER); // sort the points according to the slopes it makes with p
			  Point origin = aux[0];            // think of p as the origin
			  j=1;
			  while(j<length-1) {
				  k=j+1;
				  while(origin.slopeTo(aux[j])==origin.slopeTo(aux[k])) {
					  k++;
					  if(k>length-1) break;	
				  }
				  if(k-j>=3&&k<=length) {
					  if (aux[k-1].compareTo(origin) > 0 && aux[j].compareTo(origin) > 0) { // Both should be "above"
	                        linesList.add(new LineSegment(origin,aux[k-1]));
					  }
				  }
				  j=k;  
			  }
		
		  }
	  }
	  
	  
	  
	  
	  
	  
	  
	  
}