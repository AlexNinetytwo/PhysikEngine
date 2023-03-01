package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.SimPanel;

 
public class KeyboardInputs implements KeyListener {
	
	private SimPanel simPanel;
	
	public KeyboardInputs(SimPanel simPanel) {
		this.simPanel = simPanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Space");
			simPanel.getSim().getEntities(0).jump();
			simPanel.getSim().getEntities(1).jump();
//			simPanel.getSim().getEntities(2).jump();
//			simPanel.getSim().getEntities(3).jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
			
	}	

}
