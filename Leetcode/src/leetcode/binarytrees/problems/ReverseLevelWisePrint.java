/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardik
 *
 *         Date : 29-Apr-2021 Time : 2:39:56 pm
 */
public class ReverseLevelWisePrint extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int t = 3;
		while (t-- > 0) {
			BinaryTreeNode<Integer> root = takeInputLevelWise();
			printTreeHelper(root);
		}
	}

	/**
	 * @param root
	 */
	private static void printTreeHelper(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;

		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			BinaryTreeNode<Integer> node = q.poll();
			System.out.print(node.data + " ");
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}
}
