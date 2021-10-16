package com.greatLearning.dsa.dsaAssignment.SkewedTree;

class Node {

	int val;
	Node left, right;

	public Node(int item) {
		val = item;
		left = right = null;
	}

}

class NodeUtils {

	static Node cur;

	static public Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void flattenBTToSkewed(Node root, int order) {

// Base Case
		if (root == null) {
			return;
		}

// Condition to check the order
// in which the skewed tree to
// maintained
		if (order > 0) {
			flattenBTToSkewed(root.right, order);
		} else {
			flattenBTToSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

// Condition to check if the root Node
// of the skewed tree is not defined
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

// Similarly recurse for the left / right
// subtree on the basis of the order required
		if (order > 0) {
			flattenBTToSkewed(leftNode, order);
		} else {
			flattenBTToSkewed(rightNode, order);
		}
	}

// Function to traverse the right
// skewed tree using recursion
	static void traverseRightSkewed_ascending(Node root) {
		if (root == null) {
			return;
		}
		if (root.right != null && root.val > root.right.val) {
			int temp;
			temp = root.val;
			root.val = root.right.val;
			root.right.val = temp;

		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}
	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
//		if (root.right != null && root.val > root.right.val) {
//			int temp;
//			temp = root.val;
//			root.val = root.right.val;
//			root.right.val = temp;
//
//		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

}