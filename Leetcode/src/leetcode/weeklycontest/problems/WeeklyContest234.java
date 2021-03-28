/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Mar 28, 2021 Time : 8:36:00 AM
 */
public class WeeklyContest234 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int count = numDifferent(str);
		System.out.println(count);
		int n = sc.nextInt();

		count = reinitializePermutation(n);
		str = sc.next();
		List<List<String>> knowledge = new ArrayList<>();
		List<String> sub = new ArrayList<>();
		sub.add("name");
		sub.add("bob");
		knowledge.add(sub);
		sub = new ArrayList<>();
		sub.add("age");
		sub.add("two");
		knowledge.add(sub);
		str = evaluate(str, knowledge);
		System.out.println(str);
		sc.close();
	}

	/**
	 * @param str
	 * @param knowledge
	 * @return
	 */
	private static String evaluate(String str, List<List<String>> knowledge) {
		HashMap<String, String> map = new HashMap<>();
		for (List<String> list : knowledge) {
			map.put(list.get(0), list.get(1));
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				int index = str.indexOf(')');
				String value = map.getOrDefault(str.substring(i + 1, index), "?");
				str = str.substring(0, i) + value + str.substring(index + 1);
			}
		}
		return str;
	}

	/**
	 * @param prem
	 * @return
	 */
	private static int reinitializePermutation(int n) {
		int[] prem = new int[n];
		for (int i = 0; i < prem.length; i++) {
			prem[i] = i;
		}
		int[] original = new int[n];
		for (int i = 0; i < original.length; i++) {
			original[i] = prem[i];
		}
		int[] arr = new int[prem.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = prem[i];
		}
		int count = 0;
		while (true) {
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 0) {
					arr[i] = prem[i / 2];
				} else {
					arr[i] = prem[n / 2 + (i - 1) / 2];
				}
			}
			for (int i = 0; i < prem.length; i++) {
				prem[i] = arr[i];
			}
			count++;
			if (Arrays.equals(arr, original))
				break;
		}
		return count;
	}

	/**
	 * @param str
	 * @return
	 */
	private static int numDifferent(String word) {
		HashSet<BigInteger> set = new HashSet<BigInteger>();
		for (int i = 0; i < word.length(); i++) {
			if (Character.isDigit(word.charAt(i))) {
				int j = i + 1;
				while (j < word.length() && Character.isDigit(word.charAt(j))) {
					j++;
				}

				BigInteger b = new BigInteger(word.substring(i, j));
				set.add(b);
				i = j;
			}
		}
		return set.size();
	}

}
