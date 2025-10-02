package pl.edu.pw.mini.po.szprej.graphics.spray;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import pl.edu.pw.mini.po.szprej.graphics.MyGraphics;

public class Spray extends MyGraphics {

	LinkedList<Points> points = new LinkedList<Points>();
	private static Random random = new Random();
	
	public Spray(int x, int y) {
		super(x, y);
		this.setRay(random.nextInt(31)+30);
		
		int number = random.nextInt(400)+100;
		for (int i=0; i<number; i++) {
			double a = random.nextDouble(this.getRay());
			double alpha = random.nextDouble(2*Math.PI);
			int xPoint = (int) Math.round(a * Math.cos(alpha)) + x;
			int yPoint = (int) Math.round(a * Math.sin(alpha)) + y;
			points.add(new Points(xPoint, yPoint));
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		for (Points point : points) {
			g.drawOval(point.getX(), point.getY(), 1, 1);
		}
	}

}
