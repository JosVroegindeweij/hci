package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class MyLine implements Drawable
{
	private double x1, y1, x2, y2;
	public String name = "line";
	private Color c;
	
	public MyLine()
	{	
	}
	
	public MyLine(double x1, double y1, double x2, double y2, Color c)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.c = c;
	}
	
	@Override
	public void draw(Graphics2D g)
	{
		Line2D l = new Line2D.Double(x1, y1, x2, y2);
		g.setColor(c);
		g.draw(l);
	}
	
	private double getWidth() 
	{
		return Math.abs(x1 - x2);
	}

	private double getHeight() 
	{
		if(y1==getStartY())
			if(y1<y2)
				return Math.abs(y1-y2);
			else
				return -(Math.abs(y1-y2));
		else
			if(y1<y2)
				return -(Math.abs(y1-y2));
			else
				return Math.abs(y1-y2);
	}
	
	private double getStartX() 
	{
		return Math.min(x1, x2);
	}

	private double getStartY() 
	{
		 if(x1<x2)
			 return y1;
		 return y2;
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
		return Line2D.ptSegDist(getStartX(), getStartY(), getStartX() + getWidth(), getStartY() + getHeight(), x, y) < 5;
	}

//	@Override
//	public void setColor(Color c) {
//		// TODO Auto-generated method stub	
//	}

	@Override
	public String shape() 
	{
		return "Line";
	}
	

}