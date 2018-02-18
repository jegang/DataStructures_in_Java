/************************************************
*	FileName :  RemoveDups.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 17, 2018
*************************************************/
// Remove the duplicate element of the unsorted linked list
// This question is taken from CTCI 

import java.util.*;

// Skeleton of single node in linked list
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

// class linkedlist containing the head node
class LinkedList
{
	Node head;
	
	// constructor
	LinkedList()
	{
		head = null;
	}
	
	// add node at the beginning
	Node insertAtBeginning(int data)
	{
		Node temp = new Node(data);
		temp.next = head;
		return temp;
	}
	
	// prints the linkedlist
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
	
	// Method to remove duplicates
	// Add the element to HashSet when first time it encounters
	// else delete the node
	void removeDuplicates()
	{
		HashSet<Integer> hs = new HashSet();
		Node temp = head, prev = null;
		
		while(temp != null)
		{
			if(hs.contains(temp.data))
			{
				if(head == temp)
				{
					head = head.next;
					temp = temp.next;
					continue;
				}
				else
				{
					prev.next = temp.next;
					temp = temp.next;
					continue;
				}
			}
			hs.add(temp.data);
			prev = temp;
			temp = temp.next;
		}
	}
	
	// Function execution begins here
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		
		Random r = new Random();
		
		for(int i=0; i < 10; i++)
		{
			l.head = l.insertAtBeginning(r.nextInt(5)+1); // generates a random number from 1 to 5
		}
		l.print();
		l.removeDuplicates();
		l.print();
		
		
	}
	
}