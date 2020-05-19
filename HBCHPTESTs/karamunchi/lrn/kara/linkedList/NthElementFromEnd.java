package lrn.kara.linkedList;



import java.util.*;
/*class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

public class NthElementFromEnd {
    Node head;  
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
	  
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			int k = sc.nextInt();
			NthElementFromEnd llist = new NthElementFromEnd();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
          
		//System.out.println(llist.head.data);
        GfG g = new GfG(); 
		//System.out.println(k);
		System.out.println(g.getNthFromLast(llist.head,k));
		
			t--;
		}
	}
}
	
	

/*This is a function problem.You only need to complete the function given below*/
/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/
class GfG
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
        	Node curr   =   head;
        	Node fp =   head;
        	Node sp =   head;
        	int len   =   0;
        	
        	while(curr!=null){
        	    len++;
        	    curr=curr.next;
        	}
        	
        	if(n>len){
        	    return -1;
        	}
        	
        	if(head==null||head.next==null||n==0){
        	    return -1;
        	}
        	
        	while(n-- >= 0){
        	    fp  =   fp.next;
        	}
        	
        	while(fp!=null){
        	    fp  =   fp.next;
        	    sp  =   sp.next;
        	}
        	
        	return sp.next.data;
    }
}
