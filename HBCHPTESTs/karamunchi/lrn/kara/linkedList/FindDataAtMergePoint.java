package lrn.kara.linkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindDataAtMergePoint {
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the findMergeNode function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		int l1 = 0, l2 = 0;
		int diff = 0;

		SinglyLinkedListNode h1 = head1;
		SinglyLinkedListNode h2 = head2;

		while (h1 != null) {
			l1++;
			h1 = h1.next;
		}
		while (h2 != null) {
			l2++;
			h2 = h2.next;
		}

		if (l1 > l2) {
			diff = l1 - l2;

			for (int i = 0; i < diff; i++) {
				head1 = head1.next;
			}

			while (head2.next != null) {
				if (head1.next != head2.next) {
					head1 = head1.next;
					head2 = head2.next;
				} else {
					head1 = head1.next;
					return head1.data;
				}
			}

		} else if (l1 == l2) {
			head1 = head1.next;
			return head1.data;
		} else {
			diff = l2 - l1;
			for (int i = 0; i < diff; i++) {
				head2 = head2.next;
			}

			while (head1.next != null) {
				if (head1.next != head2.next) {
					head1 = head1.next;
					head2 = head2.next;
				} else {
					head2 = head2.next;
					return head2.data;
				}
			}
		}
		return -1;
		/*
		OTHER SOLUTION FORM HACKERRANK:-
		
		   HashSet<SinglyLinkedListNode> set = new HashSet<>();
		
		    while (head1 != null) {
		        set.add(head1);
		        head1 = head1.next;
		    }
		
		    while (head2 != null) {
		        if(set.contains(head2)) {
		            return head2.data;
		        }
		        head2 = head2.next;
		    }

    		return -1;
		
		*/
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedList llist1 = new SinglyLinkedList();

			int llist1Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist1Count; i++) {
				int llist1Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist1.insertNode(llist1Item);
			}

			SinglyLinkedList llist2 = new SinglyLinkedList();

			int llist2Count = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llist2Count; i++) {
				int llist2Item = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist2.insertNode(llist2Item);
			}

			SinglyLinkedListNode ptr1 = llist1.head;
			SinglyLinkedListNode ptr2 = llist2.head;

			for (int i = 0; i < llist1Count; i++) {
				if (i < index) {
					ptr1 = ptr1.next;
				}
			}

			for (int i = 0; i < llist2Count; i++) {
				if (i != llist2Count - 1) {
					ptr2 = ptr2.next;
				}
			}

			ptr2.next = ptr1;

			int result = findMergeNode(llist1.head, llist2.head);
			System.out.println(result);
//			bufferedWriter.write(String.valueOf(result));
//			bufferedWriter.newLine();
		}

//		bufferedWriter.close();

		scanner.close();
	}
}
