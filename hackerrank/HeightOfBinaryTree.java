package hackerrank;

public class HeightOfBinaryTree {
	public static int height(Node root) {
      	// Write your code here.
        if (root == null)
            return -1;
        return Math.max(height(root.right), height(root.left)) + 1;
    }
}
