/**
 * 
 */
package leetcode.array.problems;

import java.util.List;

/**
 * @author Hardik
 *
 *         Date : Feb 12, 2021 Time : 5:46:48 PM
 */
public class ThreadTask implements Runnable {

	volatile int sum;
	private List<Integer> subList;
	private int threadCount;

	public ThreadTask(List<Integer> subList, int threadCount) {
		this.subList = subList;
		this.threadCount = threadCount;
	}

	@Override
	public void run() {
		for (int i = 0; i < subList.size(); i++) {
			sum += subList.get(i);
		}
		System.out.println("*** Sum Processed by Thread " + threadCount);
	}

}
