package nl.ru.ai.hci.assigment2;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Window extends JFrame
{
	public Window()
	{
		// �super � calls a function inherited from the parent class ( JFrame )
		super();
		// sets name of window
		setTitle("Callbacks");
		// sets to window to FullScreen
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Make sure the window appears in the middle of your screen
		setLocationRelativeTo(null);
		// Determines what should happen when the frame is closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Chooses a certain layout type for the elements in this frame
		getContentPane().setLayout(new BorderLayout());
		// Make a new DrawPanel, an InputHandler, and 2 ButtonPanels
		DrawPanel dp = new DrawPanel();
		InputHandler input = new InputHandler(dp);
		// ButtonPanel 1 is for shapes, ButtonPanel 2 for COLOR
		ButtonPanel bp = new ButtonPanel(dp, input, ButtonPanelType.SHAPES);
		ButtonPanel bp2 = new ButtonPanel(dp, input, ButtonPanelType.COLOR);
		ArrayList<ButtonPanel> bpList = new ArrayList<ButtonPanel>();
		bpList.add(bp); bpList.add(bp2);
		dp.addButtonPanel(bpList);
		// Places the DrawPanel in the correct place of the window
		getContentPane().add(dp, BorderLayout.CENTER);
		// Places the ButtonPanel in the correct place of the window
		getContentPane().add(bp, BorderLayout.NORTH);
		getContentPane().add(bp2, BorderLayout.SOUTH);
		// Set the window to visible ! Yup ... This is necessary
		setVisible(true);
	}


}