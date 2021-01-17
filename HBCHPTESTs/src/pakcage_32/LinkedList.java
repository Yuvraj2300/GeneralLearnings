package pakcage_32;

/*
node
int val
next
*/
public class LinkedList {
	Node head;
	public LinkedList() {
	}

	public static void main(String[] args) {
		Node	node1	=	new	 Node(1);
		Node	node2	=	new	 Node(2);
		Node	node3	=	new	 Node(3);
		
		LinkedList	ls_1	=	new	 LinkedList();
		ls_1.head	=	node1;
		node1.next	=	node2;
		node2.next	=	node3;
		node3.next	=	null;
		
	}
	
	
	static	void	show(LinkedList ll) {
		System.out.println();
	}

}

class Node{
	int val;
	Node next;	
	
	public Node(int val) {
		// TODO Auto-generated constructor stub
		this.val=val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
	
}
