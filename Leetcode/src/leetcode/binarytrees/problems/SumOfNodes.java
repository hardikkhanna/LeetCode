/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 18, 2021 Time : 4:10:34 PM
 */
public class SumOfNodes extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int sum = sumOfNodes(root);
		System.out.println(sum);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int sumOfNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int sum = root.data;
		sum += sumOfNodes(root.left);
		sum += sumOfNodes(root.right);
		return sum;
	}

}
