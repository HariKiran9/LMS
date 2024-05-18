package ivy;

import java.util.ArrayList;
import java.util.List;

public class LinkedListLoop {

	class Node {

	}

	public static boolean isLoop(Node head) {
		List<Node> list = new ArrayList<Node>();
		while (head != null) {
			if (list.contains(head)) {
				return true;
			}
			list.add(head);
		}
		return false;
	}

}
