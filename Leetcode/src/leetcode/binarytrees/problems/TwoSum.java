/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 22, 2021 Time : 12:33:07 PM
 */
public class TwoSum extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int k = 9;
		Boolean ans = findTarget(root, k);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @param k
	 * @return
	 */
	private static Boolean findTarget(BinaryTreeNode<Integer> root, int k) {
		if (root == null)
			return false;

		return null;
	}

}
