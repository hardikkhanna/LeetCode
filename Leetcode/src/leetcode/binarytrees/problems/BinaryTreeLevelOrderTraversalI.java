/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : Jan 25, 2021 Time : 7:07:24 PM
 */
public class BinaryTreeLevelOrderTraversalI extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		List<List<Integer>> ans = levelOrderTraversal(root);
		for (List<Integer> i : ans) {
			for (int j = 0; j < i.size(); j++) {
				System.out.print(i.get(j) + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @param root
	 * @return
	 */
	private static List<List<Integer>> levelOrderTraversal(BinaryTreeNode<Integer> root) {
		List<List<Integer>> list = new ArrayList<>();
		levelOrderTraversal(list, root, 0);
		return list;
	}

	/**
	 * @param list
	 * @param root
	 * @param i
	 */
	private static void levelOrderTraversal(List<List<Integer>> list, BinaryTreeNode<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelOrderTraversal(list, root.left, level + 1);
		levelOrderTraversal(list, root.right, level + 1);
		list.get(list.size() - level - 1).add(root.data);
	}

}
