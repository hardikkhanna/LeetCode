/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 12-Apr-2021 Time : 10:00:42 am Given a binary tree with N
 *         number of nodes and a node K, you need to find and print a list of
 *         all ancestors of the given node K.
 */

class PairII {
	String path;
	Boolean isFound;

	PairII(String path, Boolean isFound) {
		this.path = path;
		this.isFound = isFound;
	}
}

public class AncestorsOfNode extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int n = sc.nextInt();
		getPath(root, n);
		sc.close();
	}

	/**
	 * @param root
	 */
	private static void getPath(BinaryTreeNode<Integer> root, int k) {
		PairII p = getPathHelper(root, k);
		reverse(p.path.trim());
		// System.out.print(p.path);

	}

	/**
	 * @param path
	 * @return
	 */
	private static void reverse(String path) {
		if (path == null || path.length() == 0)
			return;
		System.out.print(path.charAt(path.length() - 1));
		reverse(path.substring(0, path.length() - 1));
	}

	private static PairII getPathHelper(BinaryTreeNode<Integer> root, int k) {
		if (root == null)
			return new PairII("", false);
		if (root.data == k)
			return new PairII("", true);

		PairII left = getPathHelper(root.left, k);
		if (left.isFound == true) {
			left.path += " " + String.valueOf(root.data);
			return left;
		}
		PairII right = getPathHelper(root.right, k);
		if (right.isFound == true) {
			right.path += " " + String.valueOf(root.data);
		}
		return right;

	}

}
