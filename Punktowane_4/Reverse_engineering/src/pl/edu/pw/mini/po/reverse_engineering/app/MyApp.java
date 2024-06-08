package pl.edu.pw.mini.po.reverse_engineering.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import pl.edu.pw.mini.po.reverse_engineering.app.panels.MyBottomPanel;
import pl.edu.pw.mini.po.reverse_engineering.app.panels.MyFrame;
import pl.edu.pw.mini.po.reverse_engineering.app.panels.MyGraphicPanel;

public class MyApp {

	private JFrame frame;
	
	public MyApp() {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		frame.setTitle("Martyna Sadowska - moja pierwsza ramka oceniana!");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		MyGraphicPanel graphicPanel = getGraphicPanel();
		mainPanel.add(graphicPanel);
		mainPanel.add(getBottomPanel(graphicPanel));
		
		frame.add(mainPanel);
		frame.setJMenuBar(getMenuPanel(graphicPanel));
		
		frame.pack();
		
	}
	
	private MyGraphicPanel getGraphicPanel() {
		MyGraphicPanel graphicPanel = new MyGraphicPanel();
		graphicPanel.setPreferredSize(new Dimension(500, 500));
		return graphicPanel;
	}
	
	private MyBottomPanel getBottomPanel(MyGraphicPanel graphicPanel) {
		MyBottomPanel bottomPanel = new MyBottomPanel(graphicPanel);
		return bottomPanel;
	}
	
	private JMenuBar getMenuPanel(MyGraphicPanel graphicPanel) {
		JMenuBar menuPanel = new JMenuBar();
		
		JMenu options = new JMenu("Options");
		JMenuItem firstOption = new JMenuItem("Release");
		firstOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (graphicPanel.getLock()) {
					graphicPanel.getLock().notifyAll();
				}
			}
		});
		
		options.add(firstOption);
		menuPanel.add(options);
		
		return menuPanel;
	}

}
