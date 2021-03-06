package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
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
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/select.png"));
				JButton select = new JButton(new ImageIcon(buttonIcon));
				select.setPreferredSize(new Dimension(100, 100));
				add(select);
				select.addActionListener(input);
				select.setActionCommand("select");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/del.png"));
				JButton del = new JButton();
				del.setIcon(new ImageIcon(buttonIcon));
				del.setPreferredSize(new Dimension(100, 100));
				add(del);
				del.addActionListener(input);
				del.setActionCommand("del");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/rec.png"));
				JButton rec = new JButton();
				rec.setIcon(new ImageIcon(buttonIcon));
				rec.setPreferredSize(new Dimension(100, 100));
				add(rec);
				rec.addActionListener(input);
				rec.setActionCommand("rec");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/ell.png"));
				JButton ell = new JButton();
				ell.setIcon(new ImageIcon(buttonIcon));
				ell.setPreferredSize(new Dimension(100, 100));
				add(ell);
				ell.addActionListener(input);
				ell.setActionCommand("ell");
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/line.png"));
				JButton line = new JButton();
				line.setIcon(new ImageIcon(buttonIcon));
				line.setPreferredSize(new Dimension(100, 100));
				add(line);
				line.addActionListener(input);
				line.setActionCommand("line");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String[] lineWidths = { "Line width", "2", "4", "6", "8", "10", "12" };
			JComboBox lineWidth = new JComboBox(lineWidths);
			add(lineWidth);
			lineWidth.setPreferredSize(new Dimension(200, 100));
			lineWidth.setSelectedIndex(0);
			lineWidth.setEditable(true);
			lineWidth.setVisible(true);
			lineWidth.addActionListener(input);
			lineWidth.setActionCommand("lineWidth");
			
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/image.png"));
				JButton image = new JButton();
				image.setIcon(new ImageIcon(buttonIcon));
				image.setPreferredSize(new Dimension(100, 100));
				add(image);
				image.addActionListener(input);
				image.setActionCommand("image");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/text.png"));
				JButton text = new JButton();
				text.setIcon(new ImageIcon(buttonIcon));
				text.setPreferredSize(new Dimension(100, 100));
				add(text);
				text.addActionListener(input);
				text.setActionCommand("text");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String[] fontSizes = { "Font size", "12", "14", "20", "24", "48", "72" };
			JComboBox fontSize = new JComboBox(fontSizes);
			add(fontSize);
			fontSize.setPreferredSize(new Dimension(200, 100));
			fontSize.setSelectedIndex(0);
			fontSize.setEditable(true);
			fontSize.setVisible(true);
			fontSize.addActionListener(input);
			fontSize.setActionCommand("fontSize");

			break;

		case COLOR:
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineBlack.png"));
				JButton outline = new JButton();
				outline.setBackground(new Color(29,29,27));
				outline.setIcon(new ImageIcon(buttonIcon));
				add(outline);
				outline.setPreferredSize(new Dimension(100, 100));
				outline.addActionListener(input);
				outline.setActionCommand("outline");
				this.outline = outline;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			try {
				BufferedImage buttonIcon = ImageIO.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillBlack.png"));
				JButton fill = new JButton();
				fill.setIcon(new ImageIcon(buttonIcon));
				add(fill);
				fill.setBackground(new Color(26,26,27));
				fill.setPreferredSize(new Dimension(100, 100));
				fill.addActionListener(input);
				fill.setActionCommand("fill");
				this.fill = fill;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			JButton colorRed = new JButton("");
			add(colorRed);
			colorRed.setPreferredSize(new Dimension(100, 100));
			colorRed.addActionListener(input);
			colorRed.setActionCommand("colorRed");
			colorRed.setBackground(new Color(190, 22, 34));

			JButton colorMagenta = new JButton("");
			add(colorMagenta);
			colorMagenta.setPreferredSize(new Dimension(100,100));
			colorMagenta.addActionListener(input);
			colorMagenta.setActionCommand("colorMagenta");
			colorMagenta.setBackground(new Color(102, 36, 131));

			JButton colorPink = new JButton("");
			add(colorPink);
			colorPink.setPreferredSize(new Dimension(100, 100));
			colorPink.addActionListener(input);
			colorPink.setActionCommand("colorPink");
			colorPink.setBackground(new Color(231, 29, 115));

			JButton colorOrange = new JButton("");
			add(colorOrange);
			colorOrange.setPreferredSize(new Dimension(100, 100));
			colorOrange.addActionListener(input);
			colorOrange.setActionCommand("colorOrange");
			colorOrange.setBackground(new Color(233, 78, 27));

			JButton colorYellow = new JButton("");
			add(colorYellow);
			colorYellow.setPreferredSize(new Dimension(100, 100));
			colorYellow.addActionListener(input);
			colorYellow.setActionCommand("colorYellow");
			colorYellow.setBackground(new Color(252, 234, 16));

			JButton colorGreen = new JButton("");
			add(colorGreen);
			colorGreen.setPreferredSize(new Dimension(100, 100));
			colorGreen.addActionListener(input);
			colorGreen.setActionCommand("colorGreen");
			colorGreen.setBackground(new Color(0, 102, 51));

			JButton colorBlue = new JButton("");
			add(colorBlue);
			colorBlue.setPreferredSize(new Dimension(100, 100));
			colorBlue.addActionListener(input);
			colorBlue.setActionCommand("colorBlue");
			colorBlue.setBackground(new Color(45, 46, 131));

			JButton colorBlack = new JButton("");
			add(colorBlack);
			colorBlack.setPreferredSize(new Dimension(100, 100));
			colorBlack.addActionListener(input);
			colorBlack.setActionCommand("colorBlack");
			colorBlack.setBackground(new Color(29, 29, 27));

			JButton colorGray = new JButton("");
			add(colorGray);
			colorGray.setPreferredSize(new Dimension(100, 100));
			colorGray.addActionListener(input);
			colorGray.setActionCommand("colorGray");
			colorGray.setBackground(new Color(157, 157, 156));

			JButton colorWhite = new JButton("");
			add(colorWhite);
			colorWhite.setPreferredSize(new Dimension(100, 100));
			colorWhite.addActionListener(input);
			colorWhite.setActionCommand("colorWhite");
			colorWhite.setBackground(new Color(255, 255, 255));
			break;
		}
	}

	public void changeFillColor(Color fillColor, BufferedImage fill) {
		this.fill.setBackground(fillColor);
		this.fill.setIcon(new ImageIcon(fill));
	}

	public void changeOutlineColor(Color outlineColor, BufferedImage outline) {
		this.outline.setBackground(outlineColor);
		this.outline.setIcon(new ImageIcon(outline));
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