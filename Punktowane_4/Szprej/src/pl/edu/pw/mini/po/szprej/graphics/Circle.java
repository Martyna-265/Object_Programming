package pl.edu.pw.mini.po.szprej.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Circle extends MyGraphics {

	private static Random random = new Random();
	
	public Circle(int x, int y) {
		super(x, y);
		this.setRay(random.nextInt(31)+30);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(this.getX(), this.getY(), this.getRay(), this.getRay());
	}
	
}
