package lab_14pl.edu.pw.mini.po.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyUIApp {

	public static void main(String[] args) {
		
		Color purple = new Color(129, 25, 209);
		
		MyFrame myFrame = new MyFrame();
		myFrame.setVisible(true);
		myFrame.setSize(new Dimension(800, 800));
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.getContentPane().setBackground(new Color(200, 0, 0));
		myFrame.setTitle("Hello");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel verticalTopPanel = new JPanel();
		verticalTopPanel.setLayout(new BoxLayout(verticalTopPanel, BoxLayout.X_AXIS));
		
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.yellow);
		jPanel.setPreferredSize(new Dimension(200, 200));
		verticalTopPanel.add(jPanel);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(purple);
		jPanel2.setPreferredSize(new Dimension(200, 200));
		verticalTopPanel.add(jPanel2);
		
		mainPanel.add(verticalTopPanel);
		
		MyGraphicPanel myGraphicPanel = new MyGraphicPanel();
		myGraphicPanel.setPreferredSize(new Dimension(400, 400));
		myGraphicPanel.setBackground(new Color(209, 25, 157));
		
		mainPanel.add(myGraphicPanel);
		
		MyBottomPanel myBottomPanel = new MyBottomPanel(myGraphicPanel);
		mainPanel.add(myBottomPanel);
		
		myFrame.add(mainPanel);
		
		myFrame.pack();
		
	}

}
