package com.shan.algo.trees;

import lombok.ToString;

public class BinarySearchTree {

	Node root;

	@ToString
	class Node {
		private int data;
		private Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	void insert(int data) {
		root = insertNode(root, data);
	}

	private Node insertNode(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data) {
			root.left = insertNode(root.left, data);
		} else if (data > root.data) {
			root.right = insertNode(root.right, data);
		}

		return root;
	}
	
	void delete( int data) {
		root  = deleteRec(root, data);
	}

	private Node deleteRec(Node root, int data) {
		if(root == null) return root;
		
		if(data < root.data) {
			root.left =  deleteRec(root.left, data);
		}else if (data > root.data) {
			root.right = deleteRec(root.right, data);
		}
		else {
			//single child nodes..
			if(root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			//two children nodes..
			//minValue on the right of the node to be deleted.
			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}
		
		return root;
	}
	
	private int minValue(Node root) {
		int minV = root.data;
		while(root.left != null) {
			minV = root.left.data;
			root = root.left;
		}
		return minV;
	}

	Node search(Node root, int data) {
		if(root.data == data) {
			return root;
		}else if(data < root.data){
			return search(root.left, data);
		}else {
			return search(root.right, data);
		}
	}
	
	void inorder() {
		inorderRec(root);
		System.out.println();
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.data + " ");
			inorderRec(root.right);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.insert(35);
		
		tree.inorder();
		
		System.out.println("Search for 70..");
		Node result = tree.search(tree.root, 70); 
		System.out.println("Node : "+result);

		System.out.println("Delete 30");
		tree.delete(30);
		tree.inorder();
		
	}

}
