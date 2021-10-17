package com.greatLearning.dsa.dsaAssignment.SkewedTree;

class SkewedTreeSolution {

	static Node node;
	static int order = 0;

	// Driver Code
	public static void main(String[] args) {
	/*
	 *    50
	 *   /  \
	 *  30   60
	 *  /    /
	 *  10   40
	 */

	SkewedTreeSolution.node = new Node(50);
	SkewedTreeSolution.node.left = new Node(30);
	SkewedTreeSolution.node.right = new Node(60);
	SkewedTreeSolution.node.left.left = new Node(10);
	SkewedTreeSolution.node.right.left = new Node(40);
	NodeUtils.skewedBT(node, order);

	System.out.println("Right Skewed Binary Tree In Order Traversal : ");
	NodeUtils.traverseRightSkewed(NodeUtils.headNode);
	System.out.println("\n");
	System.out.println("Right Skewed Binary Tree In Ascending Order : ");
	NodeUtils.traverseRightSkewed_ascending(NodeUtils.headNode);
		
		/*
		 * 10
		 *   \
		 *   30
		 *     \
		 *     40
		 *       \
		 *       50
		 *         \
		 *         60
		 */
		

	}
}
