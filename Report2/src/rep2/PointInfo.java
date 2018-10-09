package rep2;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;

public class PointInfo {

	//現在座標
	final Point bgn;
	//目的座標
	final Point dest;

	//直線の式ax+by+c=0の各定数
	//ラジアン(傾き)
	final double a;
	//定数
	final double b = -1;
	//切片
	final double c;

	final Color penColor;
	final Stroke penStr;

	PointInfo(int x, int y, double deg, double length, Color col, Stroke s){
		//現在座標の初期化
		bgn = new Point(x,y);

		//degree -> radian
		double rad = Math.toRadians(deg);

		//移動距離
		int dx = (int)(Math.cos(rad)*length);
		int dy = (int)(Math.sin(rad)*length);

		//目的座標の初期化
		dest = new Point(x+dx,y+dy);

		//a,cの初期化
		a = Math.tan(rad);
		c = y - a*x;

		//ペンカラーの取得
		penColor = col;

		//ペンサイズの取得
		penStr = s;
	}
}
