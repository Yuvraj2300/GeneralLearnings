package lrn.kara.linkedList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DeleteElementFromEnd {

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

	// Complete the removeDuplicates function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {

		SinglyLinkedListNode trackedList = head;
		SinglyLinkedListNode prev = head;
		SinglyLinkedListNode curr = head;
		SinglyLinkedListNode _next = head;

		while (curr != null && _next!=null) {

			curr = curr.next;
			_next = curr.next;
			if (prev.data == curr.data) {
				System.out.println("Data equal");
				prev.next = _next;
			}else {
			prev = prev.next;
			}
		}
		if (_next == null) {
			return trackedList;
		}
		return trackedList;
	}

	private static final Scanner scanner = new Scanner(System.in);

	/*
	 * INP 1 5 1 2 2 3 4
	 */

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			SinglyLinkedListNode llist1 = removeDuplicates(llist.head);

//			printSinglyLinkedList(llist1, " ", bufferedWriter);
//			bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
