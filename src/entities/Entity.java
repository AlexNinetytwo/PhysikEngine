package entities;

import java.awt.Graphics;
import java.util.Vector;

import utilz.Vec2;

public abstract class Entity {

	protected float x, y, drag, bounce;
	protected int width, height, originX, originY;
	protected float fallTime = 0;
	protected double[] kineticEnergy = {0, 0};
	protected double gravityForce;

	
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
		System.out.println(String.format("x: %f, y: %f", kineticEnergy[0], kineticEnergy[1]));
	}
		
	
	public void update(float gravity) {
		
		gravityForce = gravity;
		polyCords();
		collision();
		multiplayForces();
	}
	
	protected abstract void polyCords();
	
	
	private void multiplayForces() {
		kineticEnergy[0] -= (kineticEnergy[0]/this.drag);
		kineticEnergy[1] += gravityForce;
		this.x += kineticEnergy[0];
		this.y += kineticEnergy[1];
	}

		
	private void collision() {
		if (this.y >= 800) {
			this.y = 800;
			bounceUp();
		}			
	}
	
	private void bounceUp() {
		
		kineticEnergy[1] = kineticEnergy[1] / 100 * this.bounce;
		kineticEnergy[1] = -kineticEnergy[1];
	}
	
	
	public void jump() {
		if (this.y >= 800) {
			this.y = 799;
			kineticEnergy[0] = 2;
			kineticEnergy[1] = -30;
		}
	}
	
	public abstract void draw(Graphics g, float scale);
	
		
}
