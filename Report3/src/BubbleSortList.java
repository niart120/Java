
public class BubbleSortList extends ListBase {

	BubbleSortList(int num) {
		super(num);//親メソッドのコンストラクタ呼び出し
	}

	void bubbleSort() {
		if(dataNum<=1) return;
		boolean isContinue;
		Cell curr = header.next;
		do{
			isContinue = false;
			while(curr.next != sentinel) {
				int a = (Integer)curr.data;
				int b = (Integer)curr.next.data;
				if(a>b) {
					swapContents(curr,curr.next);
					isContinue = true;
				}
				curr = curr.next;
			}
			curr = header.next;
		}while(isContinue);
	}

}
