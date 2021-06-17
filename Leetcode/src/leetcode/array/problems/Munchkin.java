/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 12-Apr-2021 Time : 10:33:35 am
 */
public class Munchkin {

	/**
	 * @param args
	 */
	final static int M1 = 1;
	final static int M2 = 2;
	final static int M3 = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<String> list = new ArrayList<String>();
		while (n-- > 0) {
			list.add(sc.nextLine());
		}
		//list.remove(0);
		String maceType = sc.nextLine();
		int speed = getMaceSpeed(maceType);

		int munchkinsBooped = numberOfMunchkinsBooped(list, speed, maceType);


		System.out.print(munchkinsBooped);
		sc.close();
	}

	/**
	 * @param list
	 * @param speed
	 * @param maceType
	 * @return
	 */
	private static int numberOfMunchkinsBooped(List<String> list, int speed, String maceType) {
		int count = 0;

		int startRow = 0;
		int startCol = 0;

		for (String str : list) {

			String[] s = str.split(" ");
			String munchkinType = s[0];
			int row = Integer.valueOf(s[1]);
			int col = Integer.valueOf(s[2]);

			int horizontal = row - startRow;
			int vertical = col - startCol;
			int totalDistance = Math.abs(horizontal) + Math.abs(vertical);

			if (totalDistance > speed * 2) {
				if (Math.abs(horizontal) >= Math.abs(vertical)) {
					if (horizontal > speed * 2)
						startRow = speed * 2;
					else {
						startRow += horizontal;
						totalDistance -= Math.abs(horizontal);
					}
					startCol += totalDistance;
				} else {
					if (vertical > speed * 2)
						startCol = speed * 2;
					else {
						startCol += vertical;
						totalDistance -= Math.abs(vertical);
					}
					startRow += totalDistance;
						
				}
			} else {
				startRow = row;
				startCol = col;
				if ((munchkinType.equals("P1") && maceType.equals("M1")) || (munchkinType.equals("P2") && maceType.equals("M2"))
						|| (munchkinType.equals("P3") && maceType.equals("M3"))) {
					count++;
				}
			}

		}
		return count;
	}

	/**
	 * @param maceType
	 * @return
	 */
	private static int getMaceSpeed(String maceType) {
		if (maceType.equals("M1"))
			return 1;
		if (maceType.equals("M2"))
			return 2;
		return 3;
	}

}
