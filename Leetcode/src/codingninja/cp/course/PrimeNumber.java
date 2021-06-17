/**
 * 
 */
package codingninja.cp.course;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 29-May-2021 Time : 1:34:10 pm
 * 
 *         Find first N prime numbers
 */
public class PrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		// Method 1
		for (int i = 2; i <= n; i++) {
			if (checkPrime(i)) {
				count++;
			}
		}
		System.out.println("Answer from 1st Method = " + count);

		// Method 2
		count = 0;
		for (int i = 2; i <= n; i++) {
			if (checkPrimeBetter(i)) {
				count++;
			}
		}
		System.out.println("Answer from 2nd Method = " + count);

		// Method 3
		// Seive Of Erostesis
		count = 0;
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
				count++;
			}
		}
		System.out.println("Answer from 3rd Method = " + count);
		sc.close();
	}

	/**
	 * @param i
	 * @return
	 */
	private static boolean checkPrimeBetter(int num) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (i * i == num) {
				count++;
			} else if (num % i == 0) {
				count += 2;
			}
		}
		return count == 2;
	}

	/**
	 * @param i
	 * @return
	 */
	private static boolean checkPrime(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}

		return count == 2;
	}

}
