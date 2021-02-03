/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 28, 2021 Time : 10:23:15 PM
 */
public class SubTreeOfAnotherTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		BinaryTreeNode<Integer> root2 = takeInputLevelWise();
		Boolean ans = isSubtree(root, root2);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @param root2
	 * @return
	 */
	public static boolean isSubtree(BinaryTreeNode<Integer> s, BinaryTreeNode<Integer> t) {
		if (s == null)
			return false;
		if (isSame(s, t))
			return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private static boolean isSame(BinaryTreeNode<Integer> s, BinaryTreeNode<Integer> t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;

		if (s.data != t.data)
			return false;

		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}

}
