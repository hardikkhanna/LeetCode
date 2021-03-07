/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Set;

/**
 * @author NIPC-43
 *
 * Date : Feb 23, 2021
 * Time : 11:33:53 AM
 */

class MyThread extends Thread{
	
	MyThread(){
		System.out.println("MyThread");
	} 
	
	public void run() {
		System.out.println("run");
	}
	
	public void run(String s) {
		System.out.println("run with params");
	}
}

public class MCQ {

	public static void main(String[] args) {
		Thread t = new MyThread() {
			public void run() {
				System.out.println("Hi");
			}
		};
		t.start();
	}

}
