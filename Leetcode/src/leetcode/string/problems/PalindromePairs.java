/**
 * 
 */
package leetcode.string.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-57
 *
 *         Date : 13-Jun-2021 Time : 4:24:59 pm
 */
public class PalindromePairs extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = get1DStringArray();
		List<List<Integer>> ans = palindromePairs(words);
		for (List<Integer> l : ans) {
			System.out.print(l + " ");
		}

	}

	/**
	 * @param words
	 * @return
	 */
	private static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> list = new ArrayList<>();
		Set<String> st = new HashSet<String>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if ((i != j && isPalindrome(words[i] + words[j])) || (i != j && st.contains(words[i] + words[j]))) {
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(i);
					arr.add(j);
					list.add(arr);
					st.add(words[i] + words[j]);
				}
			}
		}
		return list;
	}

	private static boolean isPalindrome(String word) {

		int start = 0;
		int end = word.length() - 1;
		while (start < end) {
			if (word.charAt(start) != word.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}

}
