package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;

public class InputHandler implements ActionListener, MouseListener, MouseMotionListener {
	private DrawPanel dp;
	private Mode mode;
	// private Color fill, outline;

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
		case "resize":
			this.mode = Mode.RESIZE;
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
		// case "recolor":
		// this.mode = Mode.RECOLOR;
		// break;
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
		// case RESIZE:
		// if (dp.getShapesList().size() > 0) {
		// boolean shapeFound = false;
		// int i = dp.getShapesList().size() - 1;
		// while (!shapeFound && i >= 0) {
		// if (dp.getShapesList().get(i).contains(m.getX(), m.getY())) {
		// Drawable shape = dp.getShapesList().get(i);
		// double[] coordinates = shape.getCoordinates();
		// double x1 = coordinates[0];
		// double y1 = coordinates[1];
		// double x2 = m.getX();
		// double y2 = m.getY();
		// shape.setCoordinates(x1, y1, x2, y2);
		// shapeFound = true;
		// }
		// i--;
		// }
		// }
		// break;
		case DELETE:
			dp.deleteShape(m.getX(), m.getY());
			break;
		// case RECOLOR:
		// dp.changeShapeColor(m.getX(), m.getY());
		// break;
		default:
			dp.changeShapeColor(m.getX(), m.getY());
			break;
		// case FILL:
		// dp.changeFill(m.getX(), m.getY());
		// // dp.getbpList().get(0).changeFillColor(this.fill);
		// // dp.changeFill(m.getX(), m.getY(), fill, outline);
		// break;
		// case OUTLINE:
		// dp.changeOutline(m.getX(), m.getY());
		// // dp.getbpList().get(0).changeOutlineColor(this.outline);
		// // dp.changeOutline(m.getX(), m.getY(), fill, outline);
		// break;
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
			if (this.mode == Mode.RESIZE) {
				if (dp.getShapesList().size() > 0) {
					boolean shapeFound = false;
					int i = dp.getShapesList().size() - 1;
					while (!shapeFound && i >= 0) {
						shapeFound = true;
						if (dp.getShapesList().get(i).contains(m.getX(), m.getY())) {
							Drawable shape = dp.getShapesList().get(i);
							double[] coordinates = shape.getCoordinates();
							double x1 = coordinates[0];
							double y1 = coordinates[1];
							double x2 = m.getX();
							double y2 = m.getY();
							shape.setCoordinates(x1, y1, x2, y2);
						}
						i--;
					}
				}
			} else {
				Drawable shape = dp.getShapesList().get(dp.getShapesList().size() - 1);
				double[] coordinates = shape.getCoordinates();
				double x1 = coordinates[0];
				double y1 = coordinates[1];
				double x2 = m.getX();
				double y2 = m.getY();
				shape.setCoordinates(x1, y1, x2, y2);
			}
		}
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
	}
}
