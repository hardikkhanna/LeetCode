/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 12-Apr-2021 Time : 7:10:22 pm
 */

class PathSum {
	int sum;
	List<Integer> path;

	PathSum(int sum, List<Integer> path) {
		this.sum = sum;
		this.path = path;
	}
}

public class MaximumBinaryTreePath extends BinaryTreeUse {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		long[] ans = printMaximumSumPath(root);
		for(int i  =0;i<ans.length;i++) {
			System.out.print(ans[i] + " ");
		}
	}

	/**
	 * @param root
	 * @return 
	 */
	private static long[] printMaximumSumPath(BinaryTreeNode<Integer> root) {

		PathSum ans = helper(root);
		Collections.reverse(ans.path);
		return ans.path.stream().mapToLong(value -> value).toArray();
	}

	/**
	 * @param root
	 * @return
	 */
	private static PathSum helper(BinaryTreeNode<Integer> root) {
		if (root == null)
			return new PathSum(0, new ArrayList<>());

		PathSum left = helper(root.left);
		PathSum right = helper(root.right);
		List<Integer> list = new ArrayList<Integer>();
		list.add(root.data);
		PathSum output = new PathSum(root.data, list);
		if (left.sum > right.sum) {
			output.sum += left.sum;
			output.path.addAll(left.path);
		} else {
			output.sum += right.sum;
			output.path.addAll(right.path);
		}

		return output;
	}

}
