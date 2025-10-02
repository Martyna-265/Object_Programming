package pl.edu.pw.mini.po.szprej.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Square extends MyGraphics {

	private static Random random = new Random();
	
	public Square(int x, int y) {
		super(x, y);
		this.setRay(random.nextInt(11)+10);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.getX(), this.getY(), this.getRay(), this.getRay());
	}

}
