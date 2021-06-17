/**
 * 
 */
package leetcode.priorityQueue.problems;

import java.util.ArrayList;

/**
 * @author Hardik
 *
 *         Date : 07-May-2021 Time : 4:10:42 pm
 */
public class MaxHeap {

	private ArrayList<Integer> heap;

	/**
	 * 
	 */
	public MaxHeap() {
		heap = new ArrayList<Integer>();
	}

	public boolean isEmpty() {
		return heap.size() == 0;
	}

	public int getSize() {
		return heap.size();
	}

	public int getMax() throws PrioritQueueException {
		if (heap.size() == 0) {
			throw new PrioritQueueException();
		}
		return heap.get(0);
	}

	public void insert(int element) {
		heap.add(element);

		// Heapify

		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {

			if (heap.get(parentIndex) < heap.get(childIndex)) {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(childIndex));
				heap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}

		}

	}

	public int removeMax() throws PrioritQueueException {
		if (heap.size() == 0) {
			throw new PrioritQueueException();

		}
		int temp = heap.get(0);

		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int index = 0;
		int minIndex = index;
		int leftChild = 2 * minIndex + 1;
		int rightChild = 2 * minIndex + 2;

		// Heapify

		while (leftChild < heap.size()) {

			if (heap.get(minIndex) < heap.get(leftChild)) {
				minIndex = leftChild;
			}
			if (rightChild < heap.size() && heap.get(minIndex) < heap.get(rightChild)) {
				minIndex = rightChild;
			}

			if (minIndex == index) {
				break;
			} else {
				int var = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, var);
				index = minIndex;
				leftChild = 2 * index + 1;
				rightChild = 2 * index + 2;
			}

		}

		return temp;
	}

}
