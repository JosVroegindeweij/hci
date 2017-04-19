package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputHandler implements ActionListener, MouseListener, MouseMotionListener {
	private DrawPanel dp;
	private Mode mode;
	private Color fill;
	private Color outline = Color.BLACK;

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
		case "del":
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

	/**
	 * Perform an action based on a MouseEvent
	 * 
	 * @param m
	 *            = a MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent m) {
		System.out.println("MousePressed");
		switch (this.mode) {
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
			dp.changeOutline(m.getX(), m.getY(), fill, outline);
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
			Drawable shape = dp.getShapesList().get(dp.getShapesList().size() - 1);
			double[] coordinates = shape.getCoordinates();
			double x1 = coordinates[0];
			double y1 = coordinates[1];
			double x2 = m.getX();
			double y2 = m.getY();
			shape.setCoordinates(x1, y1, x2, y2);
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
