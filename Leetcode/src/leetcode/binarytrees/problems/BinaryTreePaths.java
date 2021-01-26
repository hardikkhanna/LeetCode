/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : Jan 26, 2021 Time : 12:45:22 PM
 */
public class BinaryTreePaths extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		List<String> ans = binaryTreePaths(root);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + ",");
		}
	}

	/**
	 * @param root
	 * @return
	 */
	private static List<String> binaryTreePaths(BinaryTreeNode<Integer> root) {
		List<String> rst = new ArrayList<String>();
		if (root == null)
			return rst;
		StringBuilder sb = new StringBuilder();
		helper(rst, sb, root);
		return rst;
	}

	/**
	 * @param rst
	 * @param sb
	 * @param root
	 */
	private static void helper(List<String> rst, StringBuilder sb, BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		int tmp = sb.length();
		if (root.left == null && root.right == null) {
			sb.append(root.data);
			rst.add(sb.toString());
			sb.delete(tmp, sb.length());
			return;
		}
		sb.append(root.data + "->");
		helper(rst, sb, root.left);
		helper(rst, sb, root.right);
		sb.delete(tmp, sb.length());

	}

}
