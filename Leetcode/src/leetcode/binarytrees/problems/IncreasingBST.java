/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 14, 2021 Time : 11:18:25 PM
 */
public class IncreasingBST extends BinaryTreeUse {

	/**
	 * @param args
	 */

	static BinaryTreeNode<Integer> cur;

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		root = increasingBST(root);
		printTreeLevelWise(root);

	}

	/**
	 * @param root
	 * @return
	 */
	private static BinaryTreeNode<Integer> increasingBST(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> ans = new BinaryTreeNode<Integer>(0);
		cur = ans;
		inorder(root);
		return ans.right;
	}

	/**
	 * @param root
	 */
	private static void inorder(BinaryTreeNode<Integer> node) {
		if (node == null)
			return;
		inorder(node.left);
		node.left = null;
		cur.right = node;
		cur = node;
		inorder(node.right);

	}

}
