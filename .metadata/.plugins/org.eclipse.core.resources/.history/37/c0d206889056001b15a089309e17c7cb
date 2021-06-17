/**
 * 
 */
package leetcode.array.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 14, 2021 Time : 4:45:09 PM
 */
public class StudentsUnableToEatLunch extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] students = get1DArray();
		int[] sandwichdes = get1DArray();
		int ans = countStudents(students, sandwichdes);
		System.out.println(ans);

	}

	/**
	 * @param students
	 * @param sandwichdes
	 * @return
	 */
	public static int countStudents(int[] A, int[] B) {
		int count[] = { 0, 0 }, n = A.length, k;
		for (int a : A)
			count[a]++;
		for (k = 0; k < n && count[B[k]] > 0; ++k)
			count[B[k]]--;
		return n - k;
	}

}
