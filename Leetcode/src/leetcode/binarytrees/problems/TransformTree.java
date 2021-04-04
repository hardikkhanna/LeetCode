/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Mar 19, 2021 Time : 7:01:32 PM
 */
public class TransformTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	static int sum = 0;

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		transformData(root);
		inorder(root);

	}

	/**
	 * @param root
	 */
	private static void transformData(BinaryTreeNode<Integer> root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		transformData(root.right);
		int data = root.data;
		root.data = sum;
		sum += data;
		transformData(root.left);
	}

}
