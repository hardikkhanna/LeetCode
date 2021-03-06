/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 16-Apr-2021 Time : 5:27:23 pm
 */
public class StringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str2 = sc.next();
		Boolean check = checkIfRotated(str,str2);
		System.out.println(check);
		sc.close();
	}
	
	private static boolean checkIfRotated(String input1, String input2) {
		
		// check for base cases
		if(input1 == null || input2 == null) return false;
		if(input1.length() == 0 || input2.length() == 0) return false;
		if(input1.length() != input2.length()) return false;
		
		
		String firstCharacter = "" + input1.charAt(0);
		
		
		// check for Index of firstCharacter in input2
		int index = input2.lastIndexOf(firstCharacter);
		
		// if firstCharacter is not present in input2
		// then the strings are different and return false
		if(index == -1) return false;
		
		String firstHalf = input2.substring(index);
		String secondHalf = input2.substring(0,index);
		
		return input1.equals(firstHalf + secondHalf);
		
	}

}
