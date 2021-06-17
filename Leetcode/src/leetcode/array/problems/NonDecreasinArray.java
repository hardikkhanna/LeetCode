/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 14-May-2021 Time : 5:07:15 pm
 */
public class NonDecreasinArray extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		while (t-- > 0) {
		int[] arr = get1DArray();
		Boolean ans = isPossible(arr, arr.length);
		System.out.println(ans);
//		}
//		sc.close();
		// ArrayList<Integer> arr = new ArrayList<Integer>();
//		if (arr == null || arr.size() == 0)
//			return null;

		// ArrayList<Integer> ans = new ArrayList<Integer<>();

	}

	/**
	 * @param arr
	 * @param length
	 * @return
	 */
	private static Boolean isPossible(int[] arr, int length) {
		if (arr == null || arr.length <= 1)
			return true;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1] || arr[i + 1] <= max) {
				i++;
				while (i < arr.length) {
					if (arr[i] < max)
						return false;
					max = arr[i];
					i++;
				}
				break;
			} else {
				max = arr[i];
			}
		}

		return true;
	}

}
