/**
 * 
 */
package leetcode.priorityQueue.problems;

import java.util.ArrayList;

/**
 * @author Hardik
 *
 *         Date : 07-May-2021 Time : 3:01:11 pm
 */
public class MinHeap {

	private ArrayList<Integer> heap;

	public MinHeap() {
		heap = new ArrayList<Integer>();
	}

	public boolean isEmpty() {
		return heap.size() == 0;
	}

	public int getSize() {
		return heap.size();
	}

	public int getMin() throws PrioritQueueException {
		if (heap.size() == 0) {
			throw new PrioritQueueException();
		}
		return heap.get(0);
	}

	public void insert(int element) {

		heap.add(element);

		// Upward Heapify
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {

			if (heap.get(parentIndex) > heap.get(childIndex)) {
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

	public int removeMin() throws PrioritQueueException {
		if(isEmpty()) {
			throw new PrioritQueueException();
		}
		int temp = heap.get(0);

		heap.set(0, heap.get(heap.size() - 1));	
		heap.remove(heap.size() - 1);

		// Dowmward Heapify
		int index = 0;
		int minIndex = index;
		int leftChild = 2 * minIndex + 1;
		int rightChild = 2 * minIndex + 2;

		while (leftChild < heap.size()) {

			if (heap.get(leftChild) < heap.get(minIndex)) {
				minIndex = leftChild;
			}
			if (rightChild < heap.size() && heap.get(rightChild) < heap.get(minIndex)) {
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
