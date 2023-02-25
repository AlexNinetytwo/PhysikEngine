package main;
import static main.Simulation.SIM_HEIGHT;
import static main.Simulation.SIM_WIDTH;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import inputs.KeyboardInputs;



public class SimPanel extends JPanel{

	private Simulation simulation;

	public SimPanel(Simulation simulation) {
		this.simulation = simulation;
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
//		this.setBackground(Color.black);
	}
	

	

	private void setPanelSize() {
		Dimension size = new Dimension(SIM_WIDTH, SIM_HEIGHT);
		setPreferredSize(size);
//		System.out.println("size :" + SIM_WIDTH + " : " + SIM_HEIGHT);
		
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		simulation.render(g);	
	}
	
	
	
	public Simulation getSim() {
		return simulation;
	}
}
