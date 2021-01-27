/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 27, 2021 Time : 5:25:20 PM
 */
public class SymmetricTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Boolean ans = isSymmetric(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	private static Boolean isSymmetric(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> mirrorTree = getMirrorTreeFromRoot(root);
		return isSymmetric(root, mirrorTree);
	}

	/**
	 * @param root
	 * @param mirrorTree
	 * @return
	 */
	private static Boolean isSymmetric(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> mirrorTree) {
		// Base cond if nodes in both are null
		if (root == null && mirrorTree == null) {
			return true;
		}
		// Base Case 2 : if root is null but mirrorTree node is not null
		if (root == null) {
			return false;
		}
		if (mirrorTree == null)
			return false;

		// create a var to store the results
		Boolean ans = true;
		if (root.data != mirrorTree.data)
			return false;
		ans = isSymmetric(root.left, mirrorTree.left);
		ans = isSymmetric(root.right, mirrorTree.right);
		return ans;
	}

	/**
	 * @param root
	 * @return
	 */
	private static BinaryTreeNode<Integer> getMirrorTreeFromRoot(BinaryTreeNode<Integer> root) {
		// check Base Case
		if (root == null)
			return null;
		// Create a Node against root node
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(root.data);
		// Insert left of root node to right of created node and vice-versa
		node.left = getMirrorTreeFromRoot(root.right);
		node.right = getMirrorTreeFromRoot(root.left);
		return node;
	}

}
