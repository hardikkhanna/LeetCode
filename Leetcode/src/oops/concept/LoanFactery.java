/**
 * 
 */
package oops.concept;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 7:45:39 pm
 */
public class LoanFactery implements AbstractFactory{

	public Loan getLoan(String type) {
		Loan loan = null;

		if (type == null) {
			return loan;
		}
		if (type.equalsIgnoreCase("homeLoan")) {
			loan = new HomeLoan();
		} else if (type.equalsIgnoreCase("BusinessLoan")) {
			loan = new BusinessLoan();
		} else if (type.equalsIgnoreCase("EducationLaon")) {
			loan = new EducationLoan();
		}

		return loan;
	}

	@Override
	public Bank getBank(String name) {
		return null;
	}



}
