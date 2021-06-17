/**
 * 
 */
package leetcode.binarytrees.problems;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Jan 18, 2021 Time : 3:17:03 PM
 */
public class CreateTreeFromInrorderAndPostorder extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inorder = get1DArray();
		int[] postorder = get1DArray();
		BinaryTreeNode<Integer> root = getTreeFromPostorderAndInorder(postorder, inorder);
		BinaryTreeUse.printTreeLevelWise(root);

	}

	/**
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in) {

		// Write your code here
		return getTreeFromPostorder(post, in, 0, 0, in.length - 1, post.length - 1);
	}

	/**
	 * @param post
	 * @param in
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 * @return
	 */
	private static BinaryTreeNode<Integer> getTreeFromPostorder(int[] post, int[] in, int ins, int posts, int ine,
			int poste) {

		if (posts > poste) {
			return null;
		}
		int rootData = post[poste];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int i = ins;
		int rootindex = -1;
		while (i <= ine) {
			if (in[i] == rootData) {
				rootindex = i;
				break;
			}
			i++;
		}
		if (rootindex == -1)
			return null;
		int lins = ins;
		int line = rootindex - 1;
		int rins = rootindex + 1;
		int rine = ine;

		int lposts = posts;
		int lposte = lposts + line - lins;
		int rposts = lposte + 1;
		int rposte = poste - 1;

		root.left = getTreeFromPostorder(post, in, lins, lposts, line, lposte);
		root.right = getTreeFromPostorder(post, in, rins, rposts, rine, rposte);
		return root;

	}

}
