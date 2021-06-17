/**
 * 
 */
package leetcode.priorityQueue.problems;

/**
 * @author Hardik
 *
 *         Date : 08-May-2021 Time : 10:39:29 am
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 9, 8, 1, 2, 6, 5, 3, 2, 0 };
		sort(arr);
	}

	/**
	 * 
	 * There are 2 ways to sort it either by using minHeap or maxHeap In this
	 * example we have used minHeap and by using minHeap array will be sorted in
	 * descending order you can reverse the array to get the ascending order There
	 * is another option we can use maxHeap that will give us array in increasing
	 * order.
	 * 
	 * @param arr
	 */
	private static void sort(int[] arr) {

		// Add the elements one by one and maintain two properties
		// 1. CBT
		// 2. Heap order property
		for (int i = 1; i < arr.length; i++) {
			int childIndex = i;
			int parentIndex = (childIndex - 1) / 2;

			while (childIndex > 0 && arr[childIndex] < arr[parentIndex]) {

				int temp = arr[childIndex];
				arr[childIndex] = arr[parentIndex];
				arr[parentIndex] = temp;
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}
		}

		// Remove elements one by one
		int end = arr.length - 1;
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			int index = 0;
			int minIndex = index;
			int leftChild = 2 * minIndex + 1;
			int rightChild = 2 * minIndex + 2;

			while (leftChild < end) {

				if (arr[minIndex] > arr[leftChild]) {
					minIndex = leftChild;
				}
				if (rightChild < end && arr[minIndex] > arr[rightChild]) {
					minIndex = rightChild;
				}

				if (minIndex == index) {
					break;
				} else {
					int var = arr[index];
					arr[index] = arr[minIndex];
					arr[minIndex] = var;
					index = minIndex;
					leftChild = 2 * index + 1;
					rightChild = 2 * index + 2;
				}

			}
			arr[end--] = temp;

		}
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}

	}

}
