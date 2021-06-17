/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.HashMap;
import java.util.HashSet;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 01-May-2021 Time : 8:20:44 pm
 */
public class BiWeekly extends ScannerInput {
	public static void main(String[] args) {
//		SeatManager seatManager = new SeatManager(5);
//		
//		System.out.println(seatManager.reserve());
//		System.out.println(seatManager.reserve());
//		seatManager.unreserve(2);
//		System.out.println(seatManager.reserve());
//		System.out.println(seatManager.reserve());
//		System.out.println(seatManager.reserve());
//		System.out.println(seatManager.reserve());
//		seatManager.unreserve(5);

		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		
		
		int[][] rooms = get2DArray();
		int[][] queries = get2DArray();
		int[] ans = closestRoom(rooms, queries);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	/**
	 * @param rooms
	 * @param queries
	 * @return
	 */
	private static int[] closestRoom(int[][] rooms, int[][] queries) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < rooms.length; i++) {
			map.put(rooms[i][0], rooms[i][1]);
		}

		int[] ans = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {

			int preferred = queries[i][0];
			int minSize = queries[i][1];
			int ithans = -1;
			int min = Integer.MAX_VALUE;

			for (int j : map.keySet()) {
				if (minSize <= map.get(j)) {
					if(min > preferred - j) {
						ithans = j;
						min = preferred - j;
					}
					
				}
			}
			ans[i] = ithans;

		}
		return ans;
	}

}

/*
 * 3 2 2 2 1 2 3 2 3 2 3 1 3 3 5 2
 */
