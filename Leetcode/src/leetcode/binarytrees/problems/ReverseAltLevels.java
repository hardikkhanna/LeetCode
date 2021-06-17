/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 11-Apr-2021 Time : 4:12:12 pm
 */
public class ReverseAltLevels extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		reverseAltLevels(root);
		inorder(root);

	}

	/**
	 * @param root
	 */
	private static void reverseAltLevels(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		preOrder(root.left, root.right, 1);

	}

	/**
	 * @param left
	 * @param right
	 * @param i
	 */
	private static void preOrder(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2, int level) {
			if (root1 == null || root2 == null)
				return;
			if (level % 2 != 0) {
				int temp = root1.data;
				root1.data = root2.data;
				root2.data = temp;
			}
			preOrder(root1.left, root2.right, level + 1);
			preOrder(root1.right, root2.left, level + 1);
	}

}
