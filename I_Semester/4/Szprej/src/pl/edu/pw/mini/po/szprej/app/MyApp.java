package pl.edu.pw.mini.po.szprej.app;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.edu.pw.mini.po.szprej.app.panels.MyBottomPanel;
import pl.edu.pw.mini.po.szprej.app.panels.MyFrame;
import pl.edu.pw.mini.po.szprej.app.panels.MyGraphicPanel;
import pl.edu.pw.mini.po.szprej.app.panels.MyMenuPanel;

public class MyApp {

	private JFrame frame;

	public MyApp() {
		
		this.frame = new MyFrame();
		frame.setVisible(true);
		frame.setTitle("Ramka jak ramka!");
		frame.setPreferredSize(new Dimension(700, 700));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		MyGraphicPanel graphicPanel = new MyGraphicPanel();
		mainPanel.add(graphicPanel);
		
		MyBottomPanel bottomPanel = new MyBottomPanel(graphicPanel);
		mainPanel.add(bottomPanel);
		
		frame.add(mainPanel);
		frame.setJMenuBar(new MyMenuPanel());
		
		frame.pack();
		
		
	}
	
}
