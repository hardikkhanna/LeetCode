/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 16, 2021 Time : 4:59:26 PM
 */
public class IsUnivalTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Boolean ans = isUnivalTree(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	private static Boolean isUnivalTree(BinaryTreeNode<Integer> root) {
		boolean left_correct = (root.left == null || (root.data == root.left.data && isUnivalTree(root.left)));
		boolean right_correct = (root.right == null || (root.data == root.right.data && isUnivalTree(root.right)));
		return left_correct && right_correct;
	}

}
