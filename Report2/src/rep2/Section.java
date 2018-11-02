package rep2;

import java.awt.BasicStroke;
import java.awt.Color;

class Section {

	//現在座標
	private PointDouble bgn;
	//目的座標
	private PointDouble dest;

	private final Color penColor;
	private final BasicStroke penStr;

	//直線の式ax+by+c=0の各定数
	//tan(傾き)
	private double a;
	//定数
	private final double b = -1;
	//切片
	private double c;

	Section(PointDouble presPos, double deg, double length, Color col, BasicStroke bs){
		//現在座標の初期化
		bgn = new PointDouble(presPos);

		//degree -> radian
		double rad = Math.toRadians(deg);

		//移動距離
		double dx = Math.cos(rad)*length;
		double dy = Math.sin(rad)*length;

		//目的座標の初期化
		dest = new PointDouble(presPos.x+dx,presPos.y+dy);

		//a,cの初期化
		a = Math.tan(rad);
		c = presPos.y - a*presPos.x;

		//ペンカラーの取得
		penColor = col;

		//ペンサイズの取得
		penStr = bs;
	}

	//経路中に点が含まれるかの判定
	boolean isInPoint(int x,int y) {
		//線が描画されていないならfalse
		if(penStr.getLineWidth()==0.0) {
			return false;
		}
		//ペンの幅(半径)
		double r = penStr.getLineWidth()/2+2.0;
		//x,yが経路の変域に含まれるか(1)
		boolean isInDomainX = (bgn.x-r<=x&&x<=dest.x+r)||(dest.x-r<=x&&x<=bgn.x+r);
		boolean isInDomainY = (bgn.y-r<=y&&y<=dest.y+r)||(dest.y-r<=y&&y<=bgn.y+r);
		//点と経路の距離d(点と直線の式より算出)
		double d = Math.abs(a*x+b*y+c)/Math.hypot(a, b);
		//距離が半径r以内であるか(2)
		boolean isInRadius = (d<=r);

		//(1)かつ(2)を満たすならtrue
		return isInDomainX&&isInDomainY&&isInRadius;
	}

	//ドラッグ処理後の再計算
	void recalcSection(int dx, int dy) {
		//経路の再計算
		bgn.translate(dx, dy);
		dest.translate(dx, dy);
		//切片の再計算
		c = bgn.y - a * bgn.x;
	}

	//getter
	PointDouble getBgn() {
		return bgn;
	}

	PointDouble getDest() {
		return dest;
	}

	Color getPenColor() {
		return penColor;
	}

	BasicStroke getPenStr() {
		return penStr;
	}
}
