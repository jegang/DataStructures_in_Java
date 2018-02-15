/************************************************
*	FileName :  BinarySearchTree.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 15, 2018
*************************************************/
// I have implemented the below functions of BST
// 1. search(Node node, int key) - Searching a key in BST
// 2. insert(Node node, int key) - Inserting a node in BST
// 3. Traversals : inorder, preorder, postorder, level order
// 4. Finding the height of the tree
// 5. delete(Node node, int key) - Deleting a key from BST

class Node
	{
		int value;
		Node left, right;

		Node(int value)
		{
			this.value = value;
			left = right = null;
		}
}

class  BinarySearchTree
{
	Node root;
	
	BinarySearchTree()
	{
		root = null;
	}
	
	// Searching an element in binary search tree
	Node search(Node node, int key)
	{
		if(node == null || node.value == key)
		{
			return node;
		}
		if(key < node.value)
		{
			// search in the left sub tree
			return search(node.left, key);
		}
		if(key > node.value)
		{   // search for the key in right subtree
			return search(node.right, key);
		}
		return node;
	}
	
	
	Node insert(Node node, int key)
	{
		// point to be inserted
		if(node == null)
		{ 
			node = new Node(key);
			return node;
		}
		
		if(key < node.value)
		{
			node.left = insert(node.left, key);
		}
		else if( key > node.value)
		{
			node.right = insert(node.right, key);
		}
		// return the unchanged pointer
		return node;
	}
	
	
	
	// inorder traversal - left - root - right
	void inorder(Node root)
	{
		if( root != null)
		{
			inorder(root.left);
			System.out.print(root.value + " ");
			inorder(root.right);
		}
	}
	
	// preorder traversal : root -> left -> right
	void preorder (Node root)
	{
		if(root != null)
		{
			System.out.print(root.value + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	
	// postorder traversal : left -> right -> root
	void postorder(Node root)
	{
		if(root != null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.value + " ");
		}
	}
	
	// calculating the height of the tree
	int height(Node root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			int lheight = height(root.left);
			int rheight = height(root.right);
			return (lheight > rheight) ? lheight+1 : rheight+1;
		}
	}
	
	// Level order traversal
	void printLevelOrder(Node node)
	{
		int h = height(node);
		for(int i=1;i<=h;i++)
		{
			System.out.println("\n Node at Level " + i + ":");
			printNodesAtGivenLevel(node, i);
		}
	}
	// printing node at the given level
	void printNodesAtGivenLevel(Node node, int level)
	{
		if(node == null)
		{
			return;
		}
		if(level == 1)
		{
			System.out.print(node.value + " ");
		}
		else
		{
			printNodesAtGivenLevel(node.left, level-1);
			printNodesAtGivenLevel(node.right, level-1);
		}
	}
	
	// Deleting the element
	Node delete(Node node, int key)
	{
		if(node == null) return node;
		
		if(key < node.value)
		{
			node.left = delete(node.left, key);
		}
		else if(key > node.value)
		{
			node.right = delete(node.right, key);
		}
		else
		{
			// node to be deleted
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			
			node.value = rightMin(node.right);
			node.right = delete(node.right, node.value);	
		}
		return node;
	}
	
	int rightMin(Node node)
	{
		int min = node.value;
		while(node.left != null)
		{
			min = node.value;
			node = node.left;
		}
		return min;
	}
	
	public static void main(String[] args) 
	{
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 5);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 6);
		bst.root = bst.insert(bst.root, 3);
		bst.root = bst.insert(bst.root, 22);
		
		
		
		System.out.println(" In order traversal");
		bst.inorder(bst.root);
		System.out.println("\n Preorder traversal");
		bst.preorder(bst.root);
		System.out.println("\n Postorder traversal");
		bst.postorder(bst.root);
		
		System.out.println("\n Height of tree " + bst.height(bst.root));
		System.out.println("Level order traversal");
		bst.printLevelOrder(bst.root);
		
		bst.root = bst.delete(bst.root, 10);
		System.out.println("Level order traversal after deleting 22");
		bst.printLevelOrder(bst.root);
	}
}
