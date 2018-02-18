/************************************************
*	FileName :  NthElementFromEnd.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 17, 2018
*************************************************/
// Return nth element from the end of linkedlist
// This question is taken from CTCI 


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
	Node head; // starting node of linkedlist
	
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
	// Now delete the current pointer
	void removeNthElementFromEnd(int n)
	{
		if(head == null) return;
		Node current = head, end = head, prev = head;
		int dist = n-1;
		while(end != null && dist > 0)
		{
			end = end.next;
			dist -= 1;
		}
		if(end == null)
		{
			System.out.println(" \nThe linked list doesn't contain " + n + " elements");
			return;
		}
		while(end.next !=null)
		{
			prev = current;
			current = current.next;
			end = end.next;
		}
		if(current == head)
		{
			head = head.next;
		}
		else
		{
			prev.next = current.next;
		}
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
		
		// Removing first element
		l.removeNthElementFromEnd(20);
		l.print();
		// Out of range
		l.removeNthElementFromEnd(25);
		l.print();
		
		// Some element in middle
		l.removeNthElementFromEnd(6);
		l.print();		
		
		
	}
	
}



