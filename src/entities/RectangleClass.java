package entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class RectangleClass extends Entity{
	
	

	public RectangleClass(float x, float y, int width, int height, float drag, float bounce) {
		super(x, y, width, height, drag, bounce);
		
	}

	@Override
	protected void polyCords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, float scale) {
		Graphics2D g2d = (Graphics2D)g;
//		g2d.setPaint(this.color);
		int x = (int) ((this.x - this.originX) * scale);
		int y = (int) ((this.y - this.originY) * scale);
		int w = (int) (this.width * scale);
		int h = (int) (this.height * scale);
		
		
		
		g2d.drawRect(x, y, w, h);
		
	}
	
	public void rotate(int degrees) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.rotate(Math.toRadians(degrees),this.x/2,this.y/2);
	}

}
