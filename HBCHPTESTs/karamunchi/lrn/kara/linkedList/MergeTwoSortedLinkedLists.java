package lrn.kara.linkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * @author ys19299
 *
 */
public class MergeTwoSortedLinkedLists {

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

	// Complete the mergeLists function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		/*
		 * SinglyLinkedListNode head = new SinglyLinkedListNode(0); SinglyLinkedListNode
		 * curr = head;
		 * 
		 * SinglyLinkedListNode l1 = head1; SinglyLinkedListNode l2 = head2;
		 * 
		 * while (l1 != null && l2 != null) { if (l1.data <= l2.data) {
		 * 
		 * while (curr.next != null) { curr = curr.next; } curr.next = l1; l1 = l1.next;
		 * } else { while (curr.next != null) { curr = curr.next; } curr.next = l2; l2 =
		 * l2.next; }
		 * 
		 * 
		 * head1 = head1.next; head2 = head2.next;
		 * 
		 * 
		 * }
		 * 
		 * 
		 * System.out.println("Trying to print the current state of new list"); while
		 * (head.next != null) { System.out.print(head.data + " "); head = head.next; }
		 * 
		 * 
		 * while (curr.next != null) { curr = curr.next; }
		 * 
		 * if (l1 != null) { curr.next = l1; } else if (l2 != null) { curr.next = l2; }
		 * 
		 * 
		 * System.out.println("Trying to print the current state of new list"); while
		 * (head.next != null) { System.out.println(head.data + " "); head = head.next;
		 * }
		 * 
		 * System.out.println();
		 * 
		 * // curr = curr.next;
		 * 
		 * return head.next;
		 */

		SinglyLinkedListNode head = new SinglyLinkedListNode(0);
		SinglyLinkedListNode p = head;

		SinglyLinkedListNode p1 = head1;
		SinglyLinkedListNode p2 = head2;
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return head.next;

	}

	/**
	 * @param head
	 * @param positionFromTail
	 * @return the value at that position
	 * 
	 *         <b>Logic</b>: Have two pointers(A,B), move one(A) till the number of
	 *         positions are equal to positionFromTail Then move the other(B)
	 *         pointer until the first pointer reaches the end of the linnkedList
	 *         The B pointer will then be present at the nth position from the end
	 * 
	 */
	static int getNode(SinglyLinkedListNode head, int positionFromTail) {
		SinglyLinkedListNode nth = null;
		SinglyLinkedListNode temp = head;

		for (int i = 0; i < positionFromTail; i++) {
			temp = temp.next;
		}

		while (temp != null) {
			if (nth == null) {
				nth = head;
			} else {
				nth = nth.next;
			}
			temp = temp.next;
		}
		
		if(nth!=null) {
			return nth.data;
		}else {
			return 0;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
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

			SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

			// printSinglyLinkedList(llist3, " ", bufferedWriter);
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}