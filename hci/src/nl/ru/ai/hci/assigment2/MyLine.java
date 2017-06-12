package nl.ru.ai.hci.assigment2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyLine implements Drawable {
	private double x1, y1, x2, y2;
	public String name = "line";
	private Color fill = Color.WHITE;
	private int lineWidth;

	public MyLine() {
	}

	/**
	 * Creates a new line
	 * 
	 * @param x1
	 *            = the x1 coordinate
	 * @param y1
	 *            = the y1 coordinate
	 * @param x2
	 *            = the x2 coordinate
	 * @param y2
	 *            = the y2 coordinate
	 * @param color
	 *            = the color of the line
	 */
	public MyLine(double x1, double y1, double x2, double y2, Color fill, int lineWidth) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.fill = fill;
		this.lineWidth = lineWidth;
	}

	/**
	 * Draws the line
	 * 
	 * @param g
	 *            = the line
	 */
	@Override
	public void draw(Graphics2D g) {
		// Creates a line with the coordinates stored in this object
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		g.setStroke(new BasicStroke(lineWidth));
		// Sets the color of the line
		g.setColor(this.fill);
		// Draws the line
		g.draw(line);
	}

	/**
	 * gets the width of the line
	 * 
	 * @return width of line
	 */
	private double getWidth() {
		return Math.abs(x1 - x2);
	}

	/**
	 * gets the height of the line
	 * 
	 * @return height of line
	 */
	private double getHeight() {
		// First if-else statement checks whether y1 is the y-coordinate
		// belonging to the smallest x
		if (y1 == getStartY())
			// Second if-else statement checks whether y1 is bigger or smaller
			// than y2
			if (y1 < y2)
				// If smaller, then it should just return the abs
				return Math.abs(y1 - y2);
			else
				// Else it should return a negative height
				return -(Math.abs(y1 - y2));
		else if (y1 < y2)
			return -(Math.abs(y1 - y2));
		else
			return Math.abs(y1 - y2);
	}

	/**
	 * gets the most left x-coordinate of the line. This is the smallest x
	 * 
	 * @return smallest x-coordinate
	 */
	private double getStartX() {
		return Math.min(x1, x2);
	}

	/**
	 * gets the y-coordinate that belongs to the smallest x
	 * 
	 * @return y-coordinate belonging to smallest x
	 */
	private double getStartY() {
		if (x1 < x2)
			return y1;
		return y2;
	}

	/**
	 * sets the coordinates of the line (used for resizing)
	 * 
	 * @param x1
	 *            = new x1 coordinate
	 * @param y1
	 *            = new y1 coordinate
	 * @param x2
	 *            = new x2 coordinate
	 * @param y2
	 *            = new y2 coordinate
	 */
	@Override
	public void setCoordinates(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * gets the current coordinates of the line in an array
	 * 
	 * @return array with coordinates
	 */
	@Override
	public double[] getCoordinates() {
		double[] coordinates = { x1, y1, x2, y2 };
		return coordinates;
	}

	/**
	 * checks whether a position is fairly close to the line
	 * 
	 * @return a boolean whether the point is witin 10 of the line
	 */
	@Override
	public boolean contains(int x, int y) {
		return Line2D.ptSegDist(getStartX(), getStartY(), getStartX() + getWidth(), getStartY() + getHeight(), x,
				y) < 10;
	}

	

	/**
	 * returns the string "Line"
	 * 
	 * @return "Line"
	 */
	@Override
	public String shape() {
		return "Line";
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFontSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isMyLine(){
		double[] coordinates = this.getCoordinates();
		double x1 = coordinates[0];
		double y1 = coordinates[1];
		double x2 = coordinates[2];
		double y2 = coordinates[3];
		MyLine line = new MyLine(x1,y1,x2,y2,this.fill, this.lineWidth);
		return line.equals(this);
	}

	@Override
	public boolean isMyRectangle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMyEllipse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMyText() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMyImage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Directions borderContains(int x, int y) {
		//Not finished yet, doesn't completely work
		if (Math.sqrt((getStartX() - x) * (getStartX() - x) + (getStartY() - y) * (getStartY() - y)) < 10)
			return Directions.W;
		else if (Math.sqrt((getStartX()+getWidth() - x) * (getStartX()+getWidth() - x) + (getStartY()+getHeight() - y) * (getStartY()+getHeight() - y)) < 10)
			return Directions.E;
	return Directions.NA;
	}

}