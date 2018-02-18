/************************************************
*	FileName :  LeastCommonAncestor.java
*	Author	 :  Jegan Gopalakrishnan
*   Date	 :  Feb 16, 2018
*************************************************/
// I have implemented the below functions of BST
// 1. search(Node node, int key) - Searching a key in BST
// 2. insert(Node node, int key) - Inserting a node in BST
// 3. Traversals : inorder, preorder, postorder, level order
// 4. Finding the height of the tree
// 5. delete(Node node, int key) - Deleting a key from BST

// Skeleton of single node
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

// Main class - contains all the functionality
class  LeastCommonAncestor
{
	Node root;  // root node
	
	LeastCommonAncestor()
	{
		root = null;
	}
	
	// insert the a new node of value key and return the root
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
	
	// Least Common Ancestor
	
	
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
	
	// minimum value in a given BST
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
	
	
	// Least Common Ancestor in binary tree or BST
	Node LCA(Node node, int a, int b)
	{
		
		if(node == null) return node;
		
		if( node.value == a || node.value == b)
		{
			return node;
		}
		
		Node lsubtree = LCA(node.left, a , b);
		Node rsubtree = LCA(node.right, a , b);
		
		if( lsubtree != null && rsubtree != null)
		{
			return node;
		}
		
		if( lsubtree == null)
		{
			return rsubtree;
		}
		else
		{
			return lsubtree;
		}
	}
	
	
	Node LCAforBST(Node root, int a, int b)
	{
		if(root == null) return null;
		
		if(root.value < a && root.value < b)
			return LCAforBST(root.right, a, b);
		else if(root.value > a && root.value > b)
			return LCAforBST(root.left, a, b);
		return root;
	}
	
	// Function execution begins here
	public static void main(String[] args) 
	{
		LeastCommonAncestor bst = new LeastCommonAncestor();
		// Inserting set of nodes
		bst.root = bst.insert(bst.root, 10);
		bst.root = bst.insert(bst.root, 5);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 6);
		bst.root = bst.insert(bst.root, 3);
		bst.root = bst.insert(bst.root, 18);
		bst.root = bst.insert(bst.root, 22);
		
		//			10
		//         /   \
		//	      5     20
		//       /  \   /  \
		//      3    6  18  22
		
		
		// Height of the tree
		System.out.println("\n Height of tree " + bst.height(bst.root));
		System.out.println("Level order traversal");
		bst.printLevelOrder(bst.root);
		
		Node temp = bst.LCA(bst.root, 3,6);
		System.out.println(" Ancestor of 3 & 6 is " + temp.value);	

		temp = bst.LCA(bst.root, 18,6);
		System.out.println(" Ancestor of 18 & 6 is " + temp.value);

		temp = bst.LCA(bst.root, 3,5);
		System.out.println(" Ancestor of 3 & 5 is " + temp.value);


		temp = bst.LCAforBST(bst.root, 3,6);
		System.out.println(" Ancestor of 3 & 6 is " + temp.value);	

		temp = bst.LCAforBST(bst.root, 18,6);
		System.out.println(" Ancestor of 18 & 6 is " + temp.value);

		temp = bst.LCAforBST(bst.root, 3,5);
		System.out.println(" Ancestor of 3 & 5 is " + temp.value);
		
		
		
		
	}
}
