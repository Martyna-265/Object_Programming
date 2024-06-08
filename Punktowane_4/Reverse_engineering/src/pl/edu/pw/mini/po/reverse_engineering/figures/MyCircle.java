package pl.edu.pw.mini.po.reverse_engineering.figures;

import pl.edu.pw.mini.po.reverse_engineering.app.panels.MyGraphicPanel;

public class MyCircle extends MyFigure {

	private static int multipleRay = 100;

	public MyCircle(int x, int y, int side, MyGraphicPanel panel, Object lock) {
		super(x, y, side, panel, lock);
	}
	
	public void updateSide() throws InterruptedException {
		int side = this.getSide() + 1;
		this.setSide(side);
		if (side % multipleRay == 0) {
			synchronized (this.getLock()) {
				this.getLock().wait();
			}
		}
	}
	
}
