package rep2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;

public class Turtle {

	//現在位置
	Point presPos = new Point(0,0);
	//向き
	double angle = 0.0;
	//ペンの色
	Color penColor = Color.black;
	//ペンサイズ
	BasicStroke penSize = new BasicStroke(1);
	
	Turtle(int x, int y){
		presPos.move(x,y);
	}
	
}
