/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 22, 2021 Time : 12:54:21 PM
 */
public class ConstructStringFromBST extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		String str = tree2str(root);
		System.out.println(str);

	}

	/**
	 * @param root
	 * @return
	 */
	public static String tree2str(BinaryTreeNode<Integer> t) {
		StringBuilder builder = new StringBuilder();
		tree2StrHelper(t, builder);
		return builder.toString();
	}

	private static void tree2StrHelper(BinaryTreeNode<Integer> t, StringBuilder builder) {
		if (t == null) {
			return;
		}

		builder.append(t.data);
		if (t.left != null) {
			builder.append("(");
			tree2StrHelper(t.left, builder);
			builder.append(")");
		}

		if (t.right != null) {
			if (t.left == null) {
				builder.append("()");
			}

			builder.append("(");
			tree2StrHelper(t.right, builder);
			builder.append(")");
		}
	}
}
