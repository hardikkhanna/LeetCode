/**
 * 
 */
package leetcode.binarytrees.problems;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Jan 18, 2021 Time : 1:42:32 PM
 */
public class CreateBinaryTreeFromInorderPreOrder extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inorder = get1DArray();
		int[] preorder = get1DArray();
		BinaryTreeNode<Integer> root = createTree(inorder, preorder);
		new BinaryTreeUse();
		BinaryTreeUse.printTreeLevelWise(root);

	}

	/**
	 * @param inorder
	 * @param preorder
	 * @return
	 */
	private static BinaryTreeNode<Integer> createTree(int[] inorder, int[] preorder) {
		return createTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length);
	}

	/**
	 * @param inorder
	 * @param SI
	 * @param SE
	 * @param preorder
	 * @param PS
	 * @param PE
	 * @return
	 */
	private static BinaryTreeNode<Integer> createTree(int[] inorder, int inSI, int inEI, int[] preorder, int preSI,
			int preEI) {
		if (inSI > inEI)
			return null;
		int rootData = preorder[preSI];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		int rootIndex = -1;
		for (int i = inSI; i <= inEI; i++) {
			if (rootData == inorder[i]) {
				rootIndex = i;
				break;
			}
		}
		int leftInS = inSI;
		int leftInE = rootIndex - 1;
		int leftPreS = preSI + 1;
		int leftPreE = leftInE - leftInS + leftPreS;
		int rightPreS = leftPreE + 1;
		int rightPreE = preEI;
		int rightInS = rootIndex + 1;
		int rightInE = inEI;
		root.left = createTree(inorder, leftInS, leftInE, preorder, leftPreS, leftPreE);
		root.right = createTree(inorder, rightInS, rightInE, preorder, rightPreS, rightPreE);
		return root;
	}

}
