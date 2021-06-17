/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 15-May-2021 Time : 7:57:58 pm
 */
public class BiWeeklyContest52 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		int memory1 = sc.nextInt();
//		int memory2 = sc.nextInt();
//		int[] ans = memLeak(memory1, memory2);
//		for (int i = 0; i < ans.length; i++) {
//			System.out.print(ans[i] + " ");
//		}

//		char[][] box = { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' },
//				{ '#', '#', '#', '.', '#', '.' } };
//		
//
//		box = rotateTheBox(box);
//		for (int i = 0; i < box.length; i++) {
//			for (int j = 0; j < box[i].length; j++) {
//				System.out.print(box[i][j] + " ");
//			}
//		}
		int[] nums = get1DArray();
		int ans = sum(nums);
		System.out.println(ans);
	}

	/**
	 * @param nums
	 * @return
	 */
	static int N = (int) 3e5;

	private static int sum(int[] arr) {
		// Stores frequency of
		// array element
		int n = arr.length;
		int freq[] = new int[N];

		// Stores prefix sum
		// array of frequency[]
		int preFreq[] = new int[N];

		// Traverse the array
		for (int i = 0; i < n; i++) {

			// Update frequency
			// of arr[i]
			freq[arr[i]]++;
		}

		// Compute the prefix sum
		// of frequency[]
		for (int i = 1; i < N; i++) {
			preFreq[i] = preFreq[i - 1] + freq[i];
		}

		// Stores the sum of Math.floor(a[i]/a[j])
		// of all pairs (i, j)
		int ans = 0;

		// Iterate over the range [1, Max]
		for (int i = 1; i < N; i++) {

			// Find the count of numbers in
			// the range [i * K, i * (K + 1))
			// and update the result
			for (int j = i; j < N; j += i) {

				// Stores count of numbers
				// in range[j - i - 1, j - 1]
				int X = (preFreq[j - 1] - preFreq[Math.abs(j - i - 1)]);

				// Update ans
				ans += X * (j / i - 1) * freq[i];
			}
		}

		// Print the answer
		return ans;
	}

	/**
	 * @param box
	 * @return
	 */
	private static char[][] rotateTheBox(char[][] box) {
		for (char[] arr : box) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '*')
					break;
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] == '*') {
						break;
					}
					if (arr[j] == '.') {
						swap(arr, i, j);
						break;
					}
				}
			}
		}

		rotate(box);
		printArray(box);
		return box;
	}

	/**
	 * @param box
	 */
	private static void printArray(char[][] box) {
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				System.out.print(box[i][j] + " ");
			}
		}
	}

	public static void rotate(char[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer <= n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				char top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}

	/**
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/**
	 * @param memory1
	 * @param memory2
	 * @return
	 */
	private static int[] memLeak(int memory1, int memory2) {
		if (memory1 == 0 && memory2 == 0) {
			return new int[] { 1, memory1, memory2 };
		}

		int[] ans = new int[3];

		int count = 1;
		while (true) {
			if (memory1 >= memory2 && memory1 >= count) {
				memory1 -= count;
				count++;
			} else if (memory2 >= count) {
				memory2 -= count;
				count++;
			} else {
				break;
			}
		}

		ans[0] = count;
		ans[1] = memory1;
		ans[2] = memory2;
		return ans;
	}

}
