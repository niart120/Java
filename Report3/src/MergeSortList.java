
public class MergeSortList extends ListBase {
	MergeSortList(int num) {
		super(num);
	}

	void mergeSort() {

	}

	ListBase mergeSort(ListBase list, int num){
		//要素が一つのみならそれをList化して返す
		if(num==1) {
			ListBase lb = new ListBase(1);
			lb.insertTop(list.header.next);
			return lb;
		}
		//そうでないならばリストを分割
		ListBase lb1 = new ListBase(num/2);
		ListBase lb2 = new ListBase(num-num/2);

		int i;
		Cell curr = list.header.next;
		for(i=0;i<num/2;i++) {
			lb1.insertTop(curr);
			curr = curr.next;
		}
		lb1 = mergeSort(lb1,num/2);
		for(;i<num;i++) {
			lb2.insertTop(curr);
			curr = curr.next;
		}
		lb2 = mergeSort(lb2,num-num/2);
		return merge(lb1,lb2);
	}

	ListBase merge(ListBase lb1,ListBase lb2) {
		ListBase merged = new ListBase(lb1.dataNum+lb2.dataNum);
		Cell curr_1 = lb1.header.next;
		Cell curr_2 = lb2.header.next;

		while(curr_1!=lb1.sentinel&&curr_2!=lb2.sentinel) {
			if(curr_1 == lb1.sentinel) {
				merged.insertTop(curr_2);
			}else if(curr_2 == lb2.sentinel) {
				merged.insertTop(curr_1);
			}else {
				int a = (Integer)curr_1.data;
				int b = (Integer)curr_2.data;
				if(a>b) {
					merged.insertTop(curr_2);
					curr_2 = curr_2.next;
				}else {
					merged.insertTop(curr_1);
					curr_1 = curr_1.next;
				}
			}
		}
		merged.reverse();//リストの反転
		return merged;
	}

}
