package com.vpr.login.ui;

import java.awt.*;
import javax.swing.*;

public class Vista extends JFrame {

	JFrame frame;
	
	public Vista() {
		frame = new JFrame();
		frame.setTitle("Mi aplicación");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600,500));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //centra la ventana
		
		
		frame.setVisible(true);
		frame.repaint();
		
		
	}
}
