package nl.ru.ai.hci.assigment2;

import java.awt.Color;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private JButton fill, outline;

	/**
	 * Creates a ButtonPanel (a group of buttons)
	 * 
	 * @param dp
	 *            = a DrawPanel
	 * @param input
	 *            = an InputHandler
	 * @param type
	 *            = the type of ButtonPanel
	 * 
	 */

	public ButtonPanel(DrawPanel dp, InputHandler input, ButtonPanelType type) {
		super();
		switch (type) {
		case SHAPES:
			// Makes a new button called ell with text "Ellipse"
			JButton ell = new JButton("Ellipse");
			// Adds the button to the window
			add(ell);
			// InputHandler used when the button is clicked
			ell.addActionListener(input);
			// For the InputHandler, this name distinguishes the button from
			// other buttons
			ell.setActionCommand("ell");

			JButton line = new JButton("Line");
			add(line);
			line.addActionListener(input);
			line.setActionCommand("line");

			JButton rec = new JButton("Rectangle");
			add(rec);
			rec.addActionListener(input);
			rec.setActionCommand("rec");

			JButton resize = new JButton("Resize");
			add(resize);
			resize.addActionListener(input);
			resize.setActionCommand("resize");
			
			JButton del = new JButton("Delete");
			add(del);
			del.addActionListener(input);
			del.setActionCommand("del");

			JButton fill = new JButton("Fill");
			add(fill);
			fill.setBackground(Color.WHITE);
			fill.addActionListener(input);
			fill.setActionCommand("fill");
			this.fill = fill;

			JButton outline = new JButton("Outline");
			add(outline);
			outline.setBackground(Color.GRAY);
			outline.addActionListener(input);
			outline.setActionCommand("outline");
			this.outline = outline;
			
//			JButton recolor = new JButton ("Recolor");
//			add(recolor);
//			recolor.addActionListener(input);
//			recolor.setActionCommand("recolor");
			
			String[] lineWidths = {"Line width","2","4","6","8","10","12"};
			JComboBox lineWidth = new JComboBox(lineWidths);
			add(lineWidth);
			lineWidth.setSelectedIndex(0);
			lineWidth.setEditable(true);
			lineWidth.setVisible(true);
			lineWidth.addActionListener(input);
			lineWidth.setActionCommand("lineWidth");
			break;

		case COLOR:
			JButton colorRed = new JButton("");
			add(colorRed);
			colorRed.addActionListener(input);
			colorRed.setActionCommand("colorRed");
			colorRed.setBackground(Color.RED);

			JButton colorMagenta = new JButton("");
			add(colorMagenta);
			colorMagenta.addActionListener(input);
			colorMagenta.setActionCommand("colorMagenta");
			colorMagenta.setBackground(Color.MAGENTA);

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

	public void changeFillColor(Color fillColor) {
		this.fill.setBackground(fillColor);
	}

	public void changeOutlineColor(Color outlineColor) {
		this.outline.setBackground(outlineColor);
	}
	
	public JButton getFill(){
		return this.fill;
	}
	
	public JButton getOutline(){
		return this.outline;
	}
}
