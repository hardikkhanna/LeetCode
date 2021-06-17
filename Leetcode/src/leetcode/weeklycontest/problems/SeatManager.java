/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 01-May-2021 Time : 8:20:54 pm
 */
public class SeatManager {
	private List<Integer> list;
	private int capacity;

	public SeatManager(int n) {
		this.capacity = n;
		this.list = new ArrayList<Integer>(capacity);
		loadData();
	}

	public int reserve() {
		int num = this.list.get(0);
		list.remove(0);
		return num;
	}

	public void unreserve(int seatNumber) {
		int index = 0;
		for(int i =0;i<list.size();i++) {
			if(list.get(i) > seatNumber) {
				index = i;
				break;
			}
		}
		list.add(index, seatNumber);
	}

	private void loadData() {
		for (int i = 0; i < capacity; i++) {
			list.add(i + 1);
		}
	}
}















/*["SeatManager","reserve","reserve","unreserve","unreserve","reserve","unreserve","reserve","unreserve"]
[[3],[],[],[1],[2],[],[1],[],[1]]
*/
