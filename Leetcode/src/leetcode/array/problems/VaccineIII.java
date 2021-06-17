/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 23-May-2021 Time : 10:48:10 pm
 */
public class VaccineIII {

	public static void main(String[] args) throws java.lang.Exception {
		FastReader sc = new FastReader();
		int t = sc.nextInt();
		while (t-- > 0) {
			long position = sc.nextLong();
			long limit = sc.nextLong();
			long[] ageGroup = new long[10];
			for (int i = 0; i < 10; i++) {
				ageGroup[i] = sc.nextLong();
			}
			long[] ans = findMinAndMaxDays(ageGroup, position, limit);
			System.out.println(ans[0] + " " + ans[1]);
		}
	}

	private static long[] findMinAndMaxDays(long[] ageGroup, long position, long limit) {
		long min = 1;
		long max = 1;
		long sum = 0;
		int i = ageGroup.length - 1;
		for (; i >= 0; i--) {
			if (i == position)
				break;
			sum += ageGroup[i];
		}
		min = sum / (limit + 1);
		max = sum / (limit + ageGroup[i]);
		return new long[] {min, max};
	}

}
