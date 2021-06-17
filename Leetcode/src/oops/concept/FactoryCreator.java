/**
 * 
 */
package oops.concept;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 8:19:09 pm
 */
public class FactoryCreator {	

	public static AbstractFactory getFactory(String name) {
		AbstractFactory fact = null;
		if (name.equalsIgnoreCase("bank")) {
			fact = new BankFactory();
		} else if (name.equalsIgnoreCase("loan")) {
			fact = new LoanFactery();
		}
		return fact;
	}

}
