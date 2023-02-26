package entities;

import java.awt.Graphics;

public class Triangle extends Entity{
	
	private float x2,xMid,y2;

	public Triangle(float x, float y, int width, int height, float drag, float bounce) {
		super(x, y, width, height, drag, bounce);
		
	}

	@Override
	public void draw(Graphics g, float scale) {
		int x = (int)((this.x - this.originX) * scale);
		int y = (int)((this.y + this.originY) * scale);
		
		int x2 = (int)((this.x2 - this.originX) * scale);
		int xMid = (int)((this.xMid - this.originX) * scale);
		int y2 = (int)((this.y2 + this.originY) * scale);
		g.drawPolygon(new int[] {x, xMid, x2}, new int[] {y, y2, y}, 3);
	}


	@Override
	protected void polyCords() {
		this.x2 = this.x + this.width;
		this.xMid = this.x + this.width/2;
		this.y2 = this.y - this.height;
		
	}
}
