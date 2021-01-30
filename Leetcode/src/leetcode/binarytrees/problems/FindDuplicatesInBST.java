/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hardik
 *
 *         Date : Jan 28, 2021 Time : 10:30:12 PM
 */
public class FindDuplicatesInBST extends BinaryTreeUse {

	/**
	 * @param args
	 */
	static int max = 0;

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int[] ans = findMode(root);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	/**
	 * @param root
	 * @return
	 */
	public static int[] findMode(BinaryTreeNode<Integer> root) {
		if (root == null)
			return new int[0];
		Map<Integer, Integer> map = new LinkedHashMap<>();
		traverse(root, map);

		List<Integer> res = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				res.add(key);
			}
		}

		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}

		return result;
	}

	private static void traverse(BinaryTreeNode<Integer> root, Map<Integer, Integer> map) {
		if (root == null)
			return;

		Integer value = map.getOrDefault(root.data, 0) + 1;
		max = Math.max(max, value);
		map.put(root.data, value);

		traverse(root.left, map);
		traverse(root.right, map);
	}

}
