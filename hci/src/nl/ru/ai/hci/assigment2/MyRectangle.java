package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle implements Drawable 
{
	private double x1, y1, x2, y2;
	public String name = "rectangle";
	private Color color;
	
	public MyRectangle() 
	{
	}
	
	public MyRectangle(double x1, double y1, double x2, double y2, Color color) 
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	@Override
	public void draw(Graphics2D g) 
	{
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		Rectangle2D r = new Rectangle2D.Double(x, y, width, height);
		g.setColor(color);
		g.draw(r);
		g.fill(r);
	}

	
	private double getWidth() 
	{
		return Math.abs(x1 - x2);
	}

	private double getHeight() 
	{
		return Math.abs(y1 - y2);
	}

	private double getStartX() 
	{
		return Math.min(x1, x2);
	}

	private double getStartY() 
	{
		return Math.min(y1, y2);
	}
	
	@Override
	public void setCoordinates(double x1, double y1, double x2, double y2) 
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
//	@Override
//	public void setColor(Color c) 
//	{
//		this.color = c;
//	}
	
	@Override
	public double [] getCoordinates() 
	{
		double [] coordinates = {x1, y1, x2, y2};
		return coordinates;
	}
	
	@Override
	public boolean contains(int x, int y)
	{
		return(x > Math.min(x1, x2) && x < Math.max(x1,x2) && y > Math.min(y1, y2) && y < Math.max(y1, y2));
	}
	
	@Override
	public String shape()
	{
		return "Rectangle";
	}
}