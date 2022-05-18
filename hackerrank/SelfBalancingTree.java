package hackerrank;

class Node {
	int val; // Value
	int ht; // Height
	Node left; // Left child
	Node right; // Right child
}
class SelfBalancingTree {
	
	static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node();
			root.val = val;
			root.ht = setHeight(root);
			return root;
		}
		if (val <= root.val) {
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
		}
		int balance = getHeight(root.left) - getHeight(root.right);

		if (balance > 1) {
			if (getHeight(root.left.left) >= getHeight(root.left.right)) {
				root = rightRotation(root);
			} else {
				root.left = leftRotation(root.left);
				root = rightRotation(root);
			}
		} else if (balance < -1) {
			if (getHeight(root.right.right) >= getHeight(root.right.left)) {
				root = leftRotation(root);
			} else {
				root.right = rightRotation(root.right);
				root = leftRotation(root);
			}
		} else {
			root.ht = setHeight(root);
		}
		return root;
	}

	private static Node rightRotation(Node root) {
		Node newRoot = root.left;
		root.left = newRoot.right;
		newRoot.right = root;
		root.ht = setHeight(root);
		newRoot.ht = setHeight(newRoot);
		return newRoot;
	}

	private static Node leftRotation(Node root) {
		Node newRoot = root.right;
		root.right = newRoot.left;
		newRoot.left = root;
		root.ht = setHeight(root);
		newRoot.ht = setHeight(newRoot);
		return newRoot;
	}

	private static int getHeight(Node root) {
		if (root == null)
			return -1;
		else
			return root.ht;
	}

	private static int setHeight(Node root) {
		if (root == null) {
			return -1;
		} else {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
	}
}