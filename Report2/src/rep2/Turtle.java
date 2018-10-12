package rep2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Turtle {

	//現在位置
	Point presPos = new Point(0,0);
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
		presPos = new Point(sec.getDest());
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
			int x1 = sec.getBgn().x + offsetX;
			int y1 = sec.getBgn().y + offsetY;
			int x2 = sec.getDest().x + offsetX;
			int y2 = sec.getDest().y + offsetY;

			g2d.drawLine(x1, y1, x2, y2);
		}
	}


}
