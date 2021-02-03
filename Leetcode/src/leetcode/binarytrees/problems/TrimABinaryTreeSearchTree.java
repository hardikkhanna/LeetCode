/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 20, 2021 Time : 5:37:30 PM
 */
public class TrimABinaryTreeSearchTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int low = 3;
		int high = 4;

		root = trimBST(root, low, high);
		printTreeLevelWise(root);
	}

	/**
	 * @param root
	 * @param high
	 * @param low
	 * @return
	 */
	private static BinaryTreeNode<Integer> trimBST(BinaryTreeNode<Integer> root, int L, int R) {
//		if (root == null) {
//			return null;
//		}
//		if (root.data >= L && root.data <= R) {
//			root.left = trimBST(root.left, L, R);
//			root.right = trimBST(root.right, L, R);
//		} else if (root.data < L) {
//			root = trimBST(root.right, L, R);
//		} else if (root.data > R) {
//			root = trimBST(root.left, L, R);
//		}
//		return root;

		if (root == null) {
			return null;
		}
		if (root.data < L) {
			return trimBST(root.right, L, R);
		}
		if (root.data > R) {
			return trimBST(root.left, L, R);
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}

}
