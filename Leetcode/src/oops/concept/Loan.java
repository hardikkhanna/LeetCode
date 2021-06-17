/**
 * 
 */
package oops.concept;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 7:33:07 pm
 */
abstract class Loan {

	protected double rate;

	public abstract void getRate(double rate);

	public void calculateLoan(double loanamount, int years) {
		double EMI;
		int n;

		n = years * 12;
		rate = rate / 1200;
		EMI = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1)) * loanamount;

		System.out.println("your monthly EMI is " + EMI + " for the amount" + loanamount + " you have borrowed");
	}

}
