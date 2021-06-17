/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 11-Apr-2021 Time : 5:36:13 pm
 */
public class BoundaryTraversal extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		solve(root);

	}

	/**
	 * @param root
	 */
	public static void solve(BinaryTreeNode<Integer> root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");

		printLeftBoundary(root.left);

		printLeaves(root.left);
		printLeaves(root.right);

		printRightBoundary(root.right);

	}

	private static void printLeftBoundary(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		if (root.left != null) {
			System.out.print(root.data + " ");
			printLeftBoundary(root.left);
		} else if (root.right != null) {
			System.out.print(root.data + " ");
			printLeftBoundary(root.right);
		}

	}

	private static void printRightBoundary(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		if (root.right != null) {
			printRightBoundary(root.right);
			System.out.print(root.data + " ");
		} else if (root.left != null) {
			printRightBoundary(root.left);
			System.out.print(root.data + " ");
		}
	}

	private static void printLeaves(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		printLeaves(root.left);
		if (root.left == null && root.right == null)
			System.out.print(root.data + " ");
		printLeaves(root.right);
	}

}
