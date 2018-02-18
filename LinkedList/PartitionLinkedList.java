/************************************************
*	FileName :  PartitionLinkedList.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 18, 2018
*************************************************/
// Partition the linked list around a value 'x'
// that is all the elements before x appears at the beginning
// and remaining appear at the end
// This question is taken from CTCI 2.4

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
	
	void partitionLinkedList(int x)
	{
		Node start = null, end = null;
		Node temp = head;
		while(temp != null)
		{
			Node newNode = new Node(temp.data);
			if(start == null)
			{
				start = end = newNode;
				temp = temp.next; continue;
			}
			
			if(temp.data < x)
			{
				newNode.next = start;
				start = newNode;
			}
			else
			{
				end.next = newNode;
				end = newNode;
			}
			temp = temp.next;
		}
		head = start;
		
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
		
		l.partitionLinkedList(50);
		l.print();
		
	}
	
}



