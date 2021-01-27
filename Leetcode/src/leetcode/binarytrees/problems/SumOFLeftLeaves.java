/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 27, 2021 Time : 4:53:55 PM
 */
public class SumOFLeftLeaves extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int ans = sumOfLeftLeaves(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int sumOfLeftLeaves(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int ans = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null)
				ans += root.left.data;
			else
				ans += sumOfLeftLeaves(root.left);
		}

		ans += sumOfLeftLeaves(root.right);

		return ans;
	}

}
