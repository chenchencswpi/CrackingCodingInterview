package linkedLists;

import java.util.HashSet;

/**
 * Question: Write code to remove duplicates from an unsorted linked list.
 * Follow up: How would you solve this problem if a temporary buffer is not allowed?
 * @author chenchen
 *
 */
public class RemoveDups {
	public static void main(String[] args) {
		
	}
}

class RemoveDupsSolution {
	/**
	 * Use hashtable as additional data structure.
	 * @param head
	 */
	void removeDuplicateWithAddtionalDS(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(head.val);
		while (head.next != null) {
			if (set.contains(head.next.val)) {
				head.next = head.next.next;
			} else {
				set.add(head.next.val);
				head = head.next;
			}
		}
	}
	
	void removeDuplicateWithoutAdditionalDS(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		while (head != null) {
			Node cursor = head;
			while (cursor.next != null) {
				if (cursor.next.val == head.val) {
					cursor.next = cursor.next.next;
				} else {
					cursor = cursor.next;
				}
			}
			head = head.next;
		}
	}
}

class Node {
	int val;
	Node next;
	public Node(int val) {
		this.val = val;
	}
}