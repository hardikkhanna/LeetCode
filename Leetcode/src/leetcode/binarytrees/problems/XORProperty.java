/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 12-Apr-2021 Time : 7:52:26 pm
 */
public class XORProperty extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Boolean check = checkXORProperty(root);
		System.out.println(check);

	}

	/**
	 * @param root
	 * @return
	 */
	private static Boolean checkXORProperty(BinaryTreeNode<Integer> root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		Boolean left = checkXORProperty(root.left);
		if(left == false) return left;
		Boolean right = checkXORProperty(root.right);
		if (root.left != null && root.right != null) {
			if ((root.left.data ^ root.right.data) == root.data)
				return true;
			return false;
		}
		return left && right;
	}

}
