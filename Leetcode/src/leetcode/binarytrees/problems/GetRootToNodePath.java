/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 25, 2021 Time : 6:18:11 PM
 */
public class GetRootToNodePath extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int data = sc.nextInt();
		List<Integer> ans = getRootToNodePath(root, data);
		ans.forEach(i -> System.out.print(ans.get(i) + " "));
		sc.close();
	}

	/**
	 * @param root
	 * @param data
	 * @return
	 */
	private static List<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return null;
		}
		if (root.data == data) {
			List<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
		List<Integer> leftOutput = getRootToNodePath(root.left, data);
		if (leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		List<Integer> rightOutput = getRootToNodePath(root.right, data);
		if (rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		return null;
	}

}
