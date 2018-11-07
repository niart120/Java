
public class SortProgram {

	public static void main(String[] args) {

		BubbleSortList bs = new BubbleSortList(50000);
		MergeSortList ms = new MergeSortList(50000);
		bs.makeList();
		ms.makeList();

		long t1 = System.currentTimeMillis(); // ソート前の時刻の保持(ms)
		bs.bubbleSort();
		long t2 = System.currentTimeMillis(); // ソート後の時刻の保持(ms)
		System.out.println((t2 - t1) + "ms");
		//bs.printList();

		t1 = System.currentTimeMillis(); // ソート前の時刻の保持(ms)
		ms.mergeSort();
		t2 = System.currentTimeMillis(); // ソート後の時刻の保持(ms)
		System.out.println((t2 - t1) + "ms");
		//ms.printList();

	}

}
