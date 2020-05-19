package lrn.kara.linkedList;

import java.util.Scanner;

public class PairwiseSwap {
	    static Node head;
	    
	    public static void main (String[] args) {
	        Scanner sc= new Scanner(System.in);
	        int t = sc.nextInt();
	        
	        while(t-- > 0)
	        {
	            int n = sc.nextInt();
	            int a1 = sc.nextInt();
	            Node head = new Node(a1);
	            
	            addToTheLast(head);
	            for(int i = 1; i < n; i++)
	            {
	                int a = sc.nextInt();
	                addToTheLast(new Node(a));
	            }
	            
	          
	            Gfc gfc = new Gfc();
	            head = gfc.pairwiseSwap(head);
	            printList(head);
	            System.out.println();
	        }
	    }
	    
	    public static void addToTheLast(Node node)
	    {
	        if(head == null)
	        {
	            head = node;
	        }
	        else
	        {
	            Node temp = head;
	            while(temp.next !=  null)
	              temp = temp.next;
	              temp.next = node;
	        }
	    }
	    
	    public static void printList(Node node)
	    {
	        while(node != null)
	        {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	}
	
/*This is a function problem.You only need to complete the function given below*/
	/*node class of the linked list
	class Node
	{
	    int data;
	    Node next;
	    Node(int key)
	    {
	        data = key;
	        next = null;
	    }
	}*/
	// complete the below function
	class Gfc
	{
	    public static Node pairwiseSwap(Node head)
	    {
	    	Node curr	=	head;
	    	Node trackedNode	=	head;
	        Node prev	=null;
	        Node next	=null;
	        int prevData	=	0;
	        while(curr!=null) {
	        	prevData	=	curr.data;
	        	curr.data	=	curr.next.data;
	        	curr	=	curr.next;
	        	curr.data	=	prevData;
	        	curr	=	curr.next;
	        }
	    	return trackedNode;
	     
	    }
	    
	   
	}