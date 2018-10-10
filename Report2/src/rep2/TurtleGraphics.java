package rep2;

import java.awt.Color;

import javax.swing.JFrame;

public class TurtleGraphics {

	public static void main(String[] args) {
		JFrame fr = new JFrame("TurtleGraphics");
	    
	    fr.setSize(400,400);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    fr.getContentPane().setBackground(new Color(255, 255, 255));

	    TurtleGraphicsPanel panel = new TurtleGraphicsPanel();
	    panel.setOpaque(false);
	    fr.add(panel);

	    fr.setVisible(true);

	}

}
