package rep2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;

class PointInfo {

	//現在座標
	private Point bgn;
	//目的座標
	private Point dest;

	private final Color penColor;
	private final BasicStroke penStr;

	//直線の式ax+by+c=0の各定数
	//ラジアン(傾き)
	private double a;
	//定数
	private final double b = -1;
	//切片
	private double c;

	PointInfo(Point p, double deg, double length, Color col, BasicStroke bs){
		//現在座標の初期化
		bgn = new Point(p);

		//degree -> radian
		double rad = Math.toRadians(deg);

		//移動距離
		int dx = (int)(Math.cos(rad)*length);
		int dy = (int)(Math.sin(rad)*length);

		//目的座標の初期化
		dest = new Point(p.x+dx,p.y+dy);

		//a,cの初期化
		a = Math.tan(rad);
		c = p.y - a*p.x;

		//ペンカラーの取得
		penColor = col;

		//ペンサイズの取得
		penStr = bs;
	}

	//経路中に点が含まれるかの判定
	boolean isInPoint(int x,int y) {


		return true;
	}

	//getter
	Point getBgn() {
		return bgn;
	}

	Point getDest() {
		return dest;
	}

	Color getPenColor() {
		return penColor;
	}

	BasicStroke getPenStr() {
		return penStr;
	}
}
