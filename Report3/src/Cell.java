
public class Cell {
	Cell next; // 次のセル
	Object data; // データ
	
	// コンストラクタ（データを引数に取ってセットする）
	Cell(Object obj) {
		next = null;
	    data = obj;
	    }
}
