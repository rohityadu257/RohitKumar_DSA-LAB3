package practice;

import java.util.ArrayList;

	class Node {
	int data;
	Node left,right;

	Node(int d)
    	{
        data = d;
        left = right = null;
    	}
	}

	public class BinarySearchTree {
	Node root;
	 
    // Constructor
    BinarySearchTree()
    {
        root = null;
    }
 
    void inorder()
    {
        inorderUtil(this.root);
    }
 
   
    void inorderUtil(Node node)
    {
        if (node == null)
            return;
 
        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }

    void insert(int data)
    {
    root = insertRec(root, data);
    }


    Node insertRec(Node root, int data)
    {

    /* If the tree is empty, return a new node */
    if (root == null) {
        root = new Node(data);
        return root;
    }
    if (data < root.data)
        root.left = insertRec(root.left, data);
    else if (data > root.data)
        root.right = insertRec(root.right, data);

    return root;
    }

	ArrayList<Integer> BSTList(Node node,ArrayList<Integer>List){
		
		if(node == null)
			return List;
		BSTList(node.left,List);
		List.add(node.data);
		BSTList(node.right,List);
		
		return List;
		
	}
	
	boolean pairPresent(Node node, int key) {
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 =BSTList(node,a1);
		
		int start = 0;
		int end = a2.size() -1;
		 while(start < end) {
			 if(a2.get(start) + a2.get(end) ==  key)
			 {
				System.out.println(" Pair node found ( " + a2.get(start) + " , " + a2.get(end)  +  " ) = " + key);
				return true;
			 }
			 if(a2.get(start) + a2.get(end) > key)
			 {
				end--;
			 }
			 if(a2.get(start) + a2.get(end) < key)
			 {
				start++;
			 }
			 
		 }
		 System.out.println ("Value Pair not found");
		 return false;
	}
		 
		 public static void main(String[] args) 
		 {
		 BinarySearchTree tree = new BinarySearchTree();
		 
	        tree.insert(40);
		tree.insert(20);
	        tree.insert(60);
	        tree.insert(10);
	        tree.insert(30);
	        tree.insert(70);
	        tree.insert(50);
	 
	 
	        tree.pairPresent(tree.root, 130);
	    
		 }


	}






