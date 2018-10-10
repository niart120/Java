package rep2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;

class Section {

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

	Section(Point p, double deg, double length, Color col, BasicStroke bs){
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
		//ペンの幅(半径)
		double r = penStr.getLineWidth()/2+1.0;
		//xが経路の変域(x)に含まれるか(1)
		boolean isInDomain = (bgn.x-r<=x&&x<=dest.x+r)||(dest.x-r<=x&&x<=bgn.x);
		//点と経路の距離d(点と直線の式より算出)
		double d = Math.abs(a*x+b*y+c)/Math.hypot(a, b);
		//距離が半径r以内であるか(2)
		boolean isInRadius = (d<=r);

		//(1)かつ(2)を満たすならtrue
		return isInDomain&&isInRadius;
	}

	//ドラッグ距離に応じた経路変更
	void applyOffset(int dx, int dy) {
		bgn.translate(dx, dy);
		dest.translate(dx, dy);
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
