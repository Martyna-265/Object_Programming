package pl.edu.pw.mini.po.szprej.app.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;

import pl.edu.pw.mini.po.szprej.graphics.Circle;
import pl.edu.pw.mini.po.szprej.graphics.MyGraphics;
import pl.edu.pw.mini.po.szprej.graphics.Square;
import pl.edu.pw.mini.po.szprej.graphics.spray.Spray;

public class MyGraphicPanel extends JPanel {

	LinkedList<MyGraphics> graphics;
	private static Random random = new Random();
	
	public MyGraphicPanel(){
		this.setPreferredSize(new Dimension(700, 700));
		this.setBackground(Color.white);
		this.graphics = new LinkedList<MyGraphics>();
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (random.nextBoolean()) {
						graphics.add(new Square(e.getX(), e.getY()));
					}
					else {
						graphics.add(new Circle(e.getX(), e.getY()));
					}
				}
				else if (e.getButton() == MouseEvent.BUTTON3) {
					graphics.add(new Spray(e.getX(), e.getY()));
				}
				repaint();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (MyGraphics graphic : graphics) {
			graphic.paint(g);
		}
		
	}

	public int getRays() {
		int rays = 0;
		for (MyGraphics graphic : graphics) {
			// Visitor...
			if (graphic instanceof Circle) {
				rays = rays + graphic.getRay();
			}
		}
		return rays;
	}
	
}
