package gui;

import java.awt.*;
import javax.swing.*;

abstract
public class Gui extends JPanel{


    private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public Gui() {
		

		JFrame frame = new JFrame("FrameDemo");
		Container contentPane = frame.getContentPane();
		
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		this.setSize(200,200);
	
		frame.setVisible(true);
		
	}
	
	
}
