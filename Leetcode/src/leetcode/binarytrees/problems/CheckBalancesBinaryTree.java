/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 18, 2021 Time : 4:58:59 PM
 */
public class CheckBalancesBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Boolean ans = checkBalanced(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	public static boolean checkBalanced(BinaryTreeNode<Integer> root) {

		// Write your code here
		int result = isBalanced(root);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int isBalanced(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftH = isBalanced(root.left);
		if (leftH == -1) {
			return -1;
		}
		int rightH = isBalanced(root.right);
		if (rightH == -1) {
			return -1;
		}
		int diff = leftH - rightH;
		if (Math.abs(diff) > 1) {
			return -1;
		}
		return 1 + Math.max(leftH, rightH);
	}

}
