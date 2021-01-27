/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 27, 2021 Time : 12:06:10 PM
 */
public class CousinsInBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */

	static BinaryTreeNode<Integer> xParent = null;
	static BinaryTreeNode<Integer> yParent = null;
	static int xDepth = -1;
	static int yDepth = -2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int x = sc.nextInt();
		int y = sc.nextInt();
		Boolean ans = isCousins(root, x, y);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param root
	 * @param x
	 * @param y
	 * @return
	 */
	private static Boolean isCousins(BinaryTreeNode<Integer> root, int x, int y) {

		dfs(root, null, x, y, 0);
		return xDepth == yDepth && xParent != yParent;
	}

	/**
	 * @param root
	 * @param object
	 * @param x
	 * @param y
	 * @param i
	 */
	private static void dfs(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> parent, int x, int y, int depth) {
		if (root == null)
			return;
		if (x == root.data) {
			xParent = parent;
			xDepth = depth;
		} else if (y == root.data) {
			yParent = parent;
			yDepth = depth;
		} else {
			// if we found x node or found y node then we don't need to dfs deeper
			// because x and y must be the same depth
			dfs(root.left, root, x, y, depth + 1);
			dfs(root.right, root, x, y, depth + 1);
		}
	}

}
