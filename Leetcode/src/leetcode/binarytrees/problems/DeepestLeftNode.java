/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 11-Apr-2021 Time : 9:06:03 pm
 */
public class DeepestLeftNode extends BinaryTreeUse {

	/**
	 * @param args
	 */
	private static int maxLevel = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			BinaryTreeNode<Integer> root = takeInputLevelWise();
			int ans = deepestLeft(root);
			System.out.println(ans);
		}
		sc.close();
	}

	/**
	 * @param root
	 * @return
	 */
	private static int deepestLeft(BinaryTreeNode<Integer> root) {
		maxLevel = 0;
		return deepestLeft(root, 0, false);
	}

	/**
	 * @param root
	 * @param i
	 * @param b
	 * @return
	 */
	private static int deepestLeft(BinaryTreeNode<Integer> root, int level, Boolean isLeft) {
		if (root == null)
			return 0;

		int ans = 0;

		if (isLeft != false && root.left == null && root.right == null && level >= maxLevel && ans < root.data) {
			maxLevel = level;
			ans = root.data;
		}

		ans = Math.max(ans, deepestLeft(root.left, level + 1, true));
		ans = Math.max(ans, deepestLeft(root.right, level + 1, false));
		return ans;
	}

}
