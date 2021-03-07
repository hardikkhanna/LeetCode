/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author NIPC-43
 *
 * Date : Mar 7, 2021
 * Time : 7:27:48 AM
 */
public class DistributeCandies extends ScannerInput{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candyType = get1DArray();
		int ans = distributeCandies(candyType);
		System.out.println(ans);
	}

	/**
	 * @param candyType
	 * @return
	 */
	private static int distributeCandies(int[] candyType) {
		int n = candyType.length / 2;
        int type = (int) Arrays.stream(candyType).distinct().count();
        
        
        return n < type ? n : type;
	}

}
