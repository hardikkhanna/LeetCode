/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 14, 2021 Time : 11:15:07 PM
 */
public class SearchBST extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int val = 2;
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		root = searchBST(root, val);
		printTreeLevelWise(root);

	}

	/**
	 * @param root
	 * @param val
	 * @return
	 */
	private static BinaryTreeNode<Integer> searchBST(BinaryTreeNode<Integer> root, int val) {
		if (root == null) {
			return null;
		}
		if (root.data == val) {
			return root;
		}
		BinaryTreeNode<Integer> found = searchBST(root.left, val);
		if (found != null)
			return found;
		found = searchBST(root.right, val);
		return found;
	}

}
