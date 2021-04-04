/**
 * 
 */
package leetcode.stack.problems;

import leetcode.binarytrees.problems.QueueEmptyException;

/**
 * @author Hardik
 *
 *         Date : Apr 1, 2021 Time : 8:45:47 PM
 */
public class StackUse {

	/**
	 * @param args
	 * @throws StackEmptyException
	 */
	public static void main(String[] args) throws StackEmptyException {
//		StackUsingArray stack = new StackUsingArray();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		System.out.print(stack.pop());
//		System.out.print(stack.pop());
//		System.out.println(stack.top());
//		stack.pop();
//		stack.pop();
//
//		StackUsingLinkedList stack1 = new StackUsingLinkedList();
//		stack1.push(1);
//		stack1.push(2);
//		stack1.push(3);
//		System.out.print(stack1.pop());
//		System.out.print(stack1.pop());
//		System.out.println(stack1.top());
//		stack1.pop();
//		stack1.pop();
		
		QueueUsingArray queue = new QueueUsingArray();
		int[] arr = {10,20,30,40};
		for(int elem : arr) {
			try {
				queue.enqueue(elem);
			} catch (QueueFullException e) {
				e.printStackTrace();
			}
		}
		
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
