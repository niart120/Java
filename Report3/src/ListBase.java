public class ListBase {
	Cell header = new Cell("HEADER");
	Cell sentinel = new Cell("");
	
	int dataNum; //リストの数
	
	ListBase(int num){
		dataNum = num;
		header.next = sentinel;
	}
}
