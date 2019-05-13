package com.shan.algo.trees;

public class Boustrophedon {

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
		
		printBoustrophedon(root);
		
	}

	private static void printBoustrophedon(TreeNode root) {
		
		int height = getTreeHeight(root);
		System.out.println("Height of the tree : "+height);
		
		boolean ltr = true; 
        for (int i = 1; i <= height; i++) { 
            printTreeLevel(root, i, ltr); 
            ltr = !ltr; 
        } 
		
	}

	private static int getTreeHeight(TreeNode root) {

		if(root == null) {
			return 0;
		}
		
		int lDepth = getTreeHeight(root.left); 
        int rDepth = getTreeHeight(root.right); 

        if (lDepth > rDepth) 
            return (lDepth + 1); 
         else 
            return (rDepth + 1); 
	}
	
	private static void printTreeLevel(TreeNode node, int level, boolean isLeftRight) {
		
		if (node == null) 
            return; 
        if (level == 1) 
            System.out.print(node.data + " "); 
        else if (level > 1) { 
            if (isLeftRight) { 
            	printTreeLevel(node.left, level - 1, isLeftRight); 
            	printTreeLevel(node.right, level - 1, isLeftRight); 
            } 
            else { 
            	printTreeLevel(node.right, level - 1, isLeftRight); 
            	printTreeLevel(node.left, level - 1, isLeftRight); 
            } 
        } 
	}

}
