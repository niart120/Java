package rep2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Turtle {

	//現在位置
	PointDouble presPos = new PointDouble(0,0);
	//向き
	double angle = 0.0;
	//オフセット位置
	private int offsetX = 0;
	private int offsetY = 0;

	//ペンの色
	Color penColor = Color.black;
	//ペンサイズ
	BasicStroke penSize = new BasicStroke(1);

	//経路
	ArrayList<Section> paths = new ArrayList<Section>();

	//コンストラクタ
	Turtle(int x, int y){
		presPos.move(x,y);
	}

	//移動
	void move(double length) {
		//区間を生成
		Section sec = new Section(presPos, angle, length, penColor, penSize);
		//経路に区間を追加
		paths.add(sec);
		//現在位置更新
		presPos = new PointDouble(sec.getDest());
	}

	//方向転換
	void turn(double deg) {
		//角度変更(反時計回りを負に)
		angle -= deg;
	}

	//ペン色設定
	void setPenColor(Color c) {
		this.penColor = c;
	}

	//ペンサイズ設定
	void setPenSize(int size) {
		penSize = new BasicStroke(size);
	}

	//オフセット設定
	void setOffset(int dx,int dy) {
		offsetX = dx;
		offsetY = dy;
	}

	//経路更新(オフセット値の適用)
	void updatePaths() {
		for(Section sec: paths) {
			sec.recalcSection(offsetX, offsetY);
		}
	}

	//描画処理
	void paint(Graphics g) {
		//gをGraphics2Dでキャスト
		Graphics2D g2d = (Graphics2D)(g);
		for(Section sec: paths) {
			g2d.setColor(sec.getPenColor());
			g2d.setStroke(sec.getPenStr());

			//オフセット値補正
			int x1 = sec.getBgn().getX() + offsetX;
			int y1 = sec.getBgn().getY() + offsetY;
			int x2 = sec.getDest().getX() + offsetX;
			int y2 = sec.getDest().getY() + offsetY;

			g2d.drawLine(x1, y1, x2, y2);
		}
	}
	
	//Turtleに正方形を描かせる
	void square(Turtle t) {
		for(int i=0;i<4;i++) {
			t.move(50);
			t.turn(90);
		}
	}

	//Turtleに正三角形を描かせる
	void triangle(int size) {
		move(size);
		turn(120);
		move(size);
		turn(120);
		move(size);
		turn(120);
	}

	//Turtleにサイズを変えて正三角形群を描かせる
	void triangles(int n, int c, int d) {
		for (int i = 0; i++ < n; ) {
			triangle(i * c);
			turn(d);
		}
	}

	//Turtleに正多角形を描かせる
	void regPolygon(int size, int n) {
		//外角計算
		double dgr = 360.0/n;
		//描画命令
		for(int i=0; i<n; i++) {
			move(size);
			turn(dgr);
		}
	}

	//Turtleにn個の正(n+2)角形を描かせる
	void regPolygons(int size, int n) {
		if(3<=n) {
			for(int i=0;i<n;i++) {
				regPolygon(size,i+2);
			}
		}
	}

	//自由描画
	void drawSomething(int size, int n) {
		double gr = (1.0+Math.sqrt(5))/2.0;
		double dgr = 360.0 / 5.0;
		for(int i=0;i<n;i++) {
			Color col = new Color(255*i/n,255*i/n,255*i/n);
			setPenColor(col);
			setPenSize(i/2+1);
			move(size*gr*i);
			turn(dgr);
		}
	}


}
