/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hardik
 *
 *         Date : Mar 21, 2021 Time : 7:45:31 AM
 */
public class PreOrderTraversal extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		List<Integer> res = preOrderTraversal(root);
		System.out.println(res);
	}

	/**
	 * @param root
	 * @return
	 */
	private static List<Integer> preOrderTraversal(BinaryTreeNode<Integer> root) {
		List<Integer> ret = new ArrayList<>();
		preOrderRec(root, ret);
		preOrderIterative(root, ret);
		return ret;
	}

	/**
	 * @param root
	 * @param ret
	 */
	private static void preOrderIterative(BinaryTreeNode<Integer> root, List<Integer> ret) {
		if (root == null)
			return;
		Stack<BinaryTreeNode<Integer>> st = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			BinaryTreeNode<Integer> temp = st.pop();
			ret.add(temp.data);
			if (temp.right != null)
				st.push(temp.right);
			if (temp.left != null)
				st.push(temp.left);
		}
	}

	/**
	 * @param root
	 * @param ret
	 */
	private static void preOrderRec(BinaryTreeNode<Integer> root, List<Integer> ret) {
		if (root == null)
			return;
		ret.add(root.data);
		preOrderRec(root.left, ret);
		preOrderRec(root.right, ret);

	}

}
