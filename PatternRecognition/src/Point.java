import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;
public class Point implements Comparable<Point> {
   private final int x;     // x-coordinate of this point
   private final int y;     // y-coordinate of this point
   public Point(int x, int y) {
	   this.x = x;
       this.y = y;
   }

   public   void draw() {
	   StdDraw.point(x, y);
	   
   }
   public void drawTo(Point that) {
	   StdDraw.line(this.x, this.y, that.x, that.y);
   }
   public String toString()   {
	   return "(" + x + ", " + y + ")";
   }

   public int compareTo(Point that) {
	   
   }
   public double slopeTo(Point that) {
	   
   }
   public Comparator<Point> slopeOrder(){
	   
   }
}