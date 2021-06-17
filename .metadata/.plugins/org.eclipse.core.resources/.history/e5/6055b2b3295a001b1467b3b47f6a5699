/**
 * 
 */
package leetcode.string.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 18, 2021 Time : 11:25:46 PM
 */
public class RobotReturnToOrigin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "UD";
		Boolean ans = judgeCircle(str);
		System.out.println(ans);

	}

	/**
	 * @param str
	 * @return
	 */
	private static Boolean judgeCircle(String moves) {
		int leftCount = 0;
		int rightCount = 0;
		int upCount = 0;
		int downCount = 0;
		for (int i = 0; i < moves.length(); i++) {
			if (moves.charAt(i) == 'U') {
				upCount++;
			} else if (moves.charAt(i) == 'D') {
				downCount++;
			} else if (moves.charAt(i) == 'R') {
				rightCount++;
			} else if (moves.charAt(i) == 'L') {
				leftCount++;
			}
		}
		if (leftCount == rightCount && upCount == downCount) {
			return true;
		}
		return false;
	}

}
