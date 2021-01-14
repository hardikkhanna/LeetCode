/**
 * 
 */
package leetcode.binarytrees.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 13, 2021 Time : 4:37:03 PM
 */
public class RangeSumBST extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int low = sc.nextInt();
		int high = sc.nextInt();
		int ans = rangeSumBST(root, low, high);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param root
	 * @param low
	 * @param high
	 * @return
	 */
	private static int rangeSumBST(BinaryTreeNode<Integer> root, int low, int high) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.data >= low && root.data <= high) {
			sum =  root.data;
		}
		
		sum += rangeSumBST(root.left, low, high);
		sum += rangeSumBST(root.right, low, high);
		return sum;
	}

}