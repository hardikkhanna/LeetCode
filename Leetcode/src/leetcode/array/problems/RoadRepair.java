/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 23, 2021 Time : 3:17:16 PM
 */
public class RoadRepair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> crew_id = new ArrayList<Integer>();
		List<Integer> job_id = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			crew_id.add(sc.nextInt());
		}
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			job_id.add(sc.nextInt());
		}

		long ans = getMinCost(crew_id, job_id);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param crew_id
	 * @param job_id
	 * @return
	 */
	private static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
		int[] freq = new int[100000];
		Collections.sort(crew_id);
		Collections.sort(job_id);
		long ans = 0;
		int j = 0;
		for (int i = 0; i < crew_id.size(); i++) {
			if ((job_id.contains(crew_id.get(i)))) {
				if (crew_id.contains(job_id.get(crew_id.get(i)))) {
					j++;
				} else {
					freq[crew_id.get(i)] = 1;
					job_id.remove(crew_id.get(i));
					continue;
				}
			}
			if (i == job_id.size())
				return ans;
			ans += Math.abs(crew_id.get(i) - job_id.get(j++));
		}
		/*
		 * int j = 0; for (int i = 0; i < list1.size() && j < list2.size(); i++) { ans
		 * += Math.abs(list1.get(i) - list2.get(j++)); }
		 */
		return ans;
	}

}
