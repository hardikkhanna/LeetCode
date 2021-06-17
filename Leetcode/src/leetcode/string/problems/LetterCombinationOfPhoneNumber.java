/**
 * 
 */
package leetcode.string.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 24-May-2021 Time : 10:37:15 pm
 */
public class LetterCombinationOfPhoneNumber {

	private static ArrayList<String> ans;
	private static StringBuilder result;
	private static HashMap<Character, String> map;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		ArrayList<String> string = combinations(str);
		System.out.println(string);
		sc.close();
	}

	/**
	 * 
	 * This function will find all letter combinations of a phone number
	 * 
	 * Input passed is a string of numbers e.g 23 
	 * Based on above input output will be 
	 * Output :- ad ae af bd be bf cd ce cf
	 * 
	 * @param str - Input String
	 * @return
	 */
	private static ArrayList<String> combinations(String str) {

		ans = new ArrayList<>();
		result = new StringBuilder();
		map =  new HashMap<>();
		preComputeMap();
		computePermutations(str);
		return ans;
	}

	/**
	 * 
	 */
	private static void preComputeMap() {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}

	/**
	 * @param str
	 */
	private static void computePermutations(String str) {

		if (str == null || str.length() == 0)
			return;

		String curr = map.get(str.charAt(0));
		for (int i = 0; i < curr.length(); i++) {
			result.append(curr.charAt(i)); // a
			computePermutations(str.substring(1));
			if (str.length() == 1)
				ans.add(result.toString());
			result.deleteCharAt(result.length() - 1);
		}

	}

}
