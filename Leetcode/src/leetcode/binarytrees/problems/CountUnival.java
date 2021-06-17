/**
 * 
 */
package leetcode.binarytrees.problems;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 11:34:18 pm
 */
class UnivalPair {
	boolean isUnival;
	int data;
	int sum;

	/**
	 * 
	 */
	public UnivalPair(boolean isUnival, int data, int sum) {
		this.data = data;
		this.isUnival = isUnival;
		this.sum = sum;
	}
}

public class CountUnival extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		// Approach 1 : O(n2)
		int count = countUnivalTrees(root);
		System.out.println(count);

		// Approach 2 : O(n)
		count = countUnivalTreesBetter(root);
		System.out.println(count);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int countUnivalTreesBetter(BinaryTreeNode<Integer> root) {

		return helper(root).sum;
	}

	private static UnivalPair helper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new UnivalPair(true, -1, 0);
		}
		if (root.left == null && root.right == null) {
			return new UnivalPair(true, root.data, 1);
		}

		UnivalPair left = helper(root.left);
		UnivalPair right = helper(root.right);

		boolean isUnival = false;
		int sum = left.sum + right.sum;
		int data = root.data;
		UnivalPair pair = new UnivalPair(isUnival, data, sum);
		if (left.isUnival && right.isUnival) {
			if (root.right != null && !root.data.equals(root.right.data)) {
				return pair;
			}
			if (root.left != null && !root.data.equals(root.left.data)) {
				return pair;
			}
			pair.isUnival = true;
			pair.sum++;
		}
		return pair;

	}

	// Approach : O(n2)
	public static int countUnivalTrees(BinaryTreeNode<Integer> root) {
		// base case is root is null
		// count = 0;
		if (root == null) {
			return 0;
		}

		Boolean left = areAllSame(root.left, root.data);
		Boolean right = areAllSame(root.right, root.data);

		int leftSum = countUnivalTrees(root.left);
		int rightSum = countUnivalTrees(root.right);

		if (left && right) {
			return 1 + leftSum + rightSum;
		}

		return leftSum + rightSum;

	}

	private static boolean areAllSame(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return true;
		}

		if (root.data != data) {
			return false;
		}
		return areAllSame(root.left, data) && areAllSame(root.right, data);
	}

}
