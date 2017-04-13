package nl.ru.ai.hci.assigment2;
import java.awt.Color;
import java.awt.Graphics2D;

public interface Drawable 
{
	public void draw(Graphics2D g);
	
	public void setCoordinates(double x1, double y1, double x2, double y2);
	
	public double [] getCoordinates();
	
	boolean contains(int x, int y);
	
	//public void setColor(Color c);
	
	public String shape();

	
}


