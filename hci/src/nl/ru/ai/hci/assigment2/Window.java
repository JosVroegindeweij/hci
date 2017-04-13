package nl.ru.ai.hci.assigment2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends JFrame
{
	public Window()
	{
		// ‘super ’ calls a function inherited from the parent class ( JFrame )
		super();
		setTitle("Callbacks");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Make sure the window appears in the middle of your screen
		setLocationRelativeTo(null);
		// Determines what should happen when the frame is closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Chooses a certain layout type for the elements in this frame
		getContentPane().setLayout(new BorderLayout());
		// TODO : add elements to the content pane
		DrawPanel dp = new DrawPanel();
		InputHandler input = new InputHandler(dp);
		ButtonPanel bp = new ButtonPanel(dp, input, ButtonPanelType.SHAPES);
		ButtonPanel bp2 = new ButtonPanel(dp, input, ButtonPanelType.COLOUR);
		// Places the DrawPanel in the center of the frame
		getContentPane().add(dp, BorderLayout.CENTER);
		// Places the ButtonPanel in the top of the frame
		getContentPane().add(bp, BorderLayout.NORTH);
		getContentPane().add(bp2, BorderLayout.SOUTH);
		// Set the window to visible ! Yup ... This is necessary
		setVisible(true);
	}


}
