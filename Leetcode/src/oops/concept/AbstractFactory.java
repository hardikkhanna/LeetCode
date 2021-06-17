/**
 * 
 */
package oops.concept;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 7:50:29 pm
 */
public interface AbstractFactory {

	public Bank getBank(String name);

	public Loan getLoan(String type);

}
