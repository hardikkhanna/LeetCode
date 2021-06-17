/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : Jan 1, 2021 Time : 10:15:55 PM
 */
public class DesignOrderedStream {
	private String[] values;
	private int ptr;

	public DesignOrderedStream(int n) {
		values = new String[n];
		ptr = 0;
	}

	public List<String> insert(int id, String value) {
		values[id - 1] = value;

		List<String> result = new ArrayList<>();
		while (ptr < values.length && values[ptr] != null) {
			result.add(values[ptr++]);
		}

		return result;
	}

}
