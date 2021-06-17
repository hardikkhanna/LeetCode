/**
 * 
 */
package leetcode.binarytrees.problems;

class Depth{
	int minDepth;
	int maxDepth;
	
	Depth(int minDepth, int maxDepth){
		this.minDepth = minDepth;
		this.maxDepth = maxDepth;
	}
}
/**
 * @author Hardik
 *
 * Date : 12-Apr-2021
 * Time : 7:44:18 pm
 */
public class MinDepth extends BinaryTreeUse{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int minDepth = getMinDepth(root);
		int depth = getDepth(root);
		System.out.println(depth);
		System.out.println(minDepth);

	}

	/**
	 * @param root
	 * This function calculates the minimum and maximum Depth of a binary tree
	 * @return minimum Depth of binary tree
	 */
	private static int getDepth(BinaryTreeNode<Integer> root) {
		Depth dep = getMinAndMaxDepth(root);
		return dep.minDepth;
	}

	/**
	 * @param root
	 * @return
	 */
	private static Depth getMinAndMaxDepth(BinaryTreeNode<Integer> root) {
		if(root == null) return new Depth(0,0);
		
		Depth left = getMinAndMaxDepth(root.left);
		Depth right = getMinAndMaxDepth(root.right);
		int min = 0;
		if(left.minDepth != 0 && right.minDepth != 0) {
			min = Math.min(left.minDepth, right.minDepth) + 1;
		}else if(left.minDepth != 0) {
			min = left.minDepth + 1;
		}else if(right.minDepth != 0) {
			min = right.minDepth + 1;
		}else {
			min = 1;
		}
		int max = Math.max(left.maxDepth,right.maxDepth) + 1;
		Depth output = new Depth(min, max);
		
		return output;
	}

	/**
	 * @param root
	 * @return
	 */
	private static int getMinDepth(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		
		if(root.left == null) return  getMinDepth(root.right) + 1;
		if(root.right == null) return getMinDepth(root.left) + 1;
		return Math.min(getMinDepth(root.left), getMinDepth(root.right)) + 1;
	}

}
 