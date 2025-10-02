package pl.edu.pw.mini.po.szprej.graphics;

import java.awt.Graphics;

public class MyGraphics {

	private int ray;
	private int x;
	private int y;
	
	public MyGraphics(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
	}

	protected void setRay(int ray) {
		this.ray = ray;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRay() {
		return ray;
	}
	
}
