/**
 * 
 */
package leetcode.stack.problems;

/**
 * @author Hardik
 *
 *         Date : Apr 1, 2021 Time : 8:43:31 PM
 */
public class StackUsingArray {

	private int[] data;
	private int topElement;

	/**
	 * 
	 */
	public StackUsingArray() {
		data = new int[10];
		topElement = -1;
	}

	public int size() {
		return topElement + 1;
	}

	public boolean isEmpty() {
		return topElement >= 0;
	}

	public void push(int element) {
		if (topElement == data.length) {
			doubleCapacity();
		}
		data[++topElement] = element;
	}

	public int top() throws StackEmptyException {
		if (topElement == -1) {
			throw new StackEmptyException();
		}
		return data[topElement];
	}

	public int pop() throws StackEmptyException {
		if (topElement == -1) {
			throw new StackEmptyException();
		}
		int top = data[topElement--];
		return top;
	}

	private void doubleCapacity() {
		int[] temp = new int[2 * data.length];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
}
