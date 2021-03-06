/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 09-Apr-2021 Time : 7:05:15 pm
 */
public class PathSumRootTok {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		int k = sc.nextInt();
		rootToLeafPathsSumToK(root, k);
		sc.close();
	}

	/**
	 * @param root
	 * @param k
	 */
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int sum) {
		rootToLeafPathsSumToK(root, sum, "", 0);
	}

	private static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String path, int currSum) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			currSum += root.data;

			if (currSum == k) {
				System.out.println(path + String.valueOf(root.data) + " ");
			}
			return;
		}
		path = path + String.valueOf(root.data) + " ";
		currSum = currSum + root.data;
		rootToLeafPathsSumToK(root.left, k, path, currSum);
		rootToLeafPathsSumToK(root.right, k, path, currSum);
	}

}
