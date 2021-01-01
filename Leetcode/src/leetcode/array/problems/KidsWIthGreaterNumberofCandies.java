package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

public class KidsWIthGreaterNumberofCandies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		int extraCandies = sc.nextInt();
		List<Boolean> result = kidsWithCandies(array, extraCandies);
		System.out.println(result);
		sc.close();
	}

	/**
	 * @param array
	 * @param extraCandies
	 * @return
	 */
	private static List<Boolean> kidsWithCandies(int[] array, int extraCandies) {
		OptionalInt max = Arrays.stream(array).max();
		List<Boolean> result = new ArrayList<Boolean>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] + extraCandies >= max.getAsInt()) {
				result.add(true);
			} else {
				result.add(false);
			}
		}
		return result;
	}

}
