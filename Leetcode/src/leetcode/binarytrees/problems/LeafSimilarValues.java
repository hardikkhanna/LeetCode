/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NIPC-43
 *
 *         Date : Jan 16, 2021 Time : 5:16:56 PM
 */
public class LeafSimilarValues extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root1 = takeInputLevelWise();
		BinaryTreeNode<Integer> root2 = takeInputLevelWise();
		Boolean ans = leafSimilar(root1, root2);
		System.out.println(ans);
	}

	/**
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static boolean leafSimilar(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		List<Integer> leaves1 = new ArrayList<>();
		List<Integer> leaves2 = new ArrayList<>();
		dfs(root1, leaves1);
		dfs(root2, leaves2);
		return leaves1.equals(leaves2);
	}

	public static void dfs(BinaryTreeNode<Integer> node, List<Integer> leafValues) {
		if (node != null) {
			if (node.left == null && node.right == null)
				leafValues.add(node.data);
			dfs(node.left, leafValues);
			dfs(node.right, leafValues);
		}
	}

}
