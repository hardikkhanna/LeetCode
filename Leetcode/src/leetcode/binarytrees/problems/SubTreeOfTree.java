/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : 25-Apr-2021 Time : 6:31:11 pm
 */
public class SubTreeOfTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		BinaryTreeNode<Integer> subTree = takeInputLevelWise();
		Boolean ans = isSubTree(root, subTree);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @param subTree
	 * @return
	 */
	private static Boolean isSubTree(BinaryTreeNode<Integer> T, BinaryTreeNode<Integer> S) {
		if (S == null)
			return true;
		if (T == null)
			return false;
		
		if (T.data == S.data) {
			Boolean left = isSubTree(T.left, S.left);
			Boolean right = isSubTree(T.right, S.right);
			return left && right;
		}

		Boolean left = isSubTree(T.left, S);
		Boolean right = isSubTree(T.right, S);

		return left || right;
	}

}
