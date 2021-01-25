/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 25, 2021 Time : 1:07:50 PM
 */
public class CheckBinaryTreeIsBST extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Boolean method1 = checkBST(root);
		Boolean method2 = checkBST2(root);
		System.out.println(method1);
		System.out.println(method2);

	}

	/**
	 * @param root
	 * @return
	 */
	private static Boolean checkBST(BinaryTreeNode<Integer> root) {
		Pair<Boolean, Pair<Integer, Integer>> output = checkBSTHelper(root);
		return output.first;
	}

	/**
	 * @param root
	 * @return
	 */
	private static Boolean checkBST2(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;
		int leftMax = getMaximum(root.left);
		int rightMin = getMinimum(root.right);
		if (root.data < leftMax) {
			return false;
		}
		if (root.data > rightMin) {
			return false;
		}
		Boolean isLeftBST = checkBST2(root.left);
		Boolean isRightBST = checkBST2(root.right);
		return isLeftBST && isRightBST;
	}

	/**
	 * @param right
	 * @return
	 */
	private static int getMinimum(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(getMinimum(root.left), getMinimum(root.right)));
	}

	/**
	 * @param left
	 * @return
	 */
	private static int getMaximum(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max(getMaximum(root.left), getMaximum(root.right)));
	}

	/**
	 * @param root
	 * @return
	 */
	private static Pair<Boolean, Pair<Integer, Integer>> checkBSTHelper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
			output.first = true;
			output.second = new Pair<Integer, Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
			return output;
		}
		Pair<Boolean, Pair<Integer, Integer>> leftOutput = checkBSTHelper(root.left);
		Pair<Boolean, Pair<Integer, Integer>> rightOutput = checkBSTHelper(root.right);
		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
		boolean isBST = (root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first)
				&& leftOutput.first && rightOutput.first;
		Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
		output.first = isBST;
		output.second = new Pair<Integer, Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;
	}

}
