package nl.ru.ai.hci.assigment2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyText implements Drawable {
	private double width;
	private double height;
	private double x1, y1, x2, y2;
	public String name = "Text";
	private String text;
	private Color color = Color.BLACK;
	private int fontSize;


	public MyText() {
	}

	/**
	 * Creates a new Text
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
	 *            = the color of the Text
	 */
	public MyText(String text, double x1, double y2, Color color, int fontSize) {
		this.x1 = x1;
		this.y2 = y2;
		this.text = text;
		this.color = color;
		this.fontSize = fontSize;
	}

	/**
	 * Draws the Text
	 * 
	 * @param g
	 *            = the Text
	 */
	@Override
	public void draw(Graphics2D g) {
		int x = (int)this.x1;
		int y = (int)this.y2;
		g.setColor(color);
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize)); 
		g.drawString(this.text, x, y);
		width = g.getFontMetrics().stringWidth(text);
		height = g.getFontMetrics().getHeight();
		x2 = x1 + width;
		y1 = y2 - height;
		//g.drawRect(x, (int) y1, (int)width, (int)height);
	}

	/**
	 * gets the width of the Text
	 * 
	 * @return width of Text
	 */
	private double getWidth() {
		return width;
	}

	/**
	 * gets the height of the Text
	 * 
	 * @return height of Text
	 */
	private double getHeight() {
		return height;
	}

	/**
	 * gets the x-coordinate of the topleft corner of the Text. This is the
	 * smallest x
	 * 
	 * @return smallest x-coordinate
	 */
	private double getStartX() {
		return Math.min(x1, x2);
	}

	/**
	 * gets the y-coordinate of the topleft corner of the Text. This is the
	 * smallest y
	 * 
	 * @return smallest y-coordinate
	 */
	private double getStartY() {
		return Math.min(y1, y2);
	}

	/**
	 * sets the coordinates of the Text (used for resizing)
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
	public void setCoordinates(double x1, double y2, double x2, double y1) {
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
	 * gets the current coordinates of the Text and returns it in an array
	 * 
	 * @return array with coordinates
	 * 
	 */
	@Override
	public double[] getCoordinates() {
		double[] coordinates = { x1, y2, x2, y1 };
		return coordinates;
	}

	/**
	 * checks whether a position is within the Text
	 * 
	 * @return a boolean whether the Text contains these coordinates
	 */
	@Override
	public boolean contains(int x, int y) {
		//Sysout.println("x1="+this.x1+" x2="+ this.x2 + " y1=" + this.y1 + " y2=" + this.y2);
		System.out.println(x > Math.min(x1, x2) && x < Math.max(x1, x2) && y > Math.min(y1, y2) && y < Math.max(y1, y2));
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
	 * returns the string "Text"
	 * 
	 * @return "Text"
	 */
	@Override
	public String shape() {
		return "Text";
	}
	
	@Override
	public String getText()
	{
		return this.text;
	}
	
	@Override
	public int getFontSize()
	{
		return this.fontSize;
	}
	
	public boolean isMyText(){
		MyText text = new MyText(this.text,this.x1,this.y1,this.color, this.fontSize);
		return text.equals(this);
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
	public boolean isMyImage() {
		// TODO Auto-generated method stub
		return false;
	}
}