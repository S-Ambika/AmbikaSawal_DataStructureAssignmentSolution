package com.greatLearning.dsa.dsaAssignment.SkewedTree;

class Node {

	int val;
	Node left, right;

	/*
	 * Creating node
	 */
	public Node(int item) {
		val = item;
		left = right = null;
	}
	}

public class NodeUtils {

	static Node cur;

	static public Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void skewedBT(Node root, int order) {

		/*
		 * Base Case
		 */
		if (root == null) {
			return;
		}

		/*
		 * order in which the skewed tree to maintained
		 */

		if (order > 0) {
			skewedBT(root.right, order);
		} else {
			skewedBT(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;

		/*
		 * Condition to check if the root Node of the skewed tree is not defined
		 */
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		/*
		 * Similarly recurse for the left / right subtree on the basis of the order
		 * required
		 */
		if (order > 0) {
			skewedBT(leftNode, order);
		} else {
			skewedBT(rightNode, order);
		}
	}

	/*
	 * Traversing code to display elements in ascending order
	 */
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
		traverseRightSkewed_ascending(root.right);
	}

	/*
	 * Traversing code to display elements in In order
	 */
	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);
	}

}