package linklist;

import java.util.LinkedList;

public class LinkedListEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList <String> list = new LinkedList<String>();
		list.offer("피카츄");
		list.offer("라이츄");
		list.offer("파이리\n");
		//System.out.print(list.size());
		//int num = list.size();
		System.out.print(list.poll());
		System.out.print(list.peek());
		for(int i = 0; i < 3; i ++) {
			System.out.print(list.poll());
			System.out.print(list.peek());
		}
	}
}
