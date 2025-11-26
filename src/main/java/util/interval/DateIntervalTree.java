package util.interval;

import exceptions.IntervalTreeOverlap;

import java.util.Date;

public class DateIntervalTree {

	Node root;

	public void add(DateInterval i){
		if(isOverlapping(overlapSearch(this.root, i), i)){
			throw new IntervalTreeOverlap("Service Rule Broken: Tree shouldn't have overlapping dates");
		} else {
			add(this.root, i);
		}
	}

	public void remove(DateInterval i){
		if(isOverlapping(overlapSearch(this.root, i), i)){
			throw new IntervalTreeOverlap("Service Rule Broken: Tree shouldn't have overlapping dates");
		} else {
			remove(this.root, i);
		}
	}

	private boolean isOverlapping(DateInterval i1, DateInterval i2) {
		return i1.low.before(i2.high) && i2.low.before(i1.high);
	}

	private DateInterval overlapSearch(Node root, DateInterval i) {
		if (root == null) return null;
		if (isOverlapping(root.interval, i)){
			return root.interval;
		};

		if (root.left != null && root.left.max.after( i.low))
			return overlapSearch(root.left, i);

		return overlapSearch(root.right, i);
	}

	private Node add(Node root, DateInterval value){
		if(root == null){
			root = new Node(value);
		} else if (value.low.before(root.interval.low)){
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
		}
		return rebalance(root);
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

		return rebalance(root);
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

	private int height(Node root){
		if (root == null) return -1;

		int lHeight, rHeight;
		lHeight = height(root.left);
		rHeight = height(root.right);

		return Math.max(lHeight, rHeight) + 1;
	}

	private void updateHeight(Node root){
		root.height = height(root);
	}

	private int checkBalance (Node root){
		return height(root.left) - height(root.right);
	}

	private Node rebalance(Node root){
		int fb = checkBalance(root);
		if(fb < -1 && checkBalance(root.right) <= 0){
			return rotateLeft(root);
		}
		if (fb > 1 && checkBalance(root.left) >= 0){
			return rotateRight(root);
		}
		if (fb < -1 && checkBalance(root.right) > 0){
			root.right = rotateRight(root.right);
			return rotateLeft(root);
		}
		if(fb > 1 && checkBalance(root.left) < 0){
			root.left = rotateLeft(root.left);
			return rotateRight(root);
		}
		return root;
	}

	private Node rotateLeft(Node root){
		Node newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		updateHeight(root);
		updateHeight(newRoot);
		return newRoot;
	}

	private Node rotateRight(Node root){
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		updateHeight(root);
		updateHeight(newRoot);
		return newRoot;
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
		int height;


		public Node(DateInterval value){
			this.interval = value;
			this.max = value.high;
			this.left = null;
			this.right = null;
		}
	}
}