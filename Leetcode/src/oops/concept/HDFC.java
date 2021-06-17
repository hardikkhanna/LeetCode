/**
 * 
 */
package oops.concept;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 7:26:23 pm
 */
public class HDFC implements Bank {

	private String name;

	/**
	 * 
	 */
	public HDFC() {
		name = "HDFC BANK";
	}

	@Override
	public String getName() {
		return name;

	}

}
