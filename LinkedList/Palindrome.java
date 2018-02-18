/************************************************
*	FileName :  Palindrome.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 18, 2018
*************************************************/
// Check whether the given linked list is palindrome

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
	
	// Add the string to stack until the middle of list
	// and then check them by popping it out
	boolean isPalindrome()
	{
		if(head == null) return false;
		Node slow = head, fast = head;
		Stack<Integer> st = new Stack<Integer>();
		while(fast != null && fast.next != null )
		{
			st.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// when length of linked list is odd, slow ptr is at middle
		if(fast != null)
		{
			slow =slow.next;
		}
		while(slow != null)
		{
			if(slow.data != st.pop())
			{
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	
	// Function execution begins here
	public static void main(String[] args)
	{
		LinkedList l = new LinkedList();
		
		l.add(4);
		l.add(2);
		l.add(2);
		l.add(4);
		
		
		System.out.println("4224 is " + (l.isPalindrome()?"Palindrome":"not a Palindrome"));
		
		l.add(6);
		
		System.out.println("42246 is " + (l.isPalindrome()? "Palindrome" : "not a Palindrome"));
		LinkedList l2 = new LinkedList();
		
		
		l2.add(3);
		l2.add(0);
		l2.add(3);
		
		System.out.println("303 is " + (l2.isPalindrome() ? "Palindrome" : "not a Palindrome"));
		
		l2.add(5);
		System.out.println("3035 is " + (l2.isPalindrome() ? "Palindrome" : "not a Palindrome"));
		
		
		
		
	}
	
}



