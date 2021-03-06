package nl.ru.ai.hci.assigment2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle implements Drawable {
	private double x1, y1, x2, y2;
	public String name = "rectangle";
	private Color fill = Color.WHITE, outline = Color.GRAY;
	private int lineWidth;

	public MyRectangle() {
	}

	/**
	 * Creates a new rectangle
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
	 *            = the color of the rectangle
	 */
	public MyRectangle(double x1, double y1, double x2, double y2, Color fill, Color outline, int lineWidth) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.fill = fill;
		this.outline = outline;
		this.lineWidth = lineWidth;
	}

	/**
	 * Draws the rectangle
	 * 
	 * @param g
	 *            = the rectangle
	 */
	@Override
	public void draw(Graphics2D g) {
		// Gets the values needed to specify the position and the size of the
		// rectangle
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		// Creates a rectangle with these values
		Rectangle2D r = new Rectangle2D.Double(x, y, width, height);
		// Sets the color of the rectangle
		g.setStroke(new BasicStroke(lineWidth));
		g.setColor(outline);
		// Draws the rectangle
		g.draw(r);
		g.setColor(fill);
		// Set the fill color
		g.fill(r);
	}

	/**
	 * gets the width of the rectangle
	 * 
	 * @return width of rectangle
	 */
	private double getWidth() {
		return Math.abs(x1 - x2);
	}

	/**
	 * gets the height of the rectangle
	 * 
	 * @return height of rectangle
	 */
	private double getHeight() {
		return Math.abs(y1 - y2);
	}

	/**
	 * gets the x-coordinate of the topleft corner of the rectangle. This is the
	 * smallest x
	 * 
	 * @return smallest x-coordinate
	 */
	private double getStartX() {
		return Math.min(x1, x2);
	}

	/**
	 * gets the y-coordinate of the topleft corner of the rectangle. This is the
	 * smallest y
	 * 
	 * @return smallest y-coordinate
	 */
	private double getStartY() {
		return Math.min(y1, y2);
	}

	/**
	 * sets the coordinates of the rectangle (used for resizing)
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

	// @Override
	// public void setColor(Color c)
	// {
	// this.color = c;
	// }

	/**
	 * gets the current coordinates of the rectangle and returns it in an array
	 * 
	 * @return array with coordinates
	 * 
	 */
	@Override
	public double[] getCoordinates() {
		double[] coordinates = { x1, y1, x2, y2 };
		return coordinates;
	}

	/**
	 * checks whether a position is within the rectangle
	 * 
	 * @return a boolean whether the rectangle contains these coordinates
	 */
	@Override
	public boolean contains(int x, int y) {
		return (x > Math.min(x1, x2) && x < Math.max(x1, x2) && y > Math.min(y1, y2) && y < Math.max(y1, y2));
	}

	@Override
	public Directions borderContains(int x, int y) {
		if (Line2D.ptSegDist(x1, y1, x1 + (getWidth() / 2), y1, x, y) < 20
				|| Line2D.ptSegDist(x1, y1, x1, y1 + (getHeight() / 2), x, y) < 20)
			return Directions.NW;
		else if (Line2D.ptSegDist(x1 + (getWidth() / 2), y1, x2, y1, x, y) < 20
				|| Line2D.ptSegDist(x2, y1, x2, y1 + (getHeight() / 2), x, y) < 20)
			return Directions.NE;
		else if (Line2D.ptSegDist(x2, y1 + (getHeight() / 2), x2, y2, x, y) < 20
				|| Line2D.ptSegDist(x1 + (getWidth() / 2), y2, x2, y2, x, y) < 20)
			return Directions.SE;
		else if (Line2D.ptSegDist(x1, y1 + (getHeight() / 2), x1, y2, x, y) < 20
				|| Line2D.ptSegDist(x1, y2, x1 + (getWidth() / 2), y2, x, y) < 20)
			return Directions.SW;

		return Directions.NA;
	}

	/**
	 * returns the string "Rectangle"
	 * 
	 * @return "Rectangle"
	 */
	@Override
	public String shape() {
		return "Rectangle";
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
	
	public boolean isMyRectangle(){
		return true;
	}

	@Override
	public boolean isMyEllipse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMyLine() {
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
}