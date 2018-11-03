import java.util.Random;

public class ListBase {
	Cell header = new Cell("HEADER");//ヘッダーリスト
	Cell sentinel = new Cell("");//番兵リスト

	int dataNum; //リストの数

	ListBase(int num){//num個のリストを持つことを宣言
		dataNum = num;
		header.next = sentinel;
	}

	void makeList() {//データの生成
		int[] tempList = new int[dataNum];

		for(int i=0;i<dataNum;i++) {
			tempList[i] = i;
		}

		//シャッフル
		for(int i=0;i<dataNum-1;i++){
			Random rnd = new Random();
			int offset = rnd.nextInt(dataNum-i);
			int temp = tempList[i];

			tempList[i] = tempList[i+offset];
			tempList[i+offset] = temp;
		}

		//格納
		for(int i=0; i<dataNum; i++) {
			insertTop(new Cell(new Integer(tempList[i])));
		}
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
		if(header.next != c) {
			c.next = header.next;//与えられたcellの次のcellを先頭のcellに
			header.next = c;
		}
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

	//指定された文字列を含むcellを削除
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

	void swapContents(Cell c1, Cell c2) {
		if(c1 != null && c2 != null) {
			Object temp = c1.data;
			c1.data = c2.data;
			c2.data = temp;
		}
	}

	//リストの反転
	void reverse() {
		Cell curr = header.next;
		while(curr != sentinel) {
			Cell temp = curr.next; //次の処理でcurrが変化するため保持
			insertTop(curr);
			curr = temp;
		}
	}

	//リストの結合
	static ListBase concat(ListBase lb1, ListBase lb2) {
		ListBase concat = new ListBase(lb1.dataNum+lb2.dataNum);
		Cell curr = lb1.header.next;
		Cell temp;
		while(curr != lb1.sentinel) {
			temp = curr.next;//次の処理でcurr.nextが変化するため保持
			concat.insertTop(curr);
			curr = temp;//保持しておいた参照値を代入
		}

		curr = lb2.header.next;
		while(curr != lb2.sentinel) {
			temp = curr.next;//次の処理でcurr.nextが変化するため保持
			concat.insertTop(curr);//currを追加
			curr = temp;//保持しておいた参照値を代入
		}

		concat.reverse();
		return concat;
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
