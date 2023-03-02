package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
//import java.util.Random;
import java.util.Objects;

import entities.Ball;
import entities.Entity;
import entities.RectangleClass;
import entities.Triangle;
import utilz.LoadSave;



public class Simulation implements Runnable{
	
	
	private SimPanel simPanel;
	private Thread simThread;
	private final int FPS_SET = 60;
	private final int UPS_SET = 60;

	public static final float WINSCALE = 0.8F;
	public static final int SIM_WIDTH = (int) (1920 * WINSCALE);
	public static final int SIM_HEIGHT = (int) (1080 * WINSCALE);
	
	public static final float GRAVITY = 1;
	private Entity[] entities;
	private Entity[] staticObjects;
	
	private RectangleClass marker;
	

	public Simulation() {
		
		initClasses();
		simPanel = new SimPanel(this);
		new SimWindow(simPanel);
		simPanel.requestFocus();		
		startGameLoop();
	}
	
	
	// Initialize
		
	private void initClasses() {
													//float x, float y, float width, float height, (float drag, float bounce)
//		RectangleClass plane = new RectangleClass(  	1920/2,      200,        700,        10);
		RectangleClass floor = new RectangleClass(  	1920/2,      900,        1900,        100);
		
		
		Ball ball = new Ball(							500,      100,        30,          30,          500,          70);
		Ball bigBall = new Ball(						1000,      100,        60,          60,          500,           50);
		
		marker = new RectangleClass( bigBall.getAllCords()[2][0], bigBall.getAllCords()[2][1],      10,    10);
	
//		Triangle triangle = new Triangle(				400,      700,       200,         200,          10,            20);
//		RectangleClass rectangle = new RectangleClass(1920/2,    1080/2,     100,         100,          10,            70);
		
		staticObjects = new Entity[1];
		staticObjects[0] = floor;
//		staticObjects[1] = plane;
		
		entities = new Entity[2];
		entities[0] = ball;
		entities[1] = bigBall;
//		entities[2] = triangle;
//		entities[3] = rectangle;
	}
	
	

	

	private void startGameLoop() {
		
		simThread = new Thread(this);
		simThread.start();
	}
	
	
	// Stuff for the loop
	
	public void update() {
		
		for (Entity obj : entities) {
			obj.checkCollision(staticObjects);
			obj.update(GRAVITY);
//			obj.checkCollision(entities);	
		}
		marker.setX(entities[0].getAllCords()[3][0]);
		marker.setY(entities[0].getAllCords()[3][1]);
	}
	
	public void render(Graphics g) {
		
		marker.draw(g, WINSCALE);
		
		for (Entity obj : entities) 
			obj.draw(g, WINSCALE);
		
		for (Entity obj : staticObjects)
			obj.draw(g, WINSCALE);
		
	}
	

	
	
	// Start the loop
	
	@Override
	public void run() {
		new RunCode(this);
		
	}
	
	
	
	// All getters
	
	public SimPanel getPanel() {
		return simPanel;
	}
	
	public int getFPS() {
		return FPS_SET;
	}
	
	public int getUPS() {
		return UPS_SET;
	}
	
	public Entity getEntities(int index) {
		return entities[index];
	}
	

	
	
	
	
	// Not used yet
	
//	public int getRandomNumber(int min, int max) {
//	    return (int) ((Math.random() * (max - min)) + min);
//	}
	

}


