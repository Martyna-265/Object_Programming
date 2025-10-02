package lab_14pl.edu.pw.mini.po.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MyGraphicPanel extends JPanel{

	private int x, y;
	private List<MyPair> dots = new ArrayList<>();
	private String text = "";
	
	public MyGraphicPanel() {
		/*
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(300);
						updateXY();
						repaint();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
		myThread.start();
		*/
		
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				updateXY(e.getX(), e.getY());
				
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
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				updateXYDots(e.getX(), e.getY());
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.white);
		g.drawLine(50, 50, 100, 100);
		g.setColor(Color.black);
		g.drawOval(x, y, 40, 40);
		
		g.drawString(text, x+20, y+20);
		
		System.out.println(" >>> " + x + " " + y);
		drawDots(g);
		
	}
	
	public void updateXY(int x, int y) {
//		x++;
//		y++;
		this.x = x;
		this.y = y;
		repaint();
	}
	public void updateXYDots(int x, int y) {
//		x++;
//		y++;
		dots.add(new MyPair(x, y));
		repaint();
	}
	
	public void drawDots(Graphics g) {
		for (MyPair myPair : dots) {
			g.drawOval(myPair.getX(), myPair.getY(), 1, 2);
		}
	}
	
	public void setText(String text) {
		this.text = text;
	}

}
