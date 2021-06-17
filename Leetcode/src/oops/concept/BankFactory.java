/**
 * 
 */
package oops.concept;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 7:28:36 pm
 */
public class BankFactory implements AbstractFactory {

	public Bank getBank(String type) {
		Bank b = null;
		if (type.equalsIgnoreCase("hdfc")) {
			b = new HDFC();
		} else if (type.equalsIgnoreCase("icici")) {
			b = new ICICI();
		} else if (type.equalsIgnoreCase("axis")) {
			b = new AXIS();
		}

		return b;
	}

	@Override
	public Loan getLoan(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
