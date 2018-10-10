package rep2;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class TurtleGraphicsPanel extends JPanel implements MouseListener, MouseMotionListener{
	//Turtle インスタンス
	private Turtle kame;

	//クリック時の座標保持
	private int pressedX;
	private int pressedY;

	//選択された亀のリスト番号(-1=無選択)
	private int selectedTurtle = -1;

	//Turtle保持用のArrayList
	private ArrayList<Turtle> turtles = new ArrayList<Turtle>();

	//コンストラクタ
	TurtleGraphicsPanel(){
		//イベントリスナーの設定
		addMouseMotionListener(this);
		addMouseListener(this);

		kame = new Turtle(200,200);
		regPolygons(kame,40,15);
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
		double dgr = 360.0/n;
		//描画命令
		for(int i=0; i<n; i++) {
			t.move(size);
			t.turn(dgr);
		}
	}

	//Turtleにn個の正(n+2)角形を描かせる
	void regPolygons(Turtle t, int size, int n) {
		if(3<=n) {
			for(int i=0;i<n;i++) {
				regPolygon(t,size,i+2);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		for(Turtle t: turtles) {
			t.paint(g);
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(selectedTurtle != -1) {
			//相対距離の取得
			int dx = arg0.getX()-pressedX;
			int dy = arg0.getY()-pressedY;

			//オフセット値の更新
			turtles.get(selectedTurtle).setOffset(dx,dy);

			//再描画
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//クリック判定は描画の逆順
		for(int i=turtles.size()-1;0<=i;i--) {
			for(Section sec: turtles.get(i).paths) {
				//経路にマウス座標が含まれていればそのTurtleを選択
				if(sec.isInPoint(arg0.getX(), arg0.getY())) {
					selectedTurtle = i;
					pressedX = arg0.getX();
					pressedY = arg0.getY();
					repaint();
					return;
				}
			}
		}
		//上記の処理を抜けたならば未選択として処理
		selectedTurtle = -1;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(selectedTurtle != -1) {
			//タートルの経路にオフセット値を適用
			turtles.get(selectedTurtle).updatePaths();
			//オフセット値のリセット
			turtles.get(selectedTurtle).setOffset(0, 0);

			repaint();
		}
	}
}
