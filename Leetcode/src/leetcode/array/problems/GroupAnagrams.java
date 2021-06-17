/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 06-May-2021 Time : 1:14:28 am
 */
public class GroupAnagrams extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = get1DStringArray();
		// Approach 1 
		// Time Complexity : O(n2);
		// Space Complexity : O(n)
		List<List<String>> ans = groupAnagram(strs);
		for (List<String> list : ans) {
			System.out.println(list);
		}
		
		// Approach 2
		

	}

	/**
	 * @param strs
	 * @return
	 */
	private static List<List<String>> groupAnagram(String[] strs) {
		// check for base cases
		if (strs == null || strs.length == 0)
			return null;

		List<List<String>> ans = new ArrayList<>();

		Boolean visited[] = new Boolean[strs.length];
		Arrays.fill(visited, false);

		// Loop through the array
		for (int i = 0; i < strs.length; i++) {
			if (!visited[i]) {

				ArrayList<String> list = new ArrayList<>();
				list.add(strs[i]);
				visited[i] = true;
				int[] ithFreq = buildArray(strs[i]);
				for (int j = i + 1; j < strs.length; j++) {

					int[] jthIndex = buildArray(strs[j]);
					if (Arrays.equals(ithFreq, jthIndex)) {
						visited[j] = true;
						list.add(strs[j]);
					}

				}
				ans.add(list);
			}
		}
		return ans;
	}

	private static int[] buildArray(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}

		int[] freq = new int[26];
		for (int i = 0; i < str.length(); i++) {
			freq[str.charAt(i) - 'a']++;
		}
		return freq;
	}

}
