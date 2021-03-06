package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	private Color color;
	private ArrayList<Drawable> shapesList = new ArrayList <Drawable>();
	
	public DrawPanel()
	{
		super ();
		color = Color.BLACK;
	}
	
	public void addRectangle(int x1, int y1, Color c)
	{
		int x2 = x1;
		int y2 = y1;
		shapesList.add(new MyRectangle(x1, y1, x2, y2, c));
	}
	
	public void addEllipse(int x1, int y1, Color fill, Color outline)
	{
		int x2 = x1;
		int y2 = y1;
		shapesList.add(new MyEllipse(x1, y1, x2, y2, fill, outline));
	}
	
	public void addLine(int x1, int y1, Color c)
	{
		int x2 = x1;
		int y2 = y1;
		shapesList.add(new MyLine(x1, y1, x2, y2, c));
		System.out.println("this is where I draw the line");
	}
	
	public void deleteShape(int xClick, int yClick)
	{
		if(shapesList.size() > 0)
		{
			boolean shapeFound = false;
			int i = shapesList.size()-1;
			while(!shapeFound && i >= 0)
			{
				if(shapesList.get(i).contains(xClick, yClick))
				{
					shapesList.remove(shapesList.get(i));
					shapeFound = true;
				}
				i--;
			}
		}
		else System.out.println("There is no shape to delete.");
	}
	
	public void changeFill(int xClick, int yClick, Color fill, Color outline)
	{
		if(shapesList.size() > 0)
		{
			boolean shapeFound = false;
			int i = shapesList.size()-1;
			while(!shapeFound && i >= 0)
			{
				if(shapesList.get(i).contains(xClick, yClick))
				{
					double[] coordinates = shapesList.get(i).getCoordinates();
					double x1 = coordinates[0];
					double y1 = coordinates[1];
					double x2 = coordinates[2];
					double y2 = coordinates[3];
					if(shapesList.get(i).shape() == "Ellipse")
						shapesList.add(new MyEllipse(x1, y1, x2, y2, fill, outline));
					if(shapesList.get(i).shape() == "Rectangle")
						shapesList.add(new MyRectangle(x1, y1, x2, y2, fill));
					if(shapesList.get(i).shape() == "Line")
						shapesList.add(new MyLine(x1, y1, x2, y2, fill));
					shapesList.remove(shapesList.get(i));
					shapeFound = true;
				}
				i--;
			}
		}
		else System.out.println("There is no shape to change.");
	}
	
	public void changeOutline(int xClick, int yClick, Color fill, Color outline) 
	{
		if(shapesList.size() > 0)
		{
			boolean shapeFound = false;
			int i = shapesList.size()-1;
			while(!shapeFound && i >= 0)
			{
				if(shapesList.get(i).contains(xClick, yClick))
				{
					double[] coordinates = shapesList.get(i).getCoordinates();
					double x1 = coordinates[0];
					double y1 = coordinates[1];
					double x2 = coordinates[2];
					double y2 = coordinates[3];
					if(shapesList.get(i).shape() == "Ellipse")
						shapesList.add(new MyEllipse(x1, y1, x2, y2, fill, outline));
					if(shapesList.get(i).shape() == "Rectangle")
						shapesList.add(new MyRectangle(x1, y1, x2, y2, fill));
					if(shapesList.get(i).shape() == "Line")
						shapesList.add(new MyLine(x1, y1, x2, y2, fill));
					shapesList.remove(shapesList.get(i));
					shapeFound = true;
				}
				i--;
			}
		}
		else System.out.println("There is no shape to change.");
	}
		
	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for(Drawable s : shapesList)
			s.draw(g2d);
		repaint();
	}
	
	public ArrayList<Drawable> getShapesList()
	{
		return this.shapesList;
	}
}
