/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 28-Apr-2021 Time : 10:08:57 pm
 */
public class ReverseLevelOrderTraversal extends BinaryTreeUse {

	/**
	 * @param args
	 */

	static List<List<Integer>> list;

	public static ArrayList<Integer> reverseLevelOrder(BinaryTreeNode<Integer> root) {
		// Write your code here
		list = new ArrayList<>();
		helper(root, 1);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = list.size() - 1; i >= 0; i--) {
			ans.addAll(list.get(i));
		}
		return ans;
	}

	private static void helper(BinaryTreeNode<Integer> root, int level) {
		if (root == null)
			return;

		if (level > list.size()) {
			List<Integer> node = new ArrayList<Integer>();
			node.add(root.data);
			list.add(node);
		} else {
			list.get(level - 1).add(root.data);
		}

		helper(root.right, level + 1);
		helper(root.left, level + 1);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		ArrayList<Integer> list = reverseLevelOrder(root);
		System.out.println(list);
		list = better(root);
		System.out.println(list);
	}

	/**
	 * @param root
	 * @return
	 */
	static HashMap<Integer, ArrayList<Integer>> map;

	private static ArrayList<Integer> better(BinaryTreeNode<Integer> root) {
		map = new HashMap<>();

		helperfunc(root, 1);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i : map.keySet()) {
			ans.addAll(map.get(i));
		}
		Collections.reverse(ans);
		return ans;
	}

	/**
	 * @param root
	 * @param i
	 */
	private static void helperfunc(BinaryTreeNode<Integer> root, int level) {
		if (root == null)
			return;

		if (level > map.size()) {
			ArrayList<Integer> node = new ArrayList<>();
			node.add(root.data);
			map.put(level, node);
		} else {
			map.get(level).add(0 , root.data);
		}

		helperfunc(root.right, level + 1);
		helperfunc(root.left, level + 1);

	}

}
