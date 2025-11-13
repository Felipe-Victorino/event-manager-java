package util.interval;

import java.util.Date;

public class DateIntervalTree {
	// if I extend the Binary Tree Class will the node be overwritten by this one or will I have two nodes

	Node root;

	private Node add(Node node, DateInterval value){
		if(node == null){
			node = new Node(value);
		} else if (value.low.before(node.interval.low)){
			node.left = add(node.left, value);
		} else {
			node.right = add(node.right, value);
		}
		return node;
	}
	
	private Node remove(Node root, DateInterval value){
		if(root == null){
			return null;
		}
		if(root.interval.low.before(value.low)){
			root.right = remove(root.right, value);
		} else if (root.interval.low.after(value.low)){
			root.left = remove(root.right, value);
		} else {
			if(isLeaf(root)){
				return null;
			}

			if(root.left == null){
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			Node min = min(root.right);
			root.interval = min.interval;
			root.right = remove (root, min.interval);
		}
		return root;
	}

	private boolean isLeaf(Node root){
		return root.left == null && root.right == null;
	}

	private Node min (Node node){
		Node aux = node;
		while(aux.left != null){
			aux = aux.left;
		}
		return aux;
	}
	
	private boolean TreeSearch(DateInterval value) {
		Node root = this.root;

		while(root != null){
			if(root.interval == value) return true;

			root = value.low.before(root.interval.low)  ? root.left : root.right;
		}
		return false;
	}

	private void printTree(Node root, int level) {
		if (root == null) return;
		printTree(root.right, level + 1);
		for (int i = 0; i < level; i++) {
			System.out.print("    ");
		}
		System.out.println(root.interval.low);
		printTree(root.left, level + 1);
	}

	private static class Node{
		DateInterval interval;
		Date max;
		Node left, right;


		public Node(DateInterval value){
			this.interval = value;
			this.max = value.high;
			this.left = null;
			this.right = null;
		}
	}
}