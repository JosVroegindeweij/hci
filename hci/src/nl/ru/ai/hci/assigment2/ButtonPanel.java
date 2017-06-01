package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
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
			ImageIcon ellipse = new ImageIcon("C:/Users/josvr/Documents/GitHub/hci/hci/src/ellipse.png");
			JButton ell = new JButton(ellipse);
			ell.setPreferredSize(new Dimension(100,100));
			add(ell);
			ell.addActionListener(input);
			ell.setActionCommand("ell");

			JButton line = new JButton("Line");
			line.setPreferredSize(new Dimension(100,100));
			add(line);
			line.addActionListener(input);
			line.setActionCommand("line");

			ImageIcon rectangle = new ImageIcon("C:/Users/josvr/Documents/GitHub/hci/hci/src/rectangle.png");
			JButton rec = new JButton(rectangle);
			rec.setPreferredSize(new Dimension(100,100));
			add(rec);
			rec.addActionListener(input);
			rec.setActionCommand("rec");

			JButton select = new JButton("Select");
			select.setPreferredSize(new Dimension(100,100));
			add(select);
			select.addActionListener(input);
			select.setActionCommand("select");

			JButton del = new JButton("Delete");
			del.setPreferredSize(new Dimension(100,100));
			add(del);
			del.addActionListener(input);
			del.setActionCommand("del");

			JButton fill = new JButton("Fill");
			add(fill);
			fill.setPreferredSize(new Dimension(100,100));
			fill.setBackground(Color.WHITE);
			fill.addActionListener(input);
			fill.setActionCommand("fill");
			this.fill = fill;

			JButton outline = new JButton("Outline");
			add(outline);
			outline.setPreferredSize(new Dimension(100,100));
			outline.setBackground(Color.GRAY);
			outline.addActionListener(input);
			outline.setActionCommand("outline");
			this.outline = outline;

//			String[] fillColors = { "Select Fill Color", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "fill", "fill" };
//			JComboBox fillColor = new JComboBox(fillColors);
//			fillColor.setMaximumRowCount(5);
//			fillColor.setRenderer(new BoxCellRenderer());
//			add(fillColor);
//			fillColor.setSelectedIndex(0);
//			fillColor.setVisible(true);
//			fillColor.addActionListener(input);
//			fillColor.setActionCommand("fillColor");
//
//			String[] outlineColors = { "Select Outline Color", "outline", "outline", "outline", "outline", "outline", "outline", "outline", "outline", "outline" };
//			JComboBox outlineColor = new JComboBox(outlineColors);
//			outlineColor.setMaximumRowCount(5);
//			outlineColor.setRenderer(new BoxCellRenderer());
//			add(outlineColor);
//			outlineColor.setSelectedIndex(0);
//			outlineColor.setVisible(true);
//			outlineColor.addActionListener(input);
//			outlineColor.setActionCommand("outlineColor");
			
			String[] lineWidths = { "Line width", "2", "4", "6", "8", "10", "12" };
			JComboBox lineWidth = new JComboBox(lineWidths);
			add(lineWidth);
			lineWidth.setPreferredSize(new Dimension(200,100));
			lineWidth.setSelectedIndex(0);
			lineWidth.setEditable(true);
			lineWidth.setVisible(true);
			lineWidth.addActionListener(input);
			lineWidth.setActionCommand("lineWidth");
			break;

		case COLOR:
			JButton colorRed = new JButton("");
			add(colorRed);
			colorRed.setPreferredSize(new Dimension(40, 40));
			colorRed.addActionListener(input);
			colorRed.setActionCommand("colorRed");
			colorRed.setBackground(Color.RED);

			JButton colorMagenta = new JButton("");
			add(colorMagenta);
			colorMagenta.setPreferredSize(new Dimension(40, 40));
			colorMagenta.addActionListener(input);
			colorMagenta.setActionCommand("colorMagenta");
			colorMagenta.setBackground(Color.MAGENTA);

			JButton colorPink = new JButton("");
			add(colorPink);
			colorPink.setPreferredSize(new Dimension(40, 40));
			colorPink.addActionListener(input);
			colorPink.setActionCommand("colorPink");
			colorPink.setBackground(Color.PINK);

			JButton colorOrange = new JButton("");
			add(colorOrange);
			colorOrange.setPreferredSize(new Dimension(40, 40));
			colorOrange.addActionListener(input);
			colorOrange.setActionCommand("colorOrange");
			colorOrange.setBackground(Color.ORANGE);

			JButton colorYellow = new JButton("");
			add(colorYellow);
			colorYellow.setPreferredSize(new Dimension(40, 40));
			colorYellow.addActionListener(input);
			colorYellow.setActionCommand("colorYellow");
			colorYellow.setBackground(Color.YELLOW);

			JButton colorGreen = new JButton("");
			add(colorGreen);
			colorGreen.setPreferredSize(new Dimension(40, 40));
			colorGreen.addActionListener(input);
			colorGreen.setActionCommand("colorGreen");
			colorGreen.setBackground(Color.GREEN);

			JButton colorBlue = new JButton("");
			add(colorBlue);
			colorBlue.setPreferredSize(new Dimension(40, 40));
			colorBlue.addActionListener(input);
			colorBlue.setActionCommand("colorBlue");
			colorBlue.setBackground(Color.BLUE);

			JButton colorBlack = new JButton("");
			add(colorBlack);
			colorBlack.setPreferredSize(new Dimension(40, 40));
			colorBlack.addActionListener(input);
			colorBlack.setActionCommand("colorBlack");
			colorBlack.setBackground(Color.BLACK);

			JButton colorGray = new JButton("");
			add(colorGray);
			colorGray.setPreferredSize(new Dimension(40, 40));
			colorGray.addActionListener(input);
			colorGray.setActionCommand("colorGray");
			colorGray.setBackground(Color.DARK_GRAY);

			JButton colorWhite = new JButton("");
			add(colorWhite);
			colorWhite.setPreferredSize(new Dimension(40, 40));
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

	public JButton getFill() {
		return this.fill;
	}

	public JButton getOutline() {
		return this.outline;
	}

	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
	}
}
