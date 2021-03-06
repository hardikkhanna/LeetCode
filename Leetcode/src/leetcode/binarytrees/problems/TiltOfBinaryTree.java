/**
 * 
 */
package leetcode.binarytrees.problems;

class TiltPair {

	int tilt;
	int sum;
}

/**
 * @author Hardik
 *
 *         Date : 25-Apr-2021 Time : 5:39:54 pm
 */
public class TiltOfBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */

	static int sum = 0;

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int tilt = getTilt(root);
		System.out.println(tilt);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int getTilt(BinaryTreeNode<Integer> root) {
		TiltPair ans = getTiltHelper(root);
		return sum;
	}

	/**
	 * @param root
	 * @return
	 */
	private static TiltPair getTiltHelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return new TiltPair();
		}

		TiltPair left = getTiltHelper(root.left);
		TiltPair right = getTiltHelper(root.right);

		TiltPair output = new TiltPair();
		output.tilt = Math.abs(left.sum - right.sum);
		output.sum = left.sum + right.sum + root.data;
		sum += output.tilt;
		return output;
	}

}
