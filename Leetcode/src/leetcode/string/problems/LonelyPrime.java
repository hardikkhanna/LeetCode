/**
 * 
 */
package leetcode.string.problems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Feb 23, 2021 Time : 12:08:01 PM
 */
public class LonelyPrime {

	/**
	 * @param args
	 */
	//12, 3, 4, 5, 5, 4, 3, 2, 2, 21, 23, 40, 7, 6, 4, 7

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStirng = sc.nextLine();
		String[] str = inputStirng.replaceAll(", " , " ").split(" ");
		int ans = getLonelyString(str);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static int getLonelyString(String[] str) {
		int ans  = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<str.length;i++){
            boolean isPrime = true;
            int num = Integer.valueOf(str[i]);
            for(int j = 2;j<Math.sqrt(num);j++){
                if(num % j == 0){
                    isPrime  = false;
                    break;
                }
            }
            if(isPrime){
                if(!map.containsKey(num)){
                    map.put(num, 1);
                }else{
                    map.put(num, map.get(num) +1);
                }
            }
        }
        
        for(int i : map.keySet()) {
        	if(map.get(i) == 1) {
        		ans = i;
        		break;
        	}
        }
        
        return ans;
	}

}
