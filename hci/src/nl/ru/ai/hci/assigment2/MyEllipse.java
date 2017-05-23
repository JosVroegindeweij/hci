package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class MyEllipse implements Drawable {
	private double x1, x2, y1, y2;
	public String name = "ellipse";
	private Color fill=Color.WHITE, outline=Color.GRAY;
	private int lineWidth;

	public MyEllipse() {
	}

	/**
	 * Creates a new ellipse
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
	 *            = the color of the ellipse
	 */
	public MyEllipse(double x1, double y1, double x2, double y2, Color fill, Color outline, int lineWidth) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.fill = fill;
		this.outline = outline;
		this.lineWidth = lineWidth;
	}

	/**
	 * Draws the ellipse
	 * 
	 * @param g
	 *            = the ellipse
	 */
	@Override
	public void draw(Graphics2D g) {
		// Gets the values needed to specify the position and the size of the
		// rectangle
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		// Creates a ellipse with these values
		Ellipse2D e = new Ellipse2D.Double(x, y, width, height);
		// Sets color of the edge of the ellipse
		g.setColor(outline);
		// Draws the ellipse
		g.draw(e);
		// Sets the color of the inside of the ellipse
		g.setColor(fill);
		// WTF AGAIN KIM WAT DOE JE
		g.fill(e);
	}
	/**
	 * gets the width of the ellipse
	 * 
	 * @return width of ellipse
	 */
	private double getWidth() {
		return Math.abs(x1 - x2);
	}
	/**
	 * gets the height of the ellipse
	 * 
	 * @return height of ellipse
	 */
	private double getHeight() {
		return Math.abs(y1 - y2);
	}
	/**
	 * gets the x-coordinate of the topleft corner of the ellipse. This is the
	 * smallest x
	 * 
	 * @return smallest x-coordinate
	 */
	private double getStartX() {
		return Math.min(x1, x2);
	}
	/**
	 * gets the y-coordinate of the topleft corner of the ellipse. This is the
	 * smallest y
	 * 
	 * @return smallest y-coordinate
	 */
	private double getStartY() {
		return Math.min(y1, y2);
	}
	/**
	 * sets the coordinates of the ellipse (used for resizing)
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
	 * gets the current coordinates of the ellipse and returns it in an array
	 * @return array with coordinates
	 * 
	 */
	@Override
	public double[] getCoordinates() {
		double[] coordinates = { x1, y1, x2, y2 };
		return coordinates;
	}
	/**
	 * checks whether a position is within the ellipse
	 * @return a boolean whether the ellipse contains these coordinates
	 */
	@Override
	public boolean contains(int x, int y) {
		return (x > x1 && x < x2 && y > y1 && y < y2);
	}
	
	@Override
	public Directions borderContains(int x, int y) {
		if (Line2D.ptSegDist(x1, y1, x1 + (getWidth() / 2), y1, x, y) < 10
				|| Line2D.ptSegDist(x1, y1, x1, y1 + (getHeight() / 2), x, y) < 10)
			return Directions.NW;
		else if (Line2D.ptSegDist(x1 + (getWidth() / 2), y1, x2, y1, x, y) < 10
				|| Line2D.ptSegDist(x2, y1, x2, y1 + (getHeight() / 2), x, y) < 10)
			return Directions.NE;
		else if (Line2D.ptSegDist(x2, y1 + (getHeight() / 2), x2, y2, x, y) < 10
				|| Line2D.ptSegDist(x1 + (getWidth() / 2), y2, x2, y2, x, y) < 10)
			return Directions.SE;
		else if (Line2D.ptSegDist(x1, y1 + (getHeight() / 2), x1, y2, x, y) < 10
				|| Line2D.ptSegDist(x1, y2, x1 + (getWidth() / 2), y2, x, y) < 10)
			return Directions.SW;

		return Directions.NA;
	}

	// @Override
	// public void setColor(Color c) {
	// // TODO Auto-generated method stub
	// }
	/**
	 * returns the string "Ellipse"
	 * @return "Ellipse"
	 */
	@Override
	public String shape() {
		return "Ellipse";
	}
}
