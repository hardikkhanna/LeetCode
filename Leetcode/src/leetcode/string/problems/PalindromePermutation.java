/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *
 *
 *         Given a string, write a function to check if it is a permutation of a
 *         palindrome. A palindrome is a word or phrase that is the same
 *         forwards and backwards. A permutation is a rearrangement of letters.
 *         The palindrome does not need to be limited to just dictionary words.
 *         1.5 1.6 EXAMPLE Input: Tact Coa Output: True (permutations: "taco
 *         cat", "atco eta", etc.)
 * 
 * 
 * 
 *         Date : 14-Apr-2021 Time : 9:08:42 pm
 */
public class PalindromePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		boolean ans = checkStringPermutation(input);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param input
	 * @return
	 */
	private static boolean checkStringPermutation(String input) {
		int[] table = buildFrequencyTable(input);
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}

	/**
	 * Count How many times each character appears in the String
	 * 
	 * @param input
	 * @return Array storing the frequency of each character in the input String
	 */
	private static int[] buildFrequencyTable(String input) {
		int[] table = new int[26];
		for (char c : input.toCharArray()) {
			int index = getCharIndex(c);
			if (index != -1)
				table[index]++;
		}
		return table;
	}

	/**
	 * 
	 * Map each character to a number. a -> 0, b -> 1, c -> 2, etc. This is case
	 * insensitive. Non-letter characters map to -1.
	 *
	 * 
	 * @param character
	 * @return index of character between
	 */

	private static int getCharIndex(char c) {
		int val = Character.getNumericValue(c);
		int lower_bound = Character.getNumericValue('a');
		int upper_bound = Character.getNumericValue('z');
		if (val >= lower_bound && val <= upper_bound)
			return val - lower_bound;
		return -1;
	}

}
