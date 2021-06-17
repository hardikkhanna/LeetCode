/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author Hardik
 * @param <T> the type of elements in this list<br>
 *            Date : 14-Apr-2021 Time : 2:47:53 pm
 */
public class ListArray<T> {

	private Object[] array;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	public ListArray() {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public ListArray(int capacity) {
		if (capacity > 0) {
			this.array = new Object[capacity];
		} else if (capacity == 0) {
			this.array = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Not a Valid capacity " + capacity);
		}
		this.size = 0;
	}

	public void add(T element) {
		if (size == array.length) {
			doubleCapacity();
		}
		this.array[size] = element;
		size++;
	}

	public int getSize() {
		return this.size;

	}

	public boolean isEmpty() {
		return size == 0;

	}

	public int firstIndexOf(T element) {
		if (size == 0)
			throw new IllegalArgumentException("ArrayList id Empty");

		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(element))
				return i;
		}

		return -1;

	}

	public int lastIndexOf(T element) {
		if (size == 0) {
			throw new IllegalArgumentException("ArrayList is Empty");
		}

		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i].equals(element))
				return i;
		}
		return -1;
	}

	public void remove(int index) {
		if (index >= this.size)
			throw new ArrayIndexOutOfBoundsException("Index is out of range " + index);

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		if (index >= size || index < 0)
			throw new IllegalArgumentException("Index " + index + " is out of range");

		return (T) array[index];
	}

	private void doubleCapacity() {
		Object[] temp = Arrays.copyOf(array, size * 2);
		this.array = temp;
	}

}
