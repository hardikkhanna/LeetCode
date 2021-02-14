/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Feb 8, 2021 Time : 11:01:30 AM
 */
public class SecondMinimumInBinaryTree extends BinaryTreeUse {

	static int min = Integer.MAX_VALUE;
	static int secondMin = -1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int secondMin = findSecondMinimum(root);
		System.out.println(secondMin);
	}

	/**
	 * @param root
	 * @return
	 */
	private static int findSecondMinimum(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return -1;
		}
		if (root.left == null && root.right == null) {
			return -1;
		}

		int left = root.left.data;
		int right = root.right.data;

		// if value same as root value, need to find the next candidate
		if (root.left.data == root.data) {
			left = findSecondMinimum(root.left);
		}
		if (root.right.data == root.data) {
			right = findSecondMinimum(root.right);
		}

		if (left != -1 && right != -1) {
			return Math.min(left, right);
		} else if (left != -1) {
			return left;
		} else {
			return right;
		}
	}

}
