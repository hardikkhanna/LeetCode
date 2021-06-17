/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 13, 2021 Time : 5:40:49 PM
 */
public class MergeTwoBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> t1 = takeInputLevelWise();
		BinaryTreeNode<Integer> t2 = takeInputLevelWise();
		t1 = mergeTrees(t1, t2);
		printTreeLevelWise(t1);

	}

	/**
	 * @param t1
	 * @param t2
	 * @return
	 */
	private static BinaryTreeNode<Integer> mergeTrees(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		t1.data += t2.data;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}

}
