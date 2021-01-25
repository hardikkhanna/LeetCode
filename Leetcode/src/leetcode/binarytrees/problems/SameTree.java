/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 25, 2021 Time : 9:26:04 PM
 */
public class SameTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> p = takeInputLevelWise();
		BinaryTreeNode<Integer> q = takeInputLevelWise();
		Boolean ans = isSameTree(p, q);
		System.out.println(ans);
	}

	/**
	 * @param p
	 * @param q
	 * @return
	 */
	private static Boolean isSameTree(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
		if (p == null && q == null)
			return true;
		if (p == null)
			return false;
		if (q == null)
			return false;
		Boolean ans = true;
		if (p.data != q.data) {
			return false;
		}
		ans = isSameTree(p.left, q.left);
		if (!ans)
			return false;
		ans = isSameTree(p.right, q.right);
		return ans;
	}
}
