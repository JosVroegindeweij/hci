package nl.ru.ai.hci.assigment2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class BoxCellRenderer extends JButton implements ListCellRenderer {
	public BoxCellRenderer() {
		setOpaque(true);

	}

	boolean b = false;

	@Override
	public void setBackground(Color bg) {
		if (!b) {
			return;
		}

		super.setBackground(bg);
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		b = true;
		setText(value.toString());
		switch (index) {
		case 0:
			setBackground(Color.black);
			break;
		case 1:
			setBackground(Color.red);
			break;
		case 2:
			setBackground(Color.blue);
			break;
		case 3:
			setBackground(Color.yellow);
			break;
		case 4:
			setBackground(Color.green);
			break;
		case 5:
			setBackground(Color.gray);
			break;
		case 6:
			setBackground(Color.magenta);
			break;
		case 7:
			setBackground(Color.pink);
			break;
		case 8:
			setBackground(Color.orange);
			break;
		case 9:
			setBackground(Color.white);
			break;
		}
		b = false;
		return this;
	}
}