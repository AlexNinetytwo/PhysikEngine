package entities;

import java.awt.Graphics;

public abstract class Entity {

	protected float x, y, drag, bounce;
	protected int width, height, originX, originY;
	protected float fallTime = 0;
	protected boolean bouncing = false;

	
	public Entity(float x, float y, int width, int height, float drag, float bounce) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.drag = drag;
		this.bounce = bounce;
		geoToOrigin();
	}
	
	public void update(float gravity) {
		fallDown(gravity);
		collision();
		checkBouncing();
		stopBouncing();
		geoToOrigin();
	}
	
	private void geoToOrigin() {
		this.originX = (int) (this.x - this.width / 2);
		this.originY = (int) (this.y - this.height / 2);
	}
	
	private void stopBouncing() {
		if (Math.abs(fallTime) < 0.25 && this.y > 795) {
			fallTime = 0;
			this.y = 800;
		}
		
	}

	private void fallDown(float gravity) {
		this.y += gravity * fallTime;
		fallTime += 0.1;		
	}
	
	private void checkBouncing() {
		if (fallTime >= 0)
			bouncing = false;
	}
	
	private void collision() {
		if (this.y > 800 && !bouncing) {
			bounceUp();
		}
			
	}
	
	private void bounceUp() {
		fallTime = fallTime/ 102 * this.bounce;
		fallTime *= -1;
		bouncing = true;
	}
	
	public void jump() {
		if (this.y == 800)
			fallTime = -10;
	}
	
	public abstract void draw(Graphics g);
	
		
}
