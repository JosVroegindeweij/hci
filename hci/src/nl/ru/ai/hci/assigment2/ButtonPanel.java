package nl.ru.ai.hci.assigment2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ButtonPanel extends JPanel
{
	private DrawPanel dp;
	public ButtonPanel(DrawPanel dp, InputHandler input, ButtonPanelType type) 
	{
		super();
		this.dp = dp;
		// Add a button to the panel . The argument to the JButton constructor
		// will become the text on the button .
		switch(type)
		{
		case SHAPES:
			JButton ell = new JButton("Ellipse");
			add(ell);
			ell.addActionListener(input);
			ell.setActionCommand("ell");
			
			JButton line = new JButton("Line");
			add(line);
			line.addActionListener(input);
			line.setActionCommand("line");
			
			JButton rec = new JButton("Rectangle");
			add(rec);
			rec.addActionListener(input);
			rec.setActionCommand("rec");
			
			JButton del = new JButton("Delete");
			add(del);
			del.addActionListener(input);
			del.setActionCommand("del");
			
			JButton fill = new JButton("Fill");
			add(fill);
			fill.addActionListener(input);
			fill.setActionCommand("fill");
			
			JButton outline = new JButton("Outline");
			add(outline);
			outline.addActionListener(input);
			outline.setActionCommand("outline");
			
			break;
			
			
		
		case COLOR:
			JButton colorRed = new JButton("");
	        add(colorRed);
	        colorRed.addActionListener(input);
	        colorRed.setActionCommand("colorRed");
	        colorRed.setBackground(Color.RED);
	        
	        JButton colorPurple = new JButton("");
	        add(colorPurple);
	        colorPurple.addActionListener(input);
	        colorPurple.setActionCommand("colorPurple");
	        colorPurple.setBackground(Color.MAGENTA);
	        
	        JButton colorPink = new JButton("");
	        add(colorPink);
	        colorPink.addActionListener(input);
	        colorPink.setActionCommand("colorPink");
	        colorPink.setBackground(Color.PINK);	        
	       
	        JButton colorOrange = new JButton("");
	        add(colorOrange);
	        colorOrange.addActionListener(input);
	        colorOrange.setActionCommand("colorOrange");
	        colorOrange.setBackground(Color.ORANGE);
	        
	        JButton colorYellow = new JButton("");
	        add(colorYellow);
	        colorYellow.addActionListener(input);
	        colorYellow.setActionCommand("colorYellow");
	        colorYellow.setBackground(Color.YELLOW);
	        
	        JButton colorGreen = new JButton("");
	        add(colorGreen);
	        colorGreen.addActionListener(input);
	        colorGreen.setActionCommand("colorGreen");
	        colorGreen.setBackground(Color.GREEN);
	
	        JButton colorBlue = new JButton("");
	        add(colorBlue);
	        colorBlue.addActionListener(input);
	        colorBlue.setActionCommand("colorBlue");
	        colorBlue.setBackground(Color.BLUE);
	
	        JButton colorBlack = new JButton("");
	        add(colorBlack);
	        colorBlack.addActionListener(input);
	        colorBlack.setActionCommand("colorBlack");
	        colorBlack.setBackground(Color.BLACK);
	        
	        JButton colorGray = new JButton("");
	        add(colorGray);
	        colorGray.addActionListener(input);
	        colorGray.setActionCommand("colorGray");
	        colorGray.setBackground(Color.DARK_GRAY);
	        
	        JButton colorWhite = new JButton("");
	        add(colorWhite);
	        colorWhite.addActionListener(input);
	        colorWhite.setActionCommand("colorWhite");
	        colorWhite.setBackground(Color.WHITE);
	        break;
		}
	}
}
