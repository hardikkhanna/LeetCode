/**
 * 
 */
package oops.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 15-Apr-2021 Time : 11:45:57 am
 */

class Pair {
	String path;
	int data;

	Pair(int data, String path) {
		this.data = data;
		this.path = path;
	}
}

public class Main {

	/**
	 * 
	 */

	/**
	 * 
	 */
	private static void method1() {

	}

	public Main() {
		// Goldman 2d array

//		int[][] arr = { { 3, 2, 3, 1 }, { 2, 4, 6, 0 }, { 5, 0, 1, 3 }, { 9, 1, 5, 1 } };
//		// Q2. Given an array of integers print all subsets which add upto target
//		// input arr[] = 4 2 7 1 3    target = 10;
//		// output -> [7,3] , [2 7 1], [4,2,1,3], 
//		find(arr);
		int i = 1 / 2;
		System.out.println(i);
	}

	/**
	 * @param arr
	 */
	private void find(int[][] arr) {
		Pair[][] dp = new Pair[arr.length][arr[0].length];
		for (int j = arr[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < arr.length; i++) {
				if (j == arr[0].length - 1) {
					Pair p = new Pair(arr[i][j], String.valueOf(arr[j]));
					dp[i][j] = p;
				} else if (i == 0) {
					int max = Math.max(dp[i][j + 1].data, dp[i + 1][j + 1].data);
					// Pair p = new Pair()
				}
			}
		}

	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter bank name");
//		String bankName = sc.next();
//		System.out.println("Enter type of loan");
//		String loanType = sc.next();
//		// sc.next();
//		AbstractFactory banFactory = FactoryCreator.getFactory("bank");
//		Bank bank = banFactory.getBank(bankName);
//		AbstractFactory loanFactory = FactoryCreator.getFactory("loan");
//		Loan loan = loanFactory.getLoan(loanType);
//
//		System.out.println("Enter the rate of interest for " + bank.getName());
//		Double rate = sc.nextDouble();
//
//		System.out.println("Enter loan amount you want ");
//		Double amount = sc.nextDouble();
//
//		System.out.println("Enter the number of years");
//		int years = sc.nextInt();
//
//		loan.getRate(rate);
//		loan.calculateLoan(amount, years);
//		sc.close();
		// List<Integer> arr = Arrays.asList({20 28 36 29 21 13 5 14 23 30 39 40});
		String[] arr = new String[] { "A", "B", "C" };
		List<String> list1 = Arrays.asList(arr);
		List<String> list2 = new ArrayList<>(Arrays.asList(arr));
		List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), "C"));
		System.out.println(list1.equals(list2));
		System.out.println(list1.equals(list3));
	}

}
