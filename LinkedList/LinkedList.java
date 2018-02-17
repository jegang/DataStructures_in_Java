/************************************************
*	FileName :  LinkedList.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 16, 2018
*************************************************/
// I  have implemented the below functions of LinkedList
// 1. Node insertAtBeginning(int value)  - Inserting at the beginning
// 2. Node insertAfterTheValue(Node node, int value, int key)
// 3. Node deleteValue(Node node, int value)
// 4. int lengthOfLinkedList(Node head)
// 5. Node sort(Node head)



// Each node skeleton
class Node
{
	int value;
	Node next;
	Node(int value)
	{
		this.value = value;
		next = null;
	}
}

class LinkedList
{
	
	Node head;
	
	LinkedList()
	{
		head = null;
	}
	
	// Insert the element at the beginning
	Node insertAtBeginning(Node node, int value)
	{
		Node temp = new Node(value);
		if(node == null)
		{
			return temp;
		}
		temp.next = node;
		return temp;
	}
	
	// Insert the value node after the key, if key not present insert at end
	Node insertAfterTheValue(Node node, int value, int key)
	{
		Node temp = node;
		while(temp.next != null)
		{
			if(temp.value == key)
				break;
			temp = temp.next;
		}
		Node newNode = new Node(value);
		temp.next = newNode;
		return node;
	}
	
	// delete the node with value 
	Node deleteValue(Node node, int value)
	{
		Node temp = node, prev = node;
		if(node == null) return node;
		if (node.value == value)
		{
			temp = node.next;
			return temp;
		}
		while(temp != null)
		{
			if(temp.value == value)
			{
				prev.next = temp.next;
				return node;
			}
			prev = temp;
			temp = temp.next;
		}
		return node;
	}
	
	// Find the length of the linked list
	int lengthOfLinkedList(Node head)
	{
		int len = 0;
		Node node = head;
		while(node != null)
		{
			len++;
			node = node.next;
		}
		return len;
	}
	
	// Print the linked list
	void printLinkedList(Node head)
	{
		System.out.println();
		while(head != null)
		{
			System.out.print(head.value + " " );
			head = head.next;
		}
	}
	
	// Sort the node is ascending order
	Node sort(Node head)
	{
		Node temp1 = head, temp2 = head;
		while(temp1 != null)
		{
			temp2 = temp1.next;
			while(temp2 != null)
			{
				if(temp2.value < temp1.value)
				{
					temp2.value += temp1.value;
					temp1.value = temp2.value - temp1.value;
					temp2.value -= temp1.value;
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
		return head;
	}
	
	// Function execution begins here
	public static void main(String[] args)
	{
		LinkedList obj = new LinkedList();
		obj.head = obj.insertAtBeginning(obj.head, 10);
		obj.head = obj.insertAtBeginning(obj.head,20);
		obj.head = obj.insertAfterTheValue(obj.head, 30, 10);
		obj.head = obj.insertAfterTheValue(obj.head, 25, 98);
		obj.head = obj.insertAtBeginning(obj.head, 34);
		obj.head = obj.insertAtBeginning(obj.head, 12);
		obj.head = obj.insertAtBeginning(obj.head, 98);
		
		obj.printLinkedList(obj.head);
		obj.head = obj.deleteValue(obj.head, 20);
		
		
		obj.printLinkedList(obj.head);
		obj.head = obj.sort(obj.head);
		obj.printLinkedList(obj.head);
		System.out.println("\nLength of Linked List : " + obj.lengthOfLinkedList(obj.head));
	}
}