/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 12-Apr-2021 Time : 9:32:37 pm
 */

class Diff {
	int maxDiff;
	int minDiff;

	Diff(int maxDiff, int minDiff) {
		this.maxDiff = maxDiff;
		this.minDiff = minDiff;
	}
}

public class MaximumHeightDifference extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int maxDifference = getMaximumDifference(root);
		System.out.println(maxDifference);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int getMaximumDifference(BinaryTreeNode<Integer> root) {
		// Approach 1
		
		// Edge Cases
		if(root == null) return 0;
		if(root.left == null  && root.right == null) return 1;
		
		// Call minDepth on left Substree
		int leftMinDepth = minDepth(root.left);
		// Call maxDepth on left Subtree
		int leftMaxDepth = maxDepth(root.left);
		
		// Mirror the above 2 steps for right subtree as well
		// i.e call minDepth and maxDepth for right subtree
		int rightMinDepth = minDepth(root.right);
		int rightMaxDepth = maxDepth(root.right);
		
		// Now the max Difference will be either the
		//difference between leftMin and rightMax
		// or rightMin and leftMax
		return Math.max(Math.abs(leftMaxDepth - rightMinDepth), Math.abs(leftMinDepth - rightMaxDepth));
	}

	/**
	 * @param left
	 * @return
	 */
	private static int maxDepth(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;
		
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	/**
	 * @param left
	 * @return
	 */
	private static int minDepth(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;
		return 1+Math.min(minDepth(root.left), minDepth(root.right));
	}

}
 