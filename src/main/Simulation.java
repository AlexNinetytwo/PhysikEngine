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
	private final int UPS_SET = 120;

	public static final float WINSCALE = 0.5F;
	public static final int SIM_WIDTH = (int) (1920 * WINSCALE);
	public static final int SIM_HEIGHT = (int) (1080 * WINSCALE);
	
	public static final float GRAVITY = 1;
	private Entity[] entities;
	

	public Simulation() {
		
		initClasses();
		simPanel = new SimPanel(this);
		new SimWindow(simPanel);
		simPanel.requestFocus();		
		startGameLoop();
	}
	
	
	// Initialize
		
	private void initClasses() {
													//float x, float y, float width, float height, float drag, float bounce
		Ball ball = new Ball(							500,      100,        30,          30,          1000,           70);
		Ball bigBall = new Ball(						600,      100,        60,          60,          500,           50);
		Triangle triangle = new Triangle(				400,      700,       200,         200,          10,          20);
		RectangleClass rectangle = new RectangleClass(1920/2,    1080/2,     100,         100,          10,           70); 
		entities = new Entity[4];
		entities[0] = ball;
		entities[1] = bigBall;
		entities[2] = triangle;
		entities[3] = rectangle;
	}
	
	
	private BufferedImage loadImage(String fileName) {
		
		BufferedImage img = LoadSave.GetSpriteAtlas(fileName);
		return img;
	}
	

	private void startGameLoop() {
		
		simThread = new Thread(this);
		simThread.start();
	}
	
	
	// Stuff for the loop
	
	public void update() {
		for (int i = 0; i < entities.length; i++) {
			entities[i].update(GRAVITY);
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < entities.length; i++) {
			entities[i].draw(g, WINSCALE);
		}
	}
	
	private void renderBackground(Graphics g) {
		
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


