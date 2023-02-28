package entities;

import java.awt.Graphics;
import java.util.Vector;

import utilz.Vec2;

public abstract class Entity {

	protected float x, y, drag, bounce;
	protected int width, height, originX, originY;
	protected float fallTime = 0;
	protected boolean bouncing = false;
	protected double[] energy = {0, 0};
	protected double gravityForce = 0;

	
	public Entity(float x, float y, int width, int height, float drag, float bounce) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.drag = drag;
		this.bounce = bounce;
		this.originX = this.width / 2;
		this.originY = this.height / 2;
	}
	
	public void data() {
		System.out.println(fallTime);
	}
		
	
	public void update(float gravity) {
		polyCords();
		fallDown(gravity);
		collision();
		checkBouncing();
		stopBouncing();
		multiplayForces();
	}
	
	
	private void multiplayForces() {
		energy[1] += gravityForce;
		this.x += energy[0];
		this.y += energy[1];
	}


	protected abstract void polyCords();
	
	private void stopBouncing() {
		if (Math.abs(fallTime) < 0.25 && this.y > 795) {
			fallTime = 0;
			gravityForce = 0;
		}
		
	}

	private void fallDown(float gravity) {
//		this.y += gravity * fallTime;
		gravityForce += gravity * 0.1;
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
			fallTime = -(10 - (10/100*this.drag));
	}
	
	public abstract void draw(Graphics g, float scale);
	
		
}
