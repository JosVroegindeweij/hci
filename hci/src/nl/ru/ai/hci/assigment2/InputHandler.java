package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.awt.Graphics;


public class InputHandler implements ActionListener, MouseListener, MouseMotionListener
{	
	private DrawPanel dp;
	private Mode mode;
	private Color fill;
	private Color outline = Color.BLACK;
	public InputHandler(DrawPanel draw)
	{
		dp = draw;
		dp.addMouseListener(this);
		dp.addMouseMotionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
	
		switch(e.getActionCommand())
		{
		case "rec":
		//	dp.addRectangle();
			this.mode = Mode.RECTANGLE;
			break;
		case "ell":
		//	dp.addEllipse();
			this.mode = Mode.ELLIPSE;
			break;
		case "line":
		//	dp.addLine();
			this.mode = Mode.LINE;
			break;
		case "del":
		//	dp.deleteShape();
			this.mode = Mode.DELETE;
			break;
		case "fill":
			this.mode = Mode.FILL;
			break;
		case "outline":
			this.mode = Mode.OUTLINE;
			break;
		case "colorRed":
			fill = Color.RED;
			break;
		case "colorPurple":
			fill = Color.MAGENTA;
			break;
		case "colorPink":
			fill = Color.PINK;
			break;
		case "colorOrange":
			fill = Color.ORANGE;
			break;
		case "colorYellow":
			fill = Color.YELLOW;
			break;
		case "colorGreen":
			fill = Color.GREEN;
			break;
		case "colorBlue":
			fill = Color.BLUE;
			break;
		case "colorBlack":
			fill = Color.BLACK;
			break;
		case "colorGray":
			fill = Color.DARK_GRAY;
			break;
		case "colorWhite":
			fill = Color.WHITE;
			break;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent m) 
	{
		//System.out.println("mouseClicked");
	}
	
	@Override
	public void mouseEntered(MouseEvent m) 
	{
		//System.out.println("mouseEntered");
	}
	
	@Override
	public void mouseExited(MouseEvent m) 
	{
		//System.out.println("mouseExited");
	}
	
	@Override
	public void mousePressed(MouseEvent m) 
	{
		System.out.println("MousePressed");
		switch(this.mode)
		{
		case RECTANGLE:
			dp.addRectangle(m.getX(), m.getY(), fill);
			break;
		case ELLIPSE:
			dp.addEllipse(m.getX(), m.getY(), fill, outline);
			break;
		case LINE:
			dp.addLine(m.getX(), m.getY(), fill);
			break;
		case DELETE:
			dp.deleteShape(m.getX(), m.getY());
			break; 
		case FILL:
			dp.changeFill(m.getX(), m.getY(), fill, outline);
		case OUTLINE:
			dp.changeOutline(m.getX(), m.getY(), fill,  outline);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent m) 
	{
		if(this.mode != Mode.DELETE && this.mode != Mode.FILL&& this.mode != Mode.OUTLINE)
		{
		Drawable shapie = dp.getShapesList().get(dp.getShapesList().size()-1);
		double [] coordinates = shapie.getCoordinates();
		double x1 = coordinates[0];
		double y1 = coordinates[1];
		double x2 = m.getX();
		double y2 = m.getY();
		shapie.setCoordinates(x1, y1, x2, y2);
		}	
	}
	
	@Override
	public void mouseMoved(MouseEvent m) 
	{
		//System.out.println("mouseMoved");
	}
	
	@Override
	public void mouseReleased(MouseEvent m) 
	{
		//System.out.println("mouseReleased");
	}


	
	

}
