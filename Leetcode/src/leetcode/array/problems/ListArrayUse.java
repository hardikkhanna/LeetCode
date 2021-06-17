/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 14-Apr-2021 Time : 3:55:17 pm
 */
public class ListArrayUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListArray<Integer> list = new ListArray<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}
		for (int i = 0; i < 10; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println(list.getSize());
		list.remove(2);
		list.remove(0);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		for (int i = 0; i < list.getSize(); i++) {
			System.out.print(list.get(i) + " ");
		}
		StringBuilder str;
	}

}
