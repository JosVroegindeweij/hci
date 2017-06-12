package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private ArrayList<Drawable> shapesList = new ArrayList<Drawable>();
	private ArrayList<Drawable> resizeShapesList = new ArrayList<Drawable>();
	private ArrayList<ButtonPanel> bpList = new ArrayList<ButtonPanel>();
	private int lineWidth;
	private int fontSize = 20;

	/**
	 * Creates a new DrawPanel
	 */
	public DrawPanel() {

		super();
	}

	/**
	 * adds a rectangle to the shapeslist
	 * 
	 * @param x1
	 *            = The x-coordinate of your first click
	 * @param y1
	 *            = the y-coordinate of your first click
	 * @param fill
	 *            = the color of the rectangle fill
	 * @param outline
	 *            = the color of the rectangle outline
	 */
	public void addRectangle(int x1, int y1, Color fill, Color outline) {
		int x2 = x1;
		int y2 = y1;
		this.shapesList.add(new MyRectangle(x1, y1, x2, y2, fill, outline, this.lineWidth));
	}

	/**
	 * adds a ellipse to the shapeslist
	 * 
	 * @param x1
	 *            = The x-coordinate of your first click
	 * @param y1
	 *            = the y-coordinate of your first click
	 * @param fill
	 *            = the color of the fill of the ellipse
	 * @param outline
	 *            = the color of the outline of the ellipse
	 */
	public void addEllipse(int x1, int y1, Color fill, Color outline) {
		int x2 = x1;
		int y2 = y1;
		this.shapesList.add(new MyEllipse(x1, y1, x2, y2, fill, outline, this.lineWidth));
	}

	/**
	 * adds a line to the shapeslist
	 * 
	 * @param x1
	 *            = The x-coordinate of your first click
	 * @param y1
	 *            = the y-coordinate of your first click
	 * @param c
	 *            = the color of the line
	 */
	public void addLine(int x1, int y1, Color fill) {
		int x2 = x1;
		int y2 = y1;
		this.shapesList.add(new MyLine(x1, y1, x2, y2, fill, this.lineWidth));
	}

	public void addImage(BufferedImage img, int x1, int y1) {
		int x2 = x1;
		int y2 = y1;
		this.shapesList.add(new MyImage(img, x1, y1, x2, y2));
	}

	public void addText(String text, int x1, int y2, Color fill) {
		this.shapesList.add(new MyText(text, x1, y2, fill, this.fontSize));
	}

	public void resizeShape(int xClick, int yClick) {

	}

	/**
	 * delete shape(s) that contain the coordinates where you clicked
	 * 
	 * @param xClick
	 *            = x-coordinate of click
	 * @param yClick
	 *            = y-coordinate of click
	 */
	public void deleteShape(int xClick, int yClick) {
		if (shapesList.size() > 0) {
			boolean shapeFound = false;
			int i = shapesList.size() - 1;
			while (!shapeFound && i >= 0) {
				if (shapesList.get(i).contains(xClick, yClick)) {
					shapesList.remove(shapesList.get(i));
					shapeFound = true;
				}
				i--;
			}
		}
	}

	/**
	 * Changes color of the fill of a shape
	 * 
	 * @param xClick
	 *            = x-coordinate of click
	 * @param yClick
	 *            = y-coordinate of click
	 * @param fill
	 *            = color of the fill
	 * @param outline
	 *            = color of the outline
	 */
	public void changeShapeColor(int xClick, int yClick) {
		Color fill = bpList.get(1).getFill().getBackground();
		Color outline = bpList.get(1).getOutline().getBackground();
		if (shapesList.size() > 0) {
			boolean shapeFound = false;
			int i = shapesList.size() - 1;
			while (!shapeFound && i >= 0) {
				if (shapesList.get(i).contains(xClick, yClick)) {
					double[] coordinates = shapesList.get(i).getCoordinates();
					double x1 = coordinates[0];
					double y1 = coordinates[1];
					double x2 = coordinates[2];
					double y2 = coordinates[3];
					if (shapesList.get(i).shape() == "Ellipse")
						shapesList.add(new MyEllipse(x1, y1, x2, y2, fill, outline, this.lineWidth));
					if (shapesList.get(i).shape() == "Rectangle")
						shapesList.add(new MyRectangle(x1, y1, x2, y2, fill, outline, this.lineWidth));
					if (shapesList.get(i).shape() == "Line")
						shapesList.add(new MyLine(x1, y1, x2, y2, fill, this.lineWidth));
					if (shapesList.get(i).shape() == "Text")
						shapesList.add(
								new MyText(shapesList.get(i).getText(), x1, y1, fill, shapesList.get(i).getFontSize()));
					shapesList.remove(shapesList.get(i));
					shapeFound = true;
				}
				i--;
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		MyRectangle canvas = new MyRectangle(0, 0, 30000, 30000, new Color(255, 255, 255), new Color(27, 27, 26), 1);
		canvas.draw(g2d);
		for (Drawable s : shapesList)
			s.draw(g2d);
		repaint();
	}

	public ArrayList<Drawable> getShapesList() {
		return this.shapesList;
	}

	public ArrayList<Drawable> getResizeShapesList() {
		return this.resizeShapesList;
	}

	public void addButtonPanel(ArrayList<ButtonPanel> bpList) {
		this.bpList = bpList;
	}

	public ArrayList<ButtonPanel> getbpList() {
		return this.bpList;
	}

	public void changeLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public void changefontSize(int fontSize) {
		this.fontSize = fontSize;
	}

}
