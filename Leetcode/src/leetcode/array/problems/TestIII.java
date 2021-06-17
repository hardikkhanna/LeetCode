/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 15-May-2021 Time : 3:10:43 pm
 */
public class TestIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("String");
		fun(list);
		System.out.println(list);

	}

	/**
	 * @param list
	 */
	private static List<String> fun(List<String> list) {

		list.add("Hardik");
		return list;

	}

}
