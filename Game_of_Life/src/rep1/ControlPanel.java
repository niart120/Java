package rep1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class ControlPanel extends JPanel implements ActionListener{

	JButton reset;
	JButton stop;
	JButton start;

	JRadioButton isAve;

	GoL gl;
	GraphicsPanel gPanel;

	Timer timer;

	public ControlPanel(GoL gol, GraphicsPanel gp){

		this.gl = gol;
		this.gPanel = gp;

		timer = new Timer(100,null);
		timer.addActionListener(this);
		timer.setActionCommand("TIMER");


		reset = new JButton("RESET");
		stop = new JButton("STOP");
		start = new JButton("START");

		reset.addActionListener(this);
		stop.addActionListener(this);
		start.addActionListener(this);

		reset.setActionCommand("RESET");
		stop.setActionCommand("STOP");
		start.setActionCommand("START");

		add(reset);
		add(stop);
		add(start);
	}

	public void actionPerformed(ActionEvent e) {

		String cmd = e.getActionCommand();
		if(cmd.equals("START")){
			timer.start();
		}

		if(cmd.equals("STOP")){
			timer.stop();

		}
		if(cmd.equals("RESET")){
			timer.stop();
			gl.resetMatrix();
			gPanel.repaint();
		}
		if(cmd.equals("TIMER")){
			gl.calNewMatrix();
			gPanel.repaint();
		}
	}

}
