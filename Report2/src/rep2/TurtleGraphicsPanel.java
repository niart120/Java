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
		triangles(kame,40,2,10);
		turtles.add(kame);
	}
	
	//Turtleに正方形を描かせる
	void square(Turtle t) {
		for(int i=0;i<4;i++) {
			t.move(50);
			t.turn(90);
		}
	}
	
	void triangle(Turtle t, int size) {
		t.move(size);
		t.turn(120);
		t.move(size);
		t.turn(120);
		t.move(size);
		t.turn(120);
	}

	void triangles(Turtle t, int n, int c, int d) {
		for (int i = 0; i++ < n; ) {
			triangle(t, i * c);
			t.turn(d);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		for(Turtle t: turtles) {
			t.paint(g);
		}
	}
}
