package com.greatLearning.dsa.dsaAssignment.SkewedTree;


class SkewedTreeSolution
{
//
	public static Node node;

	static int order = 0;

	// Driver Code
	public static void main (String[] args)
	{
	//    5
	//	 / \
	//  3    6
		SkewedTreeSolution.node = new Node(50);
		SkewedTreeSolution.node.left = new Node(30);
		SkewedTreeSolution.node.right = new Node(60);
		SkewedTreeSolution.node.left.left = new Node(10);
		SkewedTreeSolution.node.right.left= new Node(40);

		NodeUtils.flattenBTToSkewed(node, order);
		System.out.println("In Order : ");
		NodeUtils.traverseRightSkewed(NodeUtils.headNode);

	}
}

