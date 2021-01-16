/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 15, 2021 Time : 8:40:27 PM
 */
public class SumRootToLeaf extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int ans = sumRootToLeaf(root);
		System.out.println(ans);
	}

	/**
	 * @param root
	 * @return
	 */
	public static int sumRootToLeaf(BinaryTreeNode<Integer> root) {
		return sumRootToLeaf(root, 0);
	}

	public static int sumRootToLeaf(BinaryTreeNode<Integer> root, int val) {
		if (root == null)
			return 0;
		val = val * 2 + root.data;
		if (root.left == root.right)
			return val;
		return sumRootToLeaf(root.left, val) + sumRootToLeaf(root.right, val);
	}

}
