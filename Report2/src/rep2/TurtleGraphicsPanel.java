package rep2;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TurtleGraphicsPanel extends JPanel {
	//Turtle インスタンス
	private Turtle kame;
	
	//Turtle保持用のArrayList
	private ArrayList<Turtle> turtles = new ArrayList<Turtle>();
	
	//コンストラクタ
	TurtleGraphicsPanel(){
		kame = new Turtle(200,200);
		square(kame);
		turtles.add(kame);
	}
	
	//Turtleに正方形を描かせる
	void square(Turtle t) {
		t.move(50);
		t.turn(90);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for(Turtle t: turtles) {
			t.paint(g);
		}
	}
}
