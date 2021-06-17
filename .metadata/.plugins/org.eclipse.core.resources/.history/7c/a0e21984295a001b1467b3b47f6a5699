package leetcode.array.problems;

import java.util.Arrays;
import java.util.Scanner;

public class RichestCustomerHealth {

	public static int maximumWealth(int[][] accounts) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < accounts.length; i++) {
			int sum = Arrays.stream(accounts[i]).sum();
			if (sum > max) {
				max = sum;
			}
		}
		return max;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] array = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		System.out.println(maximumWealth(array));
		sc.close();
	}

}
