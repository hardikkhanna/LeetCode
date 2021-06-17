/**
 * 
 */
package leetcode.stack.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardik
 *
 *         Date : Apr 4, 2021 Time : 11:06:46 AM
 */
public class StackUsingTwoQueues<E> {

	private Queue<E> q1;
	private Queue<E> q2;

	/**
	 * 
	 */
	public StackUsingTwoQueues() {
		q1 = new LinkedList<E>();
		q2 = new LinkedList<E>();
	}

	public int size() {
		return q1.size();
	}

	public boolean isEmpty() {
		return q1.isEmpty();
	}

}
