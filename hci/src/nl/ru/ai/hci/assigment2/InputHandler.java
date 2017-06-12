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
			try {
				BufferedImage outlineRed = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineRed.png"));
				BufferedImage fillRed = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillRed.png"));
				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(190, 22, 34), fillRed);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(190, 22, 34), outlineRed);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorMagenta":
			try {
				BufferedImage outlineMagenta = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineMagenta.png"));
				BufferedImage fillMagenta = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillMagenta.png"));
				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(102, 36, 131), fillMagenta);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(102, 36, 131), outlineMagenta);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorPink":
			try {
				BufferedImage outlinePink = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlinePink.png"));
				BufferedImage fillPink = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillPink.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(231, 29, 115), fillPink);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(231, 29, 115), outlinePink);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorOrange":
			try {
				BufferedImage outlineOrange = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineOrange.png"));
				BufferedImage fillOrange = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillOrange.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(233, 78, 27), fillOrange);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(233, 78, 27), outlineOrange);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorYellow":
			try {
				BufferedImage outlineYellow = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineYellow.png"));
				BufferedImage fillYellow = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillYellow.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(252, 234, 16), fillYellow);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(252, 234, 16), outlineYellow);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorGreen":
			try {
				BufferedImage outlineGreen = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineGreen.png"));
				BufferedImage fillGreen = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillGreen.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(0, 102, 51), fillGreen);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(0, 102, 51), outlineGreen);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorBlue":
			try {
				BufferedImage outlineBlue = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineBlue.png"));
				BufferedImage fillBlue = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillBlue.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(45, 46, 131), fillBlue);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(45, 46, 131), outlineBlue);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorBlack":
			try {
				BufferedImage outlineBlack = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineBlack.png"));
				BufferedImage fillBlack = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillBlack.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(29, 29, 27), fillBlack);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(29, 29, 27), outlineBlack);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorGray":
			try {
				BufferedImage outlineGray = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineGray.png"));
				BufferedImage fillGray = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillGray.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(157, 157, 156), fillGray);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(157, 157, 156), outlineGray);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case "colorWhite":
			try {
				BufferedImage outlineWhite = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/outlineWhite.png"));
				BufferedImage fillWhite = ImageIO
						.read(new File("C:/Users/josvr/Documents/GitHub/hci/hci/src/fillWhite.png"));

				if (this.mode == Mode.FILL) {
					dp.getbpList().get(1).changeFillColor(new Color(255, 255, 255), fillWhite);
				} else if (this.mode == Mode.OUTLINE) {
					dp.getbpList().get(1).changeOutlineColor(new Color(255, 255, 255), outlineWhite);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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
		Color fillColor = dp.getbpList().get(1).getFill().getBackground();
		Color outlineColor = dp.getbpList().get(1).getOutline().getBackground();
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
				if (this.layer > -1) {
					dp.getShapesList().add(dp.getShapesList().get(this.layer));
					dp.getShapesList().remove(this.layer);
					this.layer = dp.getShapesList().size() - 1;
					Drawable shape = dp.getShapesList().get(this.layer);
					this.resizeDirection = shape.borderContains(m.getX(), m.getY());
					if (!resizeDirection.equals(Directions.NA) && !(this.mode == Mode.TEXT)) {
						this.resize = true;
					}
				}
			}
			break;
		default:
			dp.changeShapeColor(m.getX(), m.getY());
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
						changeCoordinates(m, shape, this.resizeDirection);
					} else {
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