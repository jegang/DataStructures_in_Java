/************************************************
*	FileName :  DeleteMiddle.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 17, 2018
*************************************************/
// Delete the middle element of the node
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
	// starting node of linked list
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
	
	void deleteMiddleElement()
	{
		if(head == null || head.next == null || head.next.next == null)
			return;
		Node end = head, deletingNode = head, prev = head;
		while(end.next != null && end.next.next != null)
		{
			end = end.next.next;
			prev = deletingNode;
			deletingNode = deletingNode.next;
		}
		prev.next = deletingNode.next;
	}
	
	// Function execution begins here
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		
		Random r = new Random();
		for(int i=0; i < 7; i++)
		{
			l.add(r.nextInt(100)+1);
		}
		
		l.print();
		
		for(int i=0; i < 7; i++)
		{
			l.deleteMiddleElement();
			l.print();
		}
		
	}
	
}



