/************************************************
*	FileName :  LoopDetection.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 18, 2018
*************************************************/
// LoopDetection : First detect whether loop is 
// available in linked list. Find the node where 
// loop starts
// This question is taken from CTCI 2.8

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
	//starting node of linked list
	Node head; 
	
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
	
	Node loopDetection()
	{
		Node slow = head, fast = head;
		
		if(head == null) return null;
		
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) break;
		}
		
		// No loop in the linked list
		if(fast == null || fast.next == null) 
			return null;
		
		// Move the head to loop start & collision point to loop start
		slow = head;
		
		while( slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	void findLoops()
	{
		Node temp = loopDetection();
		if( temp == null)
		{
			System.out.println(" No loops in the linked list ");
		}
		else
		{
			System.out.println(" Loop starts at " + temp.data);
		}
			
		
	}
	
	
	void createLoop(Node someNode)
	{
		Node temp = head;
		while(temp.next != null)
			temp = temp.next;
		temp.next = someNode;
	}
	// Function execution begins here
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		
		
		for(int i=9; i > 0; i--)
		{
			l.add(i);
		}
		
		l.print();
		
		l.findLoops();
		
		l.createLoop(l.head.next.next);
		
		l.findLoops();
		
		
		
	}
	
}



