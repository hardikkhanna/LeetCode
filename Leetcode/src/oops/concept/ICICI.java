/**
 * 
 */
package oops.concept;

/**
 * @author Hardik
 *
 *         Date : 27-Apr-2021 Time : 7:28:01 pm
 */
public class ICICI implements Bank {

	private String name;

	/**
	 * 
	 */
	public ICICI() {
		this.name = "ICICI Bank";
	}

	@Override
	public String getName() {
		return this.name;

	}

}
