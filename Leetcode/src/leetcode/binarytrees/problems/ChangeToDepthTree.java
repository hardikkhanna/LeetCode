/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 * Date : 12-Apr-2021
 * Time : 10:34:38 pm
 */
public class ChangeToDepthTree extends BinaryTreeUse{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		changeToDepthTree(root);
		printTreeLevelWise(root);
	}

	/**
	 * @param root
	 */
	private static void changeToDepthTree(BinaryTreeNode<Integer> root) {
		if(root == null) return;
		changeToDepthTree(root, 1);
		
	}

	/**
	 * @param root node of the BinaryTree
	 * @param level of a particular node in  BinaryTree
	 */
	private static void changeToDepthTree(BinaryTreeNode<Integer> root, int level) {
		if(root == null) return;
		root.data = level;
		changeToDepthTree(root.left,level + 1);
		changeToDepthTree(root.right, level + 1);
	}
	
	

}
 