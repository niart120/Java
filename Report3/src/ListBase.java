public class ListBase {
	Cell header = new Cell("HEADER");//ヘッダーリスト
	Cell sentinel = new Cell("");//番兵リスト
	
	int dataNum; //リストの数
	
	ListBase(int num){//num個のリストを持つことを宣言
		dataNum = num;
		header.next = sentinel;
	}
	
	void add(Cell c) {//リストの末尾にcellを追加
		Cell curr = header.next;
		while (curr.next != sentinel) {
			curr = curr.next;
		}
		
		curr.next = c;
		c.next = sentinel;//末尾の番兵を更新
	}
	
	void insertTop(Cell c) {//リストの先頭にcellを追加
		c.next = header.next;//与えられたcellの次のcellを先頭のcellに
		header.next = c;
	}
	
	void insertAfter(String s, Cell c) {//文字列sを持つcellの後に新たなcellであるcを追加)
		
	}
	
	void insertBefore() {
		
	}
	
	void printList() {//内部のリストの全表示
		Cell curr = header.next;
		while (curr != null) {
	      System.out.print(curr.data + " ");
	      curr = curr.next;
	    }
	    System.out.println();
	  }
}
