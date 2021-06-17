/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 28-Apr-2021 Time : 10:40:55 am
 */
public class BinaryTreePruning extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		root = binaryTreePruning(root);
		printTreeLevelWise(root);

	}

	/**
	 * @param root
	 * @return
	 */
	private static BinaryTreeNode<Integer> binaryTreePruning(BinaryTreeNode<Integer> root) {
		// Write your code here.
		if (root == null) {
			return null;
		}

		root.left = binaryTreePruning(root.left);
		root.right = binaryTreePruning(root.right);

		if (root.left == null && root.right == null && root.data != 1) {
			return null;
		}
		return root;	
	}

}
