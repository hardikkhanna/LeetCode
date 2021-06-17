/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardik
 *
 *         Date : 28-Apr-2021 Time : 5:53:39 pm
 */
public class MaximumWidth extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();

		// Appoach 1
		int maxWidth = getMaxWidth(root);
		System.out.println(maxWidth);

		// Approach 2
		maxWidth = getMaxWidthBetter(root);
		System.out.println(maxWidth);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int getMaxWidthBetter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		helper(root, map, 1);

		int maxWidth = 0;
		for (Integer i : map.values()) {
			maxWidth = Math.max(maxWidth, i);
		}
		return maxWidth;
	}

	/**
	 * @param root
	 * @param map
	 */
	private static void helper(BinaryTreeNode<Integer> root, HashMap<Integer, Integer> map, int level) {
		if (root == null) {
			return;
		}

		if (map.containsKey(level)) {
			map.put(level, map.get(level) + 1);
		} else {
			map.put(level, 1);
		}

		helper(root.left, map, level + 1);
		helper(root.right, map, level + 1);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int getMaxWidth(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		int maxWidth = 0;
		while (!queue.isEmpty()) {

			maxWidth = Math.max(maxWidth, queue.size());
			// Push all the children of the root node which are at the current level
			while (queue.size() > 0) {
				// Get the front of queue
				BinaryTreeNode<Integer> currNode = queue.peek();
				queue.poll();

				// Push left child of currNode if exist
				if (currNode.left != null) {
					queue.add(currNode.left);
				}

				// Push right child of currNode if exist
				if (currNode.right != null) {
					queue.add(currNode.right);
				}

			}
		}
		return maxWidth;
	}

}
