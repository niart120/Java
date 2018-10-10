package rep2;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TurtleGraphicsPanel extends JPanel {
	//Turtle インスタンス
	private Turtle kame;
	
	//コンストラクタ
	TurtleGraphicsPanel(){
		kame = new Turtle(200,200);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}
}
