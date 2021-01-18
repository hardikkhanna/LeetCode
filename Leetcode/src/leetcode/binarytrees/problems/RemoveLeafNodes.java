/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 18, 2021 Time : 5:00:51 PM
 */
public class RemoveLeafNodes extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		root = removeAllLeaves(root);
		printTreeLevelWise(root);

	}

	/**
	 * @param root
	 * @return
	 */
	private static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return null;
		}
		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);
		return root;
	}

}
