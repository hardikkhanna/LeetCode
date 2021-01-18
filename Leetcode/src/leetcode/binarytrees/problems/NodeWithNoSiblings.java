/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 18, 2021 Time : 9:34:04 PM
 */
public class NodeWithNoSiblings extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		nodeWithNoSiblings(root);

	}

	/**
	 * @param root
	 */
	private static void nodeWithNoSiblings(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		if (root.left != null && root.right == null)
			System.out.println(root.left.data);
		if (root.left == null && root.right != null)
			System.out.println(root.right.data);
		nodeWithNoSiblings(root.left);
		nodeWithNoSiblings(root.right);

	}

}
