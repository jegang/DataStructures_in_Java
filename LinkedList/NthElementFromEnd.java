/************************************************
*	FileName :  NthElementFromEnd.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 17, 2018
*************************************************/
// Return nth element from the end of linkedlist
// This question is taken from CTCI 2.2


import java.util.*;

// Blueprint of single node
class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}


class LinkedList
{
	Node head; // starting node of linked list
	
	// constructor
	LinkedList()
	{
		head = null;
	}
	
	// Add at the beginning of the linked list
	void add(int num)
	{
		Node newNode = new Node(num);
		newNode.next = head;
		head = newNode;
	}
	
	// print the linked list
	void print()
	{
		Node temp = head;
		System.out.println();
		
		while(temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	// Method to remove nth element from end
	// Have a second pointer move n-1 position from head.
	// Now move both pointer until second pointer reaches the end
	// print the value of current pointer
	void returnNthElementFromEnd(int n)
	{
		if(head == null) return;
		Node current = head, end = head;
		int dist = n-1;
		while(dist > 0)
		{
			if(end == null)
			{
				System.out.println(" \nThe linked list doesn't contain " + n + " elements");
				return;
			}
			end = end.next;
			dist -= 1;
		}
		
		while(end.next !=null)
		{
			current = current.next;
			end = end.next;
		}
		System.out.println("\n"+n + "th element from end is " + current.data);
	}
	
	//Recursive approach to print the element
	// recursively pass the next node and return the node index
	int printNthElementRec(Node node, int n)
	{
		if(node == null)
		{
			return 0;
		}
		int index = printNthElementRec(node.next, n) + 1;
		if(index == n)
		{
			System.out.println("\n"+n + "th element from end : " +  node.data);
		}
		return index;
	}
	
	// Function execution begins here
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		Random r = new Random();
		
		for(int i=0; i < 20; i++)
		{
			l.add(r.nextInt(100)+1);
		}
		l.print();
		
		// return first element
		l.returnNthElementFromEnd(20);
		l.print();
		
		// Out of range
		l.returnNthElementFromEnd(25);
		l.print();
		
		// Some element in middle
		l.returnNthElementFromEnd(6);
		l.print();
		
		// return first element
		l.printNthElementRec(l.head,20);
		l.print();
		
		// Out of range
		l.printNthElementRec(l.head, 25);
		l.print();
		
		// Some element in middle
		l.printNthElementRec(l.head, 6);
		l.print();
	}
	
}



