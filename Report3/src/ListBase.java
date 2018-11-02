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

	boolean isInList(String s) {//文字列sを持つcellの探査)
		sentinel.data = s;//番兵の活用
		Cell curr = header.next;
		while(curr.data.equals(s)) {
			curr = curr.next;
		}
		sentinel.data = "";
		return sentinel != curr; //アドレスが一致しないならばデータが存在->true
	}

	void insertTop(Cell c) {//リストの先頭にcellを追加
		c.next = header.next;//与えられたcellの次のcellを先頭のcellに
		header.next = c;
	}

	void insertAfter(String s, Cell c) {//文字列sを持つcellの後に新たなcellであるcを追加)
		sentinel.data = s;//番兵の活用
		Cell curr = header.next;
		while(curr.data.equals(s)) {
			curr = curr.next;
		}
		sentinel.data = "";
		if(sentinel!=curr) {
			c.next = curr.next; //currの次のcellのアドレスをc.nextに代入
			curr.next = c; //curr.nextをcに更新
		}
	}

	void insertBefore(String s, Cell c) {
		sentinel.data = s;//番兵の活用
		Cell curr = header.next;
		while(curr.next.data.equals(s)) {//curr.nextで確認
			curr = curr.next;
		}
		sentinel.data = "";

		if(sentinel!=curr.next) {
			c.next = curr.next; //currの次のcellのアドレスをc.nextに代入
			curr.next = c; //curr.nextをcに更新
		}
	}

	void remove(String s) {
		Cell curr = header.next;
		Cell prev = header;
		sentinel.data = s;
		while(curr.data.equals(s)) {
			curr = curr.next;
			prev = prev.next;
		}
		sentinel.data = "";

		if(curr != sentinel) {
			prev.next = curr.next; //currを飛ばして結合
		}

	  }

	void swap(String a, String b) {
		Cell findA = find(a);
		if(findA == null) return;//aの存在保障
		Cell findB = find(b);
		if(findB == null) return;//bの存在保障

		Cell prevA = prev(a);
		Cell prevB = prev(b);

		if(prevA == findB) {//B -> Aの順
			Cell temp = findA;

			prevB.next = findA;
			findA.next = findB;
			findB.next = temp.next;

		}else if(prevB == findA){//A -> Bの順
			Cell temp = findB;

			prevA.next = findB;
			findB.next = findA;
			findA.next = temp.next;
		}else {
			Cell tempA = findA;//一時データの保持
			Cell tempB = findB;//一時データの保持

			prevA.next = findB;
			findB.next = tempA.next;

			prevB.next = findA;
			findA.next = tempB.next;

		}
	}

	Cell find(String s) {
		sentinel.data = s;//番兵の活用
		Cell curr = header.next;
		while(curr.data.equals(s)) {
			curr = curr.next;
		}
		sentinel.data = "";
		if(curr != sentinel) {
			return curr;
		}
		return null;
	}

	Cell prev(String s) {
		sentinel.data = s;//番兵の活用
		Cell curr = header.next;
		while(curr.next.data.equals(s)) {
			curr = curr.next;
		}
		sentinel.data = "";
		if(curr.next != sentinel) {
			return curr;	//発見できたならそのcellを返す
		}
		return null;	//if文を抜けたなら強制的にnullを返す
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
