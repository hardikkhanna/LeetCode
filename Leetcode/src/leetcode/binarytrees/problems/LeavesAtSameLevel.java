/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 12-Apr-2021 Time : 3:10:37 pm
 */
public class LeavesAtSameLevel extends BinaryTreeUse {

	/**
	 * @param args
	 */

	static int maxLevel = -1;

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		checkLeaves(root);

	}

	/**
	 * @param root
	 */
	public static void checkLeaves(BinaryTreeNode<Integer> root) {
		/*
		 * Your class should be named Solution. Read input as specified in the question.
		 * Print output as specified in the question.
		 */
		int ans = isSameLevel(root);
		if (ans != -1)
			System.out.print("YES");
		else
			System.out.print("NO");

	}

	private static int isSameLevel(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		int left = isSameLevel(root.left);
		int right = isSameLevel(root.right);

		if (left == -1 || right == -1 || left != right) {
			return -1;
		}
		return left + 1;
	}

}
