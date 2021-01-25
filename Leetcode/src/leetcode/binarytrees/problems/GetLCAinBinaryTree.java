/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 25, 2021 Time : 6:54:40 PM
 */
public class GetLCAinBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ans = getLCA(root, a, b);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
	private static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		if (root == null) {
			return -1;
		}
		if (root.data == a || root.data == b) {
			return root.data;
		}
		int n1 = getLCA(root.left, a, b);
		int n2 = getLCA(root.right, a, b);
		if (n1 == -1 && n2 == -1) {
			return -1;
		} else if (n1 == -1) {
			return n2;
		} else if (n2 == -1) {
			return n1;
		}

		return root.data;
	}

}
