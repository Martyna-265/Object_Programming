package pl.edu.pw.mini.po.reverse_engineering.figures;

import pl.edu.pw.mini.po.reverse_engineering.app.panels.MyGraphicPanel;

public class MySquare extends MyFigure {

	private static int multipleSide = 60;

	public MySquare(int x, int y, int side, MyGraphicPanel panel, Object lock) {
		super(x, y, side, panel, lock);
		
	}
	
	public void updateSide() throws InterruptedException {
		int side = this.getSide() + 1;
		this.setSide(side);
		if (side % multipleSide == 0) {
			synchronized (this.getLock()) {
				this.getLock().wait();
			}
		}
	}
	
}
