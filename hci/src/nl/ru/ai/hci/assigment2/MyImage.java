package nl.ru.ai.hci.assigment2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class MyImage implements Drawable {
	private double x1, y1, x2, y2;
	public String name = "Image";
	private BufferedImage image;

	public MyImage() {
	}

	/**
	 * Creates a new Image
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
	 *            = the color of the Image
	 */
	public MyImage(BufferedImage img, double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.image = (BufferedImage) img;
	}

	/**
	 * Draws the Image
	 * 
	 * @param g
	 *            = the Image
	 */
	@Override
	public void draw(Graphics2D g) {
		// Gets the values needed to specify the position and the size of the
		// Image
		int x = (int)getStartX();
		int y = (int)getStartY();
		int width = (int)getWidth();
		int height = (int)getHeight();
		// Creates a Image with these values
//		BufferedImage img = new BufferedImage(img, x, y, width, height);
		g.drawImage(this.image, x, y, width, height, null);

	}

	/**
	 * gets the width of the Image
	 * 
	 * @return width of Image
	 */
	private double getWidth() {
		return Math.abs(x1 - x2);
	}

	/**
	 * gets the height of the Image
	 * 
	 * @return height of Image
	 */
	private double getHeight() {
		return Math.abs(y1 - y2);
	}

	/**
	 * gets the x-coordinate of the topleft corner of the Image. This is the
	 * smallest x
	 * 
	 * @return smallest x-coordinate
	 */
	private double getStartX() {
		return Math.min(x1, x2);
	}

	/**
	 * gets the y-coordinate of the topleft corner of the Image. This is the
	 * smallest y
	 * 
	 * @return smallest y-coordinate
	 */
	private double getStartY() {
		return Math.min(y1, y2);
	}

	/**
	 * sets the coordinates of the Image (used for resizing)
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
	 * gets the current coordinates of the Image and returns it in an array
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
	 * checks whether a position is within the Image
	 * 
	 * @return a boolean whether the Image contains these coordinates
	 */
	@Override
	public boolean contains(int x, int y) {
		return (x > Math.min(x1, x2) && x < Math.max(x1, x2) && y > Math.min(y1, y2) && y < Math.max(y1, y2));
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

	/**
	 * returns the string "Image"
	 * 
	 * @return "Image"
	 */
	@Override
	public String shape() {
		return "Image";
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
	
	public boolean isMyImage(){
		double[] coordinates = this.getCoordinates();
		double x1 = coordinates[0];
		double y1 = coordinates[1];
		double x2 = coordinates[2];
		double y2 = coordinates[3];
		MyImage image = new MyImage(this.image,x1,y1,x2,y2);
		return image.equals(this);
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
	public boolean isMyLine() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMyText() {
		// TODO Auto-generated method stub
		return false;
	}
}