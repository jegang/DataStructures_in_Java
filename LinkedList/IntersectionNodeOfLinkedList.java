/************************************************
*	FileName :  IntersectionNodeOfLinkedList.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 18, 2018
*************************************************/
// Given two linked list, find the intersection node of the linked list
// This question is taken from CTCI 2.7

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
	
	Node findIntersection(Node l1, Node l2)
	{
		int sizeL1 = size(l1), sizeL2 = size(l2);
		Node tail1 = l1, tail2 = l2;
		
		while(tail1.next != null) tail1 = tail1.next;
		while(tail2.next != null) tail2 = tail2.next;
		// no intersection
		if(tail1 != tail2)
		{
			return null;
		}
		
		int count = Math.abs(sizeL1 -sizeL2);
		while( count-- != 0)
		{
			if(sizeL2 > 0)
			{
				l2 = l2.next;
			}
			else
			{
				l1 = l1.next;
			}
		}
		
		while (l1 != l2)
		{
			l1 = l1.next;
			l2 = l2.next;
		}
		return l2;
	}
	
	int size(Node node)
	{
		int i =0 ;
		while(node != null)
		{
			i++;
			node = node.next;
		}
		return i;
	}
	
	void intersectionWrapper(Node l1, Node l2)
	{
		Node temp = findIntersection(l1, l2);
		if (temp == null)
		{
			System.out.println("No intersection");
		}
		else
		{
			System.out.println(" Intersection value : " + temp.data);
		}
	}
	
	
	
	// Function execution begins here
	public static void main(String[] args)
	{
		LinkedList l1 = new LinkedList();
		
		Random r = new Random();
		for(int i=0; i < 7; i++)
		{
			l1.add(r.nextInt(100)+1);
		}
		
		l1.print();
		
		LinkedList l2 = new LinkedList();
		
		for(int i=0; i < 2; i++)
		{
			l2.add(r.nextInt(100)+1);
		}
		l2.print();
		
		l2.intersectionWrapper(l1.head, l2.head);
		
		l2.head.next.next = l1.head.next.next;
		
		l2.intersectionWrapper(l1.head, l2.head);
		
		
	}
	
}



