package sample2;

import java.util.ArrayList;
import java.util.LinkedList;


//kt0y1c
public class ListTest {

	public static void main(String[] args) {
		
		System.out.println(10+5*2);
		ArrayList<Integer> list1 = new ArrayList<>();
		LinkedList<Integer> list2 = new LinkedList<>();

		list1.add(13);
		list1.add(12);
		list1.add(11);
		list1.add(15);
		list1.add(14);

		list2.add(13);	
		list2.add(12);
		list2.add(11);
		list2.add(15);
		list2.add(14);

		for (int i = 0; i < 5; i++) {
			System.out.println("List 1 : " + list1.get(i) + " ");
			System.out.println("List 2 : " + list2.get(i) + " ");
		}

	}

}
