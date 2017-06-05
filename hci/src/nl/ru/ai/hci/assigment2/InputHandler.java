package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InputHandler implements ActionListener, MouseListener, MouseMotionListener {
	private DrawPanel dp;
	private Mode mode = Mode.SELECT;
	private int layer = -1;
	private double xDiff = -1;
	private double yDiff = -1;
	private boolean resize;
	private Directions resizeDirection;
	private BufferedImage img;
	JLabel image;
	private String text;

	/**
	 * Makes a new InputHandler
	 * 
	 * @param draw
	 *            = a DrawPanel
	 */
	public InputHandler(DrawPanel draw) {
		dp = draw;
		// Adds itself as MouseListener to dp
		dp.addMouseListener(this);
		// Adds itself as MouseMotionListener to dp
		dp.addMouseMotionListener(this);
	}

	/**
	 * Perform an action based on an ActionEvent (specified in the
	 * ".addActionListener()")
	 * 
	 * @param e
	 *            = an ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "rec":
			this.mode = Mode.RECTANGLE;
			break;
		case "ell":
			this.mode = Mode.ELLIPSE;
			break;
		case "line":
			this.mode = Mode.LINE;
			break;
		case "select":
			this.mode = Mode.SELECT;
			break;
		case "del":
			this.mode = Mode.DELETE;
			break;
		case "fill":
			this.mode = Mode.FILL;
			break;
		case "outline":
			this.mode = Mode.OUTLINE;
			break;
		case "text":
			this.mode = Mode.TEXT;
			System.out.println("textttt");
			this.text = JOptionPane.showInputDialog("What text do you want to display?");
			break;
		case "image":
			this.mode = Mode.IMAGE;
			JFileChooser fc = new JFileChooser();
			int result = fc.showOpenDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					this.img = ImageIO.read(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			break;
			
			
			
		case "colorRed":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.RED);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.RED);
			break;
		case "colorMagenta":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.MAGENTA);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.MAGENTA);
			break;
		case "colorPink":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.PINK);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.PINK);
			break;
		case "colorOrange":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.ORANGE);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.ORANGE);
			break;
		case "colorYellow":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.YELLOW);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.YELLOW);
			break;
		case "colorGreen":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.GREEN);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.GREEN);
			break;
		case "colorBlue":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.BLUE);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.BLUE);
			break;
		case "colorBlack":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.BLACK);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.BLACK);
			break;
		case "colorGray":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.GRAY);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.GRAY);
			break;
		case "colorWhite":
			if (this.mode == Mode.FILL)
				dp.getbpList().get(0).changeFillColor(Color.WHITE);
			else if (this.mode == Mode.OUTLINE)
				dp.getbpList().get(0).changeOutlineColor(Color.WHITE);
			break;
		case "lineWidth":
			JComboBox lineWidth = (JComboBox) e.getSource();
			int width = 2;
			String widthString = (String) lineWidth.getSelectedItem();
			if (widthString.equals("Line width"))
				;
			else {
				try {
					width = Integer.parseInt(widthString);
				} catch (NumberFormatException f) {

				}
				dp.changeLineWidth(width);
			}
			break;
		case "fontSize":

			JComboBox fontSize = (JComboBox) e.getSource();
			int size = 20;
			String sizeString = (String) fontSize.getSelectedItem();
			if (sizeString.equals("Font size"))
				;
			else {
				try {
					size = Integer.parseInt(sizeString);
				} catch (NumberFormatException f) {

				}
				dp.changefontSize(size);
			}
			break;
		}
	}

	/**
	 * Perform an action based on a MouseEvent
	 * 
	 * @param m
	 *            = a MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent m) {
		System.out.println("x=" + m.getX() + "y=" + m.getY());
		System.out.println("MousePressed");
		Color fillColor = dp.getbpList().get(0).getFill().getBackground();
		Color outlineColor = dp.getbpList().get(0).getOutline().getBackground();
		switch (this.mode) {
		case RECTANGLE:
			dp.addRectangle(m.getX(), m.getY(), fillColor, outlineColor);
			break;
		case ELLIPSE:
			dp.addEllipse(m.getX(), m.getY(), fillColor, outlineColor);
			break;
		case LINE:
			dp.addLine(m.getX(), m.getY(), fillColor);
			break;
		case IMAGE:
			dp.addImage(img, m.getX(), m.getY());
			break;
		case TEXT:
			dp.addText(text, m.getX(), m.getY(), fillColor);
			break;
		case DELETE:
			dp.deleteShape(m.getX(), m.getY());
			break;
		case SELECT:
			this.xDiff = -1;
			this.yDiff = -1;
			this.resize = false;
			this.resizeDirection = Directions.NA;
			if (dp.getShapesList().size() > 0) {
				boolean shapeFound = false;
				int i = dp.getShapesList().size() - 1;
				if (this.layer == -1) {
					while (!shapeFound && i >= 0) {
						if (dp.getShapesList().get(i).contains(m.getX(), m.getY())) {
							shapeFound = true;
							this.layer = i;
						}
						i--;
					}
				}
			}
			if (this.layer > -1) {
				this.resizeDirection = dp.getShapesList().get(this.layer).borderContains(m.getX(), m.getY());
				if (!resizeDirection.equals(Directions.NA)&& !(this.mode==Mode.TEXT))
					this.resize = true;
				else {
					if (dp.getShapesList().get(dp.getShapesList().size()-1).equals())
				}
			}
			break;
		default:
			dp.changeShapeColor(m.getX(), m.getY());
			System.out.println("change coloorr");
			break;
		}
	}

	/**
	 * performs an action based on a MouseEvent
	 * 
	 * @param m
	 *            = a MouseEvent
	 */

	@Override
	public void mouseDragged(MouseEvent m) {
		if (this.mode != Mode.DELETE && this.mode != Mode.FILL && this.mode != Mode.OUTLINE) {
			if (this.mode == Mode.SELECT) {
				if (this.layer > -1) {
					Drawable shape = dp.getShapesList().get(this.layer);
					if (this.resize) {
						System.out.println("wtf is going on");
						changeCoordinates(m, shape, this.resizeDirection);
					} else {
						System.out.println("WERE AT THE GETCOORDINATES STATE");
						double[] coordinates = shape.getCoordinates();
						if (this.xDiff == -1 && this.yDiff == -1) {
							xDiff = m.getX() - coordinates[0];
							yDiff = m.getY() - coordinates[1];
						}
						double width = coordinates[2] - coordinates[0];
						double height = coordinates[3] - coordinates[1];
						double x1 = m.getX() - this.xDiff;
						double y1 = m.getY() - this.yDiff;
						shape.setCoordinates(x1, y1, x1 + width, y1 + height);
					}
				}
			} else if (this.mode != Mode.TEXT) {
				Drawable shape = dp.getShapesList().get(dp.getShapesList().size() - 1);
				double[] coordinates = shape.getCoordinates();
				double x1 = coordinates[0];
				double y1 = coordinates[1];
				double x2 = m.getX();
				double y2 = m.getY();
				shape.setCoordinates(x1, y1, x2, y2);
				// System.out.println("WERE AT THE GETCOORDINATES STATE2");

			}
		}
	}

	private void changeCoordinates(MouseEvent m, Drawable shape, Directions borderContains) {
		double[] coordinates = shape.getCoordinates();
		double x1 = coordinates[0];
		double y1 = coordinates[1];
		double x2 = coordinates[2];
		double y2 = coordinates[3];
		switch (borderContains) {
		case W:
			x1 = m.getX();
			y1 = m.getY();
			break;
		case E:
			x2 = m.getX();
			y2 = m.getY();
			break;
		case NW:
			x1 = m.getX();
			y1 = m.getY();
			break;
		case NE:
			y1 = m.getY();
			x2 = m.getX();
			break;
		case SE:
			x2 = m.getX();
			y2 = m.getY();
			break;
		case SW:
			x1 = m.getX();
			y2 = m.getY();
			break;
		default:
			break;

		}
		shape.setCoordinates(x1, y1, x2, y2);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.layer = -1;
	}
}