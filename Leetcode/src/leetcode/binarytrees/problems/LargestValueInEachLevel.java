/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Hardik
 *
 *         Date : Mar 19, 2021 Time : 11:25:27 AM
 */
public class LargestValueInEachLevel extends BinaryTreeUse {

	static HashMap<Integer, Integer> map = new HashMap<>();

	public static ArrayList<Integer> largestValues(BinaryTreeNode<Integer> root) {
		int level = 1;
		ArrayList<Integer> res = new ArrayList<>();
		largestValues(root, level, res);
		for (int i : map.keySet()) {
			res.add(map.get(i));
		}
		return res;
	}

	/**
	 * @param root
	 * @param level
	 * @param res
	 */
	private static void largestValues(BinaryTreeNode<Integer> root, int level, ArrayList<Integer> res) {
		if (root == null)
			return;

		// Expand list size
		if (level == res.size())
			res.add(root.data);

		else

			// to ensure largest value
			// on level is being stored
			res.set(level, Math.max(res.get(level), root.data));

		// Recursively traverse left and
		// right subtrees in order to find
		// out the largest value on each level
		largestValues(root.left, level + 1, res);
		largestValues(root.right, level + 1, res);

	}

	// Main Idea is
//	private static void largestValues(BinaryTreeNode<Integer> root, int level, ArrayList<Integer> res) {
//
//		if (root == null)
//			return;
//		if (map.containsKey(level)) {
//			int val = map.get(level);
//			map.put(level, Math.max(val, root.data));
//		} else {
//			map.put(level, root.data);
//		}
//		largestValues(root.left, level + 1, res);
//		largestValues(root.right, level + 1, res);
//
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		ArrayList<Integer> res = largestValues(root);
		System.out.println(res);
	}

}
