package Graphics;

/**
 * This Line class represents a simple line on a graph, that can be 
 * useful for other graphic libraries.
 * 
 * @author fishofpitt116
 * @version 1.0
 * @since 11-10-2020
 */

public class Line {
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	public Line (int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
    
    /**
     * Gets line's first x value
     * @return x1
     */
	public int getX1() {
		return x1;
	}
    
    /**
     * Gets line's second x value
     * @return x2
     */
	public int getX2() {
		return x2;
	}
    
    /**
     * Gets line's first y value
     * @return y1
     */
	public int getY1() {
		return y1;
	}
    
    /**
     * Gets line's second y value
     * @return y2
     */
	public int getY2() {
		return y2;
    }
    
    /**
     * Gets line's length using the distance formula
     * @return Distance of line
     */
    public double getLength() {
        return Math.sqrt(y2-y1)/Math.sqrt(x2-x1);
    }
}