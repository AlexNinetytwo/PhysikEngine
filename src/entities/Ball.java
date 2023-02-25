package entities;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball extends Entity{

	public Ball(float x, float y, int width, int height, float drag, float bounce) {
		super(x, y, width, height, drag, bounce);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
//		g2d.setPaint(this.color);
		g2d.drawOval(this.originX, this.originY, this.width, this.height);
		
	}
}
