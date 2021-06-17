/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * 
 * <b>Question</b> There are three types of edits that can be performed on
 * strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero
 * edits) away <br>
 * EXAMPLE <br>
 * pale, ple -> true <br>
 * pales, pale -> true <br>
 * pale, bale -> true <br>
 * pale, bake -> false <br>
 *
 * @author Hardik <br>
 *         Date : 14-Apr-2021 Time : 10:00:17 pm
 */
public class OneWay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2 = sc.next();
		// Time Complexity : O(N) where N is size of the bigger String Space Comlecity :
		// O(1)
		boolean checkOneWay = oneWayExist(input1, input2);

		// Approach 2 : Optimization over above approach
		// removing redundant code
		boolean checkOneWayBetter = oneWayExistBetter(input1, input2);

		System.out.println(checkOneWay);

		System.out.println(checkOneWayBetter);
		sc.close();
	}

	/**
	 * @param input1
	 * @param input2
	 * @return
	 */
	private static boolean oneWayExistBetter(String input1, String input2) {
		if (Math.abs(input1.length() - input2.length()) > 1)
			return false;

		String largerString = input1.length() > input2.length() ? input1 : input2;
		String smallerString = input1.length() > input2.length() ? input2 : input1;

		int count_diff = 0;
		int j =0,i=0;
		for (i = 0; i < largerString.length() && j < smallerString.length(); i++, j++) {
			if (largerString.charAt(i) != smallerString.charAt(j)) {
				count_diff++;
			}
		}
		if(i < largerString.length()) count_diff += largerString.length() - i;
		return count_diff <= 1;
	}

	/**
	 * @param input1 String1
	 * @param input2 Stirng2
	 * @return whether there is a way to convert String1 to String2
	 */
	private static boolean oneWayExist(String input1, String input2) {
		if (Math.abs(input1.length() - input2.length()) > 1)
			return false;
		String larger = input1.length() > input2.length() ? input1 : input2;
		String smaller = input1.length() > input2.length() ? input2 : input1;
		int[] table = buildFrequencyTable(larger);
		return checkIfOneWayExist(table, smaller);
	}

	/**
	 * @param table
	 * @param smaller
	 * @return
	 */
	private static boolean checkIfOneWayExist(int[] table, String smaller) {
		int count_diif = 0;
		for (int i = 0; i < smaller.length(); i++) {
			int index = getCharIndex(smaller.charAt(i));
			if (index != -1) {
				if (table[index] <= 0) {
					count_diif++;
				}
				table[index]--;
			}
		}
		return count_diif <= 1;
	}

	/**
	 * @param input1 String
	 * @return
	 */
	private static int[] buildFrequencyTable(String input1) {
		int[] freq = new int[26];
		for (char c : input1.toCharArray()) {
			int index = getCharIndex(c);
			if (index != -1) {
				freq[index]++;
			}
		}
		return freq;
	}

	/**
	 * @param c
	 * @return
	 */
	private static int getCharIndex(char c) {
		int lower_bould = Character.getNumericValue('a');
		int upper_bound = Character.getNumericValue('z');
		int value = Character.getNumericValue(c);
		if (value >= lower_bould && value <= upper_bound) {
			return value - lower_bould;
		}
		return -1;
	}

}
