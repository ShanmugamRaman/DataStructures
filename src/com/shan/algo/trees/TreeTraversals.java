package com.shan.algo.trees;

public class TreeTraversals {
	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		printTraversals(root);
		
	}

	private static void printTraversals(TreeNode root) {
		
		System.out.println("printPreOrderTraversals.. DATA - LEFT - RIGHT");
		printPreOrderTraversals(root);
		System.out.println("**********************");
		
		System.out.println("printPostOrderTraversals.. LEFT - RIGHT - DATA");
		printPostOrderTraversals(root);
		System.out.println("**********************");
		
		System.out.println("printInOrderTraversals.. LEFT - DATA - RIGHT ");
		printInOrderTraversals(root);
		System.out.println("**********************");
		
		printLevelOrderTraversals(root);
		
	}

	private static void printLevelOrderTraversals(TreeNode root) {
		System.out.println("Level Order Traversal..");
		
		int height = getHeightOfTree(root);
		System.out.println("Height of the tree.. "+getHeightOfTree(root));
		
		for(int i = 1; i <= height; i++) {
			printTreeAtLevel(root, i);
		}
		
	}

	private static void printTreeAtLevel(TreeNode root, int height) {
		if(root == null)
			return;
		if (height == 1 ) 
			System.out.print(root.data+" ");
		else {
			printTreeAtLevel(root.left, height - 1);
			printTreeAtLevel(root.right, height - 1);
		}
	}

	private static int getHeightOfTree(TreeNode root) {
		if(root == null)
			return 0;
		
		int lHeight = getHeightOfTree(root.left);
		int rHeight = getHeightOfTree(root.right);
		
		if(lHeight > rHeight) {
			return lHeight + 1;
		}else {
			return rHeight + 1;
		}
	}

	private static void printInOrderTraversals(TreeNode node) {
		
		if (node == null) 
            return; 
		printInOrderTraversals(node.left); 
        System.out.print(node.data + " "); 
        printInOrderTraversals(node.right); 
	}

	private static void printPostOrderTraversals(TreeNode node) {
		if (node == null) 
            return; 
		printPostOrderTraversals(node.left); 
		printPostOrderTraversals(node.right);
		System.out.print(node.data + " "); 
	}

	private static void printPreOrderTraversals(TreeNode node) {
		if (node == null) 
            return; 
		System.out.print(node.data + " ");
		printPreOrderTraversals(node.left); 
		printPreOrderTraversals(node.right);
	}

}
