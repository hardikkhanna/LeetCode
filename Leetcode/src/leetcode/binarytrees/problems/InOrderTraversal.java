/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author NIPC-43
 *
 *         Date : Mar 21, 2021 Time : 7:28:17 AM
 */
public class InOrderTraversal extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		List<Integer> list = inOrderTraversale(root);
		System.out.println(list);

	}

	/**
	 * @param root
	 * @return
	 */
	private static List<Integer> inOrderTraversale(BinaryTreeNode<Integer> root) {
		List<Integer> ret = new ArrayList<>();
		// Approach 1 using Recursion
		// inOrder(root, ret);

		// Approach 2 Iterative using Stack
		inOrderIterative(root, ret);
		return ret;
	}

	/**
	 * @param root
	 * @param ret
	 */
	private static void inOrderIterative(BinaryTreeNode<Integer> root, List<Integer> ret) {
		Stack<BinaryTreeNode<Integer>> st = new Stack<>();
		BinaryTreeNode<Integer> temp = root;
		while (temp != null || !st.isEmpty()) {
			while (temp != null) {
				st.push(temp);
				temp = temp.left;
			}
			temp = st.pop();
			ret.add(temp.data);
			temp = temp.right;
		}
	}

	/**
	 * @param root
	 * @param ret
	 */
	// Recursively call inOrder on left tree add the root and then call resrsion on
	// right subtree
	private static void inOrder(BinaryTreeNode<Integer> root, List<Integer> ret) {
		if (root == null)
			return;
		inOrder(root.left, ret);
		ret.add(root.data);
		inOrder(root.right, ret);

	}

}
