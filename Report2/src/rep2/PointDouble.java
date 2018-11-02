package rep2;

class PointDouble {
	//x座標
	double x;
	//y座標
	double y;
	
	//コンストラクタ
	public PointDouble(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public PointDouble(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public PointDouble(PointDouble p){
		this.x = p.x;
		this.y = p.y;
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void translate(int dx,int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public int getX() {
		return (int) Math.round(x);
	}
	
	public int getY() {
		return (int) Math.round(y);
	}
}
