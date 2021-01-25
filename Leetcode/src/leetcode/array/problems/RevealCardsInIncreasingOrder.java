/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardik
 *
 *         Date : Jan 24, 2021 Time : 5:07:25 PM
 */
public class RevealCardsInIncreasingOrder extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		arr = deckRevealedIncreasing(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	/**
	 * @param arr
	 * @return
	 */
	public static int[] deckRevealedIncreasing(int[] deck) {
		int n= deck.length;
        Arrays.sort(deck);
        Queue<Integer> q= new LinkedList<>();
        for (int i=0; i<n; i++) q.add(i);
        int[] res= new int[n];
        for (int i=0; i<n; i++){
            res[q.poll()]=deck[i];
            q.add(q.poll());
        }
        return res;
	}

}
