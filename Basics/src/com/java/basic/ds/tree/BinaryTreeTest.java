package com.java.basic.ds.tree;

class Node {
	int data;
	Node(int data){
		this.data = data;
	}
	public Node left;
	public Node right;
}
public class BinaryTreeTest {
	static int isBST = 0;
	static void checkLeft(Node node) {
		if (node.left == null ) {
			return;
		}
		if (node.left != null && node.data > node.left.data) {
			checkLeft(node.left);
		} else if (node.left != null && node.data < node.left.data) {
			isBST = -1;
		} 
	}
	static void checkRight(Node node) {
		if (node.right == null ) {
			return;
		}
		if (node.right != null && node.data < node.right.data) {
			checkRight(node.right);
		} else if (node.right != null && node.data > node.right.data){
			isBST = -1;
		}
	}
	static boolean checkBST(Node root) {
		checkLeft(root);
		checkRight(root);
		return ( isBST == 0 );
	}
	public static void main(String[] args) {
		
		Node root = new Node(4);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		
		
		Node eight = new Node(8);
		Node nine = new Node(9);
		
		Node ten = new Node(10);
		Node eleven = new Node(11);
		
		root.left = two;
		two.left = one;
		two.right = three;
		root.right = six;
		six.left = five;
		six.right = seven;
		
		seven.right = eight;
		eight.right = nine;
		nine.right = ten;
		ten.left = eleven;
		
		

		
		System.out.println(checkBST(root));
		

	}

}
