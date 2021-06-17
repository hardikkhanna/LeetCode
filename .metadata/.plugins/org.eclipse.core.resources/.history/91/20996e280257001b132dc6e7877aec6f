/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 15, 2021 Time : 11:35:41 AM
 */
public class DiameterOfBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int ans = findDiameter(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	public static int findDiameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}

		int option1 = height(root.left) + height(root.right);
		int option2 = findDiameter(root.left);
		int option3 = findDiameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}

	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}

	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Integer, Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer, Integer> lo = heightDiameter(root.left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		int height = 1 + Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1, Math.max(option2, option3));
		Pair<Integer, Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}

}
