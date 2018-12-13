package rep1;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main{

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		GoL gol = new GoL();
		GraphicsPanel graphics = new GraphicsPanel(gol);
		ControlPanel ctrl = new ControlPanel(gol,graphics);

		frame.setTitle("Game of Life");
		frame.setSize(406,830);
		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2,1));

		frame.add(graphics);
		frame.add(ctrl);

		frame.setVisible(true);
	}

}
