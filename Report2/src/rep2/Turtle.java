package rep2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Turtle {

	//現在位置
	Point presPos = new Point(0,0);
	//向き
	double angle = 0.0;
	//ペンの色
	Color penColor = Color.black;
	//ペンサイズ
	BasicStroke penSize = new BasicStroke(1);
	
	//経路
	ArrayList<Section> Paths = new ArrayList<Section>(); 
	
	//コンストラクタ
	Turtle(int x, int y){
		presPos.move(x,y);
	}
	
	//移動
	void move(double length) {
		
	}
	
	//方向転換
	void turn(double deg) {
		
	}
	
	//ペン色設定
	void setPenColor(Color c) {
		
	}
	
	//ペンサイズ設定
	void setPenSize(int size) {
		
	}
	
	//描画処理
	void paint(Graphics g) {
		
	}
	
	
}
