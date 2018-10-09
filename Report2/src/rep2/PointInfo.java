package rep2;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;

public class PointInfo {
	final Point bgn;
	final Point dest;

	final Color penColor;
	final Stroke penStr;

	PointInfo(int x1, int y1, int x2, int y2, Color c, Stroke s){
		//現在座標の初期化
		bgn = new Point(x1,y1);
		//目的座標の初期化
		dest = new Point(x2,y2);

		//ペンカラーの取得
		penColor = c;

		//ペンサイズの取得
		penStr = s;
	}
}
