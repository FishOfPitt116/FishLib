package Graphics;

import java.awt.Polygon;
import Graphics.Line;
import java.util.ArrayList;

/**
 * This class is an add-on class for java.awt.Polygon, with new methods and functions that can be performed to create and alter Polygons.
 * @author fishofpitt116
 * @version 1.0
 * @since 11-10-2020
 *
 */
public class Polygons {
	/**
	 * Method which creates a regular polygon.
	 * 
	 * Polygon is created given a center point (x,y), a radius from the center
	 * point to each corner, and a number of sides. Note that this method will
	 * generate a simple polygon if less than 3 sides are chosen.
	 * 
	 * @param x x coordinate of center point
	 * @param y y coordinate of center point
	 * @param rad distance from center point to any given corner of polygon
	 * @param sides number of sides (should be greater than or equal to 3)
	 * @return Regular polygon given these parameters
	 */
	public static Polygon createRegularPolygon(int x, int y, int rad, int sides) {
        if (sides < 3) {
            System.out.println("Polygon unable to be drawn");
            return new Polygon();
        }
        double angle = (2*Math.PI)/sides;
        int[] xValues = new int[sides];
        int[] yValues = new int[sides];
        for (int i = 0; i < sides; i++) {
            xValues[i] = x + (int) (rad * Math.cos(angle*i));
            yValues[i] = y + (int) (rad * Math.sin(angle*i));
            System.out.println("The x value for point " + i + " is " + xValues[i] + " and the y value is " + yValues[i]);
        }
        return new Polygon(xValues, yValues, sides);
    }

	/**
	 * Method which creates a rotated regular polygon, with rotation.
	 * 
	 * Polygon is created given a center point (x,y), a radius from the center
	 * point to each corner, a number of sides, and an angle which the
	 * polygon is rotated in radians. Note that this method will generate
	 * a simple polygon if less than 3 sides are chosen.
	 * 
	 * @param x x coordinate of center point
	 * @param y y coordinate of center point
	 * @param rad distance from cetner point to any given corner of polygon
	 * @param sides number of sides (should be greater than or equal to 3)
	 * @param angle Angle of rotation, in radians
	 * @return Regular polygon given these parameters
	 */
    public static Polygon createRegularPolygon(int x, int y, int rad, int sides, double angle) {
        if (sides < 3) {
            System.out.println("Polygon unable to be drawn");
            return new Polygon();
        }
        double angleDiff = (2*Math.PI)/sides;
        int[] xValues = new int[sides];
        int[] yValues = new int[sides];
        for (int i = 0; i < sides; i++) {
            xValues[i] = x + (int) (rad * (Math.cos((angleDiff * i) + angle)));
            yValues[i] = y + (int) (rad * (Math.sin((angleDiff * i) + angle)));
            System.out.println("The x value for point " + i + " is " + xValues[i] + " and the y value is " + yValues[i]);
        }
    return new Polygon(xValues, yValues, sides);

     }

    /**
     * This method creates a quadratic curve in the form of an arraylist of lines (from FishLib.Graphics.Line)
     * 
     * Line is generated in vertex form. The pararmeters used are the starting and finishing point
     * (x1, y1) and (x2, y2), the vertex of the curve (h,k), and the amount of specificity required
     * when drawing the curve in the form of the parameter lines. The more lines used, the more
     * smooth the curve will be. Note that it is highly recommended not to use more than approxamitely
     * 100 lines for the curve, as memory may be used quite quickly and/or it may take a while to load
     * your curve.
     * 
     * @param startX Starting x value of the curve
     * @param startY Starting y value of the curve
     * @param vertexX Vertex x value of the curve
     * @param vertexY Vertex y value of the curve
     * @param finishX Ending x value of the curve
     * @param finishY Ending y value of the curve
     * @param lines Number of lines the curve will be broken up into
     * @return ArrayList of Lines representing a curve given these parameters
     */
    public static ArrayList<Line> createCurve(int startX, int startY, int vertexX, int vertexY, int finishX, int finishY, int lines) {
    	ArrayList<Line> curve = new ArrayList<Line>();
    	double a = ((double) startY - (double) vertexY)/Math.pow(((double) startX - (double) vertexX), 2);
    	//y = a(x-vertexX)^2 + vertexY
    	double y1 = startY;
    	for (double i = startX; i < finishX; i+=((finishX-startX)/lines)) {
            double x2 = i+((finishX-startX)/lines);
    		double y2 = a*Math.pow((x2-vertexX), 2) + vertexY;
            curve.add(new Line((int) i, (int) x2, (int) y1, (int) y2));
            // System.out.println("Line goes from (" + i + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
            y1 = y2;
    	}
    	return curve;
    }
}
