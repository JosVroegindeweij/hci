package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyEllipse  implements Drawable
{
	private double x1, x2, y1, y2;
	public String name = "ellipse";
	private Color fill;
	private Color outline;
	public MyEllipse()
	{	
	}
	
	public MyEllipse(double x1, double y1, double x2, double y2, Color fill, Color outline)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.fill = fill;
		this.outline = outline;
	} 
	
	@Override
	public void draw(Graphics2D g)
	{
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		Ellipse2D e = new Ellipse2D.Double(x, y, width, height);
		g.setColor(outline);
		g.draw(e);
		g.setColor(fill);
		g.fill(e);
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

//	@Override
//	public void setColor(Color c) {
//		// TODO Auto-generated method stub
//	}
	
	@Override
	public String shape()
	{
		return "Ellipse";
	}
}

