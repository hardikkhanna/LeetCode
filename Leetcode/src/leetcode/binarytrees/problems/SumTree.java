/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;

/**
 * @author Hardik
 *
 *         Date : 11-Apr-2021 Time : 3:37:57 pm
 */
public class SumTree extends BinaryTreeUse {

	/**
	 * @param args
	 */

	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		sumTree(root);
		System.out.println(list);
	}

	/**
	 * @param root
	 * @return
	 */
	private static ArrayList<Integer> sumTree(BinaryTreeNode<Integer> root) {
		getSum(root);
		preOrder(root);
		return list;
	}

	/**
	 * @param root
	 * @return
	 */
	private static void getSum(BinaryTreeNode<Integer> root) {
		if(root == null) return;
		if(root.left == null && root.right == null) root.data = 0;
		if(root.left == null && root.right != null) root.data = root.right.data;
		if(root.left != null && root.right == null) root.data = root.left.data;
		if(root.left != null && root.right != null) root.data = root.left.data + root.right.data;
		getSum(root.left);
		getSum(root.right);
	}

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		list.add(root.data);
		preOrder(root.left);
		preOrder(root.right);

	}

}
