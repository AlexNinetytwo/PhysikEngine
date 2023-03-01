package entities;

import java.awt.Graphics;


public abstract class Entity {

	protected float x, y, x1, y1, x2, y2, oldX, oldY, drag, bounce;
	protected int width, height, originX, originY;
	protected float fallTime = 0;
	protected double[] kineticEnergy = {0, 0};
	protected double gravityForce;
	
	public static float getRandomNumber(int min, int max) {
		return (float) ((Math.random() * (max - min)) + min);
}


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
	
	// static object
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.originX = this.width / 2;
		this.originY = this.height / 2;
		polyCords();
	}
	
	public void data() {
		System.out.println(String.format("x: %f, y: %f", kineticEnergy[0], kineticEnergy[1]));
	}
		
	
	public void update(float gravity) {
		
		gravityForce = gravity;
		polyCords();
		multiplayForces();
	}
	
	protected abstract void polyCords();
	
	
	private void multiplayForces() {
		kineticEnergy[0] -= (kineticEnergy[0]/this.drag);
		kineticEnergy[1] += gravityForce;
		this.x += kineticEnergy[0];
		this.y += kineticEnergy[1];
	}

		
	public void checkCollision(Entity[] entities) {
		
		for (Entity obj : entities) {
			
//			System.out.println(this.y + "   "+ obj.y2+" "+obj.y1);
			
			if (obj == this)
				continue;
			
			if (inBetween(obj.x1, this.x, obj.x2)) {
				awareForCollision(obj);
				
			}
		}
		
		this.oldX = this.x;
		this.oldY = this.y;
	}
	
	protected void awareForCollision(Entity obj) {
		
		if (this.y + this.height/2 >= obj.y1) {
			this.y = this.oldY;
			bounceUp();
		}
	}


	private boolean inBetween(float value1, float between, float value2) {
		if (value1 < between && between < value2)
			return true;
		return false;
	}
	
	private void bounceUp() {
		
//		kineticEnergy[0] = kineticEnergy[0] / 100 * this.bounce;
//		kineticEnergy[0] = -kineticEnergy[0];
		
		kineticEnergy[1] = kineticEnergy[1] / 100 * this.bounce;
		kineticEnergy[1] = -kineticEnergy[1];
	}
	
	
	public void jump() {
		
			
			float randomY = Entity.getRandomNumber(-1, 1);
			
			kineticEnergy[0] += randomY;
			kineticEnergy[1] = -30;
		
	}
	
	public abstract void draw(Graphics g, float scale);
	
	public float[][] getAllCords() {
		
		polyCords();
		
		float[][] cords = {
				{this.x, this.y},
				{this.x1, this.y1},
				{this.x2, this.y2}
		};
		return cords;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
}


	
	
