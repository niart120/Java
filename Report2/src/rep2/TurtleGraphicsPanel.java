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
		triangles(kame,40,2,20);
		turtles.add(kame);
	}
	
	//Turtleに正方形を描かせる
	void square(Turtle t) {
		for(int i=0;i<4;i++) {
			t.move(50);
			t.turn(90);
		}
	}
	
	//Turtleに正三角形を描かせる
	void triangle(Turtle t, int size) {
		t.move(size);
		t.turn(120);
		t.move(size);
		t.turn(120);
		t.move(size);
		t.turn(120);
	}

	//Turtleにサイズを変えて正三角形群を描かせる
	void triangles(Turtle t, int n, int c, int d) {
		for (int i = 0; i++ < n; ) {
			triangle(t, i * c);
			t.turn(d);
		}
	}
	
	//Turtleに正多角形を描かせる
	void regPolygon(Turtle t, int size, int n) {
		//外角計算
		double dgr = 360/n;
		//描画命令
		for(int i=0; i<n; i++) {
			t.move(size);
			t.turn(dgr);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		for(Turtle t: turtles) {
			t.paint(g);
		}
	}
}
