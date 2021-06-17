/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 26-Apr-2021 Time : 11:06:42 am
 */

class BSTPair {
	int min;
	int max;
	boolean isBST;

	/**
	 * 
	 */
	public BSTPair(int min, int max, boolean isBST) {
		this.min = min;
		this.max = max;
		this.isBST = isBST;
	}
}

public class IsBST extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		// Approach 1
		Boolean ans = isBST(root);

		System.out.println("Approach 1 answer : " + ans);

		// Approach 2
		ans = isBST2(root);
		System.out.println("Approach 2 answer : " + ans);

		// Approach 3
		ans = isBST3(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	private static Boolean isBST3(BinaryTreeNode<Integer> root) {
		return isBST3helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * @param root
	 * @param maxValue
	 * @param minValue
	 * @return
	 */
	private static Boolean isBST3helper(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}

		if (root.data < minValue || root.data > maxValue) {
			return false;
		}

		Boolean isleftBST = isBST3helper(root.left, minValue, root.data - 1);
		Boolean isRightBST = isBST3helper(root.right, root.data, maxValue);
		return isleftBST && isRightBST;
	}

	/**
	 * Improved solution to isBST solution with the help of Pair class
	 * 
	 * @param root
	 * @return True if the Tree is a BST false otherwise
	 */
	private static Boolean isBST2(BinaryTreeNode<Integer> root) {
		return isBST2helper(root).isBST;
	}

	/**
	 * @param root
	 * @return
	 */
	private static BSTPair isBST2helper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new BSTPair(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		}

		BSTPair left = isBST2helper(root.left);
		BSTPair right = isBST2helper(root.right);

		int min = Math.min(root.data, Math.min(left.min, right.min));
		int max = Math.max(root.data, Math.max(left.max, right.max));

		boolean isBST = true;
		if (left.max >= root.data) {
			isBST = false;
		}
		if (right.min < root.data) {
			isBST = false;
		}
		if (left.isBST == false) {
			isBST = false;
		}
		if (right.isBST == false) {
			isBST = false;
		}

		return new BSTPair(min, max, isBST);
	}

	/**
	 * 
	 * @param root
	 * @return True if the Tree is a BST false otherwise
	 */
	private static Boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;

		int min = getMaximum(root.left);
		if (min >= root.data) {
			return false;
		}
		int max = getMinimum(root.right);
		if (max < root.data) {
			return false;
		}

		Boolean isLeftBST = isBST(root.left);
		if (isLeftBST == false) {
			return false;
		}
		Boolean isRightBST = isBST(root.right);
		if (isRightBST == false) {
			return false;
		}
		return isLeftBST && isRightBST;
	}

	/**
	 * utility function to get the maximum from the binaryTree
	 * 
	 * @param root
	 * @return maximum element of Binary tree
	 */
	private static int getMaximum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		int leftMax = getMaximum(root.left);
		int rightMax = getMaximum(root.right);
		return Math.max(root.data, Math.max(leftMax, rightMax));
	}

	/**
	 * utility function to get minimum from the binary tree
	 * 
	 * @param root
	 * @return minimum element of Binary tree
	 */
	private static int getMinimum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}

		int leftMin = getMinimum(root.left);
		int rightMin = getMinimum(root.right);

		return Math.min(root.data, Math.min(leftMin, rightMin));
	}

}
