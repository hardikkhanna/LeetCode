/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : Feb 14, 2021 Time : 5:14:59 PM
 */
public class OurMapUse {

	public static void main(String[] args) {
		Map<String, Integer> map = new Map<String, Integer>();
		for (int i = 0; i < 20; i++) {
			map.insert("abc" + i, 1 + i);
			System.out.println("i = " + i + " lf = " + map.loadFactor());
		}

		map.removeKey("abc3");
		map.removeKey("abc7");

		for (int i = 0; i < 20; i++) {
			System.out.println("abc" + i + ":" + map.getValue("abc" + i));
		}

		MyHashMap obj = new MyHashMap();
		obj.remove(14);
		for (int i = 0; i < 20; i++) {
			obj.put(i, 1 + i);
			// System.out.println("i = " + i + " lf = " + map.loadFactor());
		}
		int param_2 = obj.get(1);
		System.out.println(param_2);
		obj.remove(1);
		for (int i = 0; i < 20; i++) {
			System.out.println("abc" + i + ":" + obj.get(i));
		}
	}

}