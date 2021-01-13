/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 13, 2021 Time : 8:05:11 AM
 */
public class FinNodeInBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int x = sc.nextInt();
		Boolean ans = isNodePresent(root, x);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param root
	 * @param x
	 * @return
	 */
	private static Boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		if (root == null)
			return false;
		if (root.data == x)
			return true;
		boolean ans = false;
		ans = isNodePresent(root.left, x);
		if (ans)
			return true;
		ans = isNodePresent(root.right, x);
		return ans;
	}

}
